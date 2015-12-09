/**
 * Round class is a Model class which we can use in RoundIO class to read, delete, update data from round table in BHCCgame database .....
 * 
 */
package roundIO;

/**
 *
 * @author rachid
 */
public class Round {
    
    private int playerId; 
    private String playerName;

    public Round() {
    }

    public Round(int playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    
    
    
    
   
    
    
}
