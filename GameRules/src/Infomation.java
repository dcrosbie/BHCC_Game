/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Infomation{//information
    
    private int attacker, defender, farmer, credit;
    private String playerID;
    //private double attack_defender_kdr, income_per_round, income_per_farmer,
     //       victoryReward;
   // private boolean enableFarmerKilling, isVictoryRewardInRate;
    
    /**
     *
     * @param attacker
     */
    
    public void getAttacker(int getattacker)
    {
        attacker = getattacker;
    }
    
    public void getDefender(int getdefender)
    {
        defender = getdefender;
    }
    
    public void getFarmer(int getFarmer)
    {
        farmer = getFarmer;
    }
    
    public void getPlayerID(String getplayerID)
    {
        playerID = getplayerID;
    }
    public int ValueAttacker()
    {
        return attacker;
    }
    
    public int ValueDefender()
    {
        return defender;
    }
    
    public int ValueFarmer()
    {
        return farmer;
    }
    
    public String ValuePlayerID()
    {
        return playerID;
    }
    
    
}
