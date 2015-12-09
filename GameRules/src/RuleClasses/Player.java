package RuleClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author KaihengHe
 */
public class Player{//information
    
    private int attacker, defender, farmer;
    protected int credit;
    private String playerID;
    protected boolean isReady = false;
    //private double attack_defender_kdr, income_per_round, income_per_farmer,
     //       victoryReward;
   // private boolean enableFarmerKilling, isVictoryRewardInRate;
    
    /**
     *
     * @param
     */
    public void Initialize(String playerName, int initCredits) //initialize the player info besides player name
    {
        attacker = 0;
        defender = 0;
        farmer = 0;
        playerID = playerName;
        credit = initCredits;
    }
    
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
    
    public void getCredit(int input)
    {
        credit = input;
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
    
    public void playerReady()
    {
        isReady = true;
    }
     public void playerNotReady()
    {
        isReady = false;
    }
    
    
    
    
}
