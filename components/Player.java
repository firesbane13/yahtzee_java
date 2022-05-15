package components;

import java.math.BigInteger;

public class Player {
    private BigInteger id;    
    private BigInteger uid;
    private String     name;
    
    public Player() {
        
    }

    /**
     * Load player from database.
     * 
     * @return
     */
    public boolean load() {
        boolean status = true;

        return status;
    }

    /**
     * Save player to database.
     * 
     * @return
     */
    public boolean save() {
        boolean status = true;

        return status;
    }

    /**
     * Set player's name.
     * 
     * @param playerName  Player's id.
     */
    public void setName(String playerName) {
        name = playerName;
    }

    /**
     * Get player's name.
     * 
     * @return
     */
    public String getName() {
        return name;
    }
}
