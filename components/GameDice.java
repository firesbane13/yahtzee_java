package components;

import java.util.ArrayList;

public class GameDice {
    private ArrayList<Dice> gameDice = new ArrayList<>();
    private int numberOfDice;

    /**
     * GameDice constructor defining the number of dice in the set.
     * 
     * @param numOfDice Number of dice in set.
     */
    public GameDice(int numOfDice) {
        this.numberOfDice = numOfDice;
        for(int count = 0; count < numberOfDice; count++) {
            gameDice.add(new Dice());
        }
    }

    /**
     * GameDice constructor defining the number of dice and sides of dice in the set.
     * @param numOfDice     Number of dice in set
     * @param numberOfSides Type of dice (sides)
     */
    public GameDice(int numOfDice, int numberOfSides) {
        this.numberOfDice = numOfDice;
        for(int count = 0; count < numberOfDice; count++) {
            gameDice.add(new Dice(numberOfSides));
        }
    } 

    /**
     * GameDice constructor defining number of dice and sides through an array in the set.
     * 
     * @param dice Array of dice.
     */
    public GameDice(int[] dice) {
        for(int count = 0; count < dice.length; count++) {
            gameDice.add(new Dice(dice[count]));
        }
    }

    /**
     * Roll the defined nubmer and types of dice.
     * 
     * @return
     */
    public int[] roll() {
        Dice tempDie;
        int[] results = new int[gameDice.size()];

        for(int count = 0; count < gameDice.size(); count++) {
            tempDie = gameDice.get(count);

            results[count] = tempDie.roll();
        }

        return results;
    }


}
