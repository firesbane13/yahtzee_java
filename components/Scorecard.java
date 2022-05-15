package components;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Scorecard {
    private Map<String, Integer> upperSection = new HashMap<String, Integer>();
    private Map<String, Integer> lowerSection = new HashMap<String, Integer>();

    private static final int ACES   = 1;
    private static final int TWOS   = 2;
    private static final int THREES = 3;
    private static final int FOURS  = 4;
    private static final int FIVES  = 5;
    private static final int SIXES  = 6;

    private static final int THREEOFAKIND  = 3;
    private static final int FOUROFAKIND   = 4;
    private static final int SMALLSTRAIGHT = 4;
    private static final int LARGESTRAIGHT = 5;
    private static final int YAHTZEE       = 5;

    public Scorecard() {
        upperSection.put("aces", null);
        upperSection.put("twos", null);
        upperSection.put("threes", null);
        upperSection.put("fours", null);
        upperSection.put("fives", null);
        upperSection.put("sixes", null);
        upperSection.put("bonus", null);
        upperSection.put("upperTotal", null);
        
        lowerSection.put("threeOfKind", null);
        lowerSection.put("fourOfKind", null);
        lowerSection.put("fullhouse", null);
        lowerSection.put("smallStraight", null);
        lowerSection.put("largeStraight", null);
        lowerSection.put("yahtzee", null);
        lowerSection.put("chance", null);
        lowerSection.put("yahtzeeBonus", null);
        lowerSection.put("lowerTotal", null);
    }

    /**
     * Check for Ones/Aces count or total points
     * 
     * @param diceRollResults
     * @return
     */
    public int checkAces(int[] diceRollResults) {
        int matchingCount;

        matchingCount = dieByValue(diceRollResults, ACES, true);

        return matchingCount;
    }

    /**
     * Check for Twos count or total points
     * 
     * @param diceRollResults
     * @return
     */
    public int checkTwos(int[] diceRollResults) {
        int matchingCount;

        matchingCount = dieByValue(diceRollResults, TWOS, true);

        return matchingCount;
    }

    /**
     * Check for Threes count or total points
     * 
     * @param diceRollResults
     * @return
     */
    public int checkThrees(int[] diceRollResults) {
        int matchingCount;

        matchingCount = dieByValue(diceRollResults, THREES, true);

        return matchingCount;
    }

    /**
     * Check for Fours count or total points
     * 
     * @param diceRollResults
     * @return
     */
    public int checkFours(int[] diceRollResults) {
        int matchingCount;

        matchingCount = dieByValue(diceRollResults, FOURS, true);

        return matchingCount;
    }

    /**
     * Check for Fives count or total points
     * 
     * @param diceRollResults
     * @return
     */
    public int checkFives(int[] diceRollResults) {
        int matchingCount;

        matchingCount = dieByValue(diceRollResults, FIVES, true);

        return matchingCount;
    }

    /**
     * Check Sixes count or total points
     * 
     * @param diceRollResults
     * @return
     */
    public int checkSixes(int[] diceRollResults) {
        int matchingCount;

        matchingCount = dieByValue(diceRollResults, SIXES, true);

        return matchingCount;
    }

    /**
     * Check for a Three of a kind
     * 
     * @param diceRollResults
     * @return
     */
    public boolean checkThreeOfAKind(int[] diceRollResults) {
        boolean status = false;

        status = checkOfAKind(diceRollResults, THREEOFAKIND, false);

        return status;
    }

    /**
     * Check for a Four of a Kind
     * 
     * @param diceRollResults
     * @return
     */
    public boolean checkFourOfAKind(int[] diceRollResults) {
        boolean status = false;

        status = checkOfAKind(diceRollResults, FOUROFAKIND, false);

        return status;
    }

    public boolean checkSmallStraight(int[] diceRollResults) {
        boolean status = false;

        status = checkForStraight(diceRollResults, SMALLSTRAIGHT);

        return status;
    }

    public boolean checkLargeStraight(int[] diceRollResults) {
        boolean status = false;

        status = checkForStraight(diceRollResults, LARGESTRAIGHT);

        return status;
    }

    /** 
     * Check for a Yahtzee
     * 
     * @param diceRollResults
     * @return
     */
    public boolean checkYahtzee(int[] diceRollResults) {
        boolean status = false;

        status = checkOfAKind(diceRollResults, YAHTZEE, false);

        return status;
    }

    /**
     * Get count or total points by desired die value.
     * 
     * @param diceRollResults
     * @param value
     * @param calculate
     * @return
     */
    private int dieByValue(int[] diceRollResults, int value, boolean calculate) {
        int matchingCount = 0;
        int count         = 0;

        Arrays.sort(diceRollResults);

        // Loop while results to process or greater than what value we're looking for.
        while (count < diceRollResults.length && diceRollResults[count] <= value) {
            if (diceRollResults[count] == value) {
                matchingCount++;
            }

            count++;
        }

        // If calculate then return point value instead of count.
        if (calculate) {
            matchingCount *= value;
        }

        return matchingCount;
    }

    /**
     * Check dice results for results with the same value greater or equal to passed in size.
     * 
     * @param diceRollResults
     * @param desiredResult
     * @param calculate
     * @return
     */
    private boolean checkOfAKind(int[] diceRollResults, int desiredResult, boolean calculate) {
        boolean status        = false;
        int     count         = 0;
        int     matchingCount = 0;
        int     currentResult = 0;
        int     lastResult    = 0;

        // Sort array so that like die roll results are together.
        Arrays.sort(diceRollResults);

        // Loop through all roll results or until one matches 3
        while (count < diceRollResults.length && matchingCount < desiredResult) {
            // Collect current result
            currentResult = diceRollResults[count];

            // Check if we've already processed this result
            if (currentResult != lastResult) {
                if (matchingCount < desiredResult) {
                    // Count the number of matching values
                    matchingCount = dieByValue(diceRollResults, currentResult, false);
                }

                // Track the last result checked.
                lastResult = currentResult;
            }

            // Move to the next array element
            count++;
        }

        // Check if calculated count is valid.
        if (matchingCount >= desiredResult) {
            status = true;
        }

        return status;
    }

    /**
     * Check if dice results are a straight or a numerical sequence.
     * 
     * @param diceRollResults
     * @param straightMinimumSize
     * @return
     */
    private boolean checkForStraight(int[] diceRollResults, int straightMinimumSize) {
        boolean status        = true;
        int     currentValue  = 0;          // Die result being processed
        int     previousValue = 0;          // The last die result processed
        int     count         = 0;          // Key to access dice roll results array
        int     straightCount = 0;          // Used to count how many results are in numerical order
        int     maxError      = 1;          // Used as an initial check to see if results should even be processed
        boolean errorMet      = false;      // Flag to say if we should proceed with the straight check
        int     resultsLength = 0;          // Used to store the length of the roll results array so it's only accessed once
        int     testCount     = 0;          // Doing a test count of result until success or determine not to proceed further

        // Sort array so it's in order
        Arrays.sort(diceRollResults);

        // Store length so it's not calculated repeated and it's consistent.
        resultsLength = diceRollResults.length;

        // Calculate if looking for a small or large straight.
        maxError += resultsLength - straightMinimumSize;

        while (count < resultsLength && status == true) {
            testCount    = dieByValue(diceRollResults, count + 1, false);
            currentValue = diceRollResults[count];

            // If count of die value is greater than straight error check then a straight isn't possible
            if (testCount > maxError) {
                status = false;
            }

            // We can only match the maxError once.
            if (testCount == maxError && status == true) {
                // If we're dealing with a small straight, the second time the error is meet, there's no way it's a small straight.
                if (resultsLength < straightMinimumSize && errorMet == true) {
                    status = false;
                }

                // We've met the error condition.
                errorMet = true;
            } 

            // If this isn't the first time through
            if (previousValue != 0) {
                
                // Check if the current value is 1 greater than the previous
                if (currentValue == previousValue + 1) {
                    // Increment count results are incrementing by 1.
                    straightCount++;
                } 
            } else {
                // Let's assume first number is the start of the straight
                straightCount++;
            }
            
            // First time through.
            previousValue = currentValue;

            count++;
        }

        // If straight doesn't meet requirements then it's not a valid straight.
        if (straightCount < straightMinimumSize) {
            status = false;
        }

        return status;
    }

    public boolean checkFullHouse(int[] diceRollResults) {
        boolean status = true;
        int[]   diceResults;
        int     valueOne = 0;
        int     resultOne = 0;
        int     resultTwo = 0;

        Arrays.sort(diceRollResults);

        diceResults = removeDuplicates(diceRollResults);

        System.out.println("=============================================");
        System.out.println(Arrays.toString(diceRollResults));
        System.out.println(Arrays.toString(diceResults));
        System.out.println("=============================================");
    
        if ( diceResults.length == 2) {
            for(int count = 0; count < diceRollResults.length; count++) {
                if (count == 0) {
                    valueOne = diceResults[count];
                }

                if (valueOne == diceRollResults[count]) {
                    resultOne++;
                } else {
                    resultTwo++;
                }
            }

            if ( 
                !(
                    resultOne == 2
                    && resultTwo == 3
                ) && !(
                    resultOne == 3
                    && resultTwo == 2
                )
            ) {
                status = false;
            }
        } else {
            status = false;
        }

        return status;
    }

    private int[] removeDuplicates(int[] diceRollResults) {
        ArrayList<Integer> tempArray = new ArrayList<>();
        int   countTemp = 0;

        for(int count = 0; count < diceRollResults.length - 1; count++) {
            int currentElement = diceRollResults[count];

            if (currentElement != diceRollResults[count+1]) {
                tempArray.add(currentElement);
            }
        }

        tempArray.add(diceRollResults[diceRollResults.length - 1]);

        int[] results = new int[tempArray.size()];

        for (int count = 0; count < tempArray.size(); count++) {
            results[count] = tempArray.get(count);
        }

        return results;
    }
}
