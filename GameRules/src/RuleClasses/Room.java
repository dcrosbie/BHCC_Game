package RuleClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import RuleClasses.Player;
import RuleClasses.Rules;
/*
 *
 * @author admin
 */
//import infomation.java;
public class Room 
{
    int maxPlayerValue;
    Player[] player;
    Rules rule;

    //Battle() 
    //{
    //}
    public void setMaxiumPlayer(int input)
    {
        maxPlayerValue = rule.maxiumPlayer;
    }
     public void makeNewRoom()
    {
        player[maxPlayerValue] = new Player();
    }
     public void makeRule()
     {
         rule.makeDefault();
         //needs to be changed
     }
     
     public void getRules(Rules input)
     {
         rule = input;
     }
    
      public void getPlayer(int input, int place)
    {
        player[maxPlayerValue] = new Player();
    }
      
      public int attackDefenders(int attackSide, int defSide)
    {
        int finalValue = (int)
                ((player[attackSide].ValueAttacker() 
                - player[defSide].ValueDefender())
                * rule.attacker_defender_kdr);
        if (finalValue >=0)
        {
            player[attackSide].getAttacker(finalValue);
            player[defSide].getAttacker(0);
        }
        else
        {
            player[attackSide].getAttacker(0);
            player[defSide].getAttacker(finalValue*(-1));
        }
         //-----
        
        return finalValue; 
        //retun > 0 is the survive attacker
        //return < 0 is the survive defenter (the absolute value)
    }
      
      public int attackWorkers(int attackSide, int defSide)
    {
        //int a = this.attackDefenders(attackSide, defSide);
          if(!rule.killable_farmer)
          {
          return -1;
          //return -1 if worker killing is unabled
          }
          else
         {
          int a = this.attackDefenders(attackSide, defSide);

           if(a>0)
           {
             double b = (player[attackSide].ValueAttacker() 
                     * rule.attacker_farmer_kdr 
                     - player[defSide].ValueFarmer());
               if (b < 0)
               player[attackSide].getFarmer(0);
               else
               {
                   player[attackSide].getFarmer((int)b);
               }
               return (int) b;
           }
           else
               return 0;
          
         }
          //returning the remaining workers
    }
      
      public int workerIncome(int playerID)
      {
           player[playerID].getCredit(rule.income_value_per_farmer 
                  * player[playerID].ValueFarmer()
                  + rule.income_value_per_round 
                  + player[playerID].credit); 
           
      return player[playerID].credit;
      //return final workerincome
      }
      
      public int buildWorkers(int playerID, int worker)
      {
           player[playerID].getFarmer(worker + player[playerID].ValueFarmer());
          
          return 0;
          //return moneyspent, needs to be changed
      }
      
       public int buildAttackers(int playerID, int attacker)
      {
           player[playerID].getAttacker(attacker+ player[playerID].ValueAttacker());
          
          return 0;
          //return moneyspent, needs to be changed
      }
       
         public int buildDefenders(int playerID, int defender)
      {
           player[playerID].getDefender(defender + player[playerID].ValueDefender());
          
          return 0;
          //return moneyspent, needs to be changed
      }
      

    
    
}
 
