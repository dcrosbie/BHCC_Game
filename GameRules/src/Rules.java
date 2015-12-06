/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Rules {
    int attacker_defender_kdr, income_value_per_round, income_value_per_farmer,
            victory_reward_per_attacker;
    boolean  killable_farmer = false;
    
    public void getKDR(int input)
    {
        attacker_defender_kdr = input;
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
    
    public void enableingFarmerFilling()
    {
        killable_farmer = true;
    }
    
    public void disableingFarmerFilling()
    {
        killable_farmer = false;
    }
    /*
    public int netImcome()
    {
    }
    */
}
