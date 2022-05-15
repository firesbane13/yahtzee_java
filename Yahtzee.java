import java.util.Arrays;

import components.GameDice;
import components.Scorecard;

class Yahtzee {
    public static void main(String[] args) {
        GameDice  d6 = new GameDice(5);
        Scorecard scorecard = new Scorecard();
        int[] diceRollResults;

        diceRollResults = d6.roll();

        /*
        System.out.println(Arrays.toString(diceRollResults));
        System.out.println( "Aces: " + scorecard.checkAces(diceRollResults) );
        System.out.println( "Twos: " + scorecard.checkTwos(diceRollResults) );
        System.out.println( "Threes: " + scorecard.checkThrees(diceRollResults) );
        System.out.println( "Fours: " + scorecard.checkFours(diceRollResults) );
        System.out.println( "Fives: " + scorecard.checkFives(diceRollResults) );
        System.out.println( "Sixes: " + scorecard.checkSixes(diceRollResults) );
        System.out.println("##############################");
        System.out.println("3 of a Kind: " + scorecard.checkThreeOfAKind(diceRollResults));
        System.out.println("4 of a Kind: " + scorecard.checkFourOfAKind(diceRollResults));
        System.out.println("Full House: " + scorecard.checkFullHouse(diceRollResults));
        System.out.println("Small Straight: " + scorecard.checkSmallStraight(diceRollResults));
        System.out.println("Large Straight: " + scorecard.checkLargeStraight(diceRollResults));
        System.out.println("Yahtzee: " + scorecard.checkYahtzee(diceRollResults));
        */
    }
}