package components;

public class Dice {
    /**
     * @var defaultSides Number of sides by default.
     */
    private int defaultSides  = 6;

    /**
     * @var numberOfSides  Number of sides defined.
     */
    private int numberOfSides = 0;

    /**
     * Dice() constructor
     */
    public Dice() {
        numberOfSides = defaultSides;
    }

    /**
     * Dice constructor
     * 
     * @param sides Number of sides the dice has.
     */
    public Dice(int sides) {
        this.numberOfSides = sides;
    }

    /**
     * Rolls the die and returns the result
     * 
     * @return
     */
    public int roll() {
        double rolledValue;
        int result;

        rolledValue = Math.random() * this.numberOfSides;
        result = (int)rolledValue + 1;

        return result;
    }

    /**
     * Returns the number of sides the die has.
     * 
     * @return
     */
    public int getNumberOfSides() {
        return numberOfSides;
    }

    /**
     * Sets the numberOfSides 
     * @param sides
     */
    public void setNumberOfSides(int sides) {
        numberOfSides = sides;
    }
}
