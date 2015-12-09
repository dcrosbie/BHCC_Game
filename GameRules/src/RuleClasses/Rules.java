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
public class Rules {
    protected int income_value_per_round, 
                income_value_per_farmer,
                victory_reward_per_attacker,
                maxiumPlayer, maxiumRounds;
                
    protected int workerValue,
                  attackerValue,
                  defenderValue;
    
     protected double attacker_defender_kdr,
                      attacker_farmer_kdr;
            
    protected boolean  killable_farmer = false;
   // protected boolean gamestarted = false;
    
    //public void startTheGame(){gamestarted = true;}
    public void makeDefault()
    {
        
                attacker_defender_kdr = 1.0;
                attacker_farmer_kdr = 1.0;
                /////////////////////////////////////////
                income_value_per_round = 100; 
                income_value_per_farmer = 1;
                victory_reward_per_attacker = 2;
                ////////////////////////////////
                maxiumPlayer = 5;
                maxiumRounds = 50;
                //////////////////////////
                workerValue = 1;
                attackerValue = 1;
                defenderValue = 1;
         // throw new UnsupportedOperationException("Worker Killing not supported yet.");
        //EPT
    }
    
    public void getKDR(double input)
    {
        attacker_defender_kdr = input;
    } 
    public void getFarmerDR(double input)
    {
        attacker_farmer_kdr = input;
    }
    
    public void getIncomePerRound(int input)
    {
        income_value_per_round = input;
    }
    public void getRewardPerAttacker(int input)
    {
        victory_reward_per_attacker = input;
    }
    
    public void getIncomePerFarmer(int input)
    {
        income_value_per_farmer = input;
    }
    
    public void enableingFarmerKilling()
    {
        killable_farmer = true;
    }
    
    public void disableingFarmerKilling()
    {
        killable_farmer = false;
    }
        public void getMaxiumPlayer(int input)
    {
        maxiumPlayer = input;
    }
        public void getWokerValue(int input)
    {
        workerValue = input;
    }
        
        public void getAttackerValue(int input)
    {
        attackerValue = input;
    }
        
        public void defenferValue(int input)
    {
        defenderValue = input;
    }
    /*
    public int netImcome()
    {
    }
    */
}
