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
 * @author KaihengHe
 */
//import infomation.java;
public class Room 
{
    int maxPlayerValue;
    Player[] player;
    Rules rule;
    int round, currentSeatNumber;

    //Battle() 
    //{
    //}
    public void setMaxiumPlayer(int input)
    {
        maxPlayerValue = rule.maxiumPlayer;
    }
    public void playerJoinRoom(Player addplayer, int seatNumber)
    {
        player[seatNumber] = addplayer;
    }
    public String playerID(int playerNumber)
    {
        return player[playerNumber].PlayerID();
    }
    public int nextRound()
    {
        boolean allReady = true;
        for(int i = 0; i < currentSeatNumber; i++)
            allReady = (player[i].isReady ? allReady : false);//make sure everyone is ready
        if(!allReady)
        {return -1;}//return -1 if someone is not ready
        else
        {
        for(int i = 0; i < currentSeatNumber; i++)
        player[i].playerNotReady();
       return round++;//returning  the current round number
        }
    }
    
     public int forceNextRound()
    {
        for(int i = 0; i < currentSeatNumber; i++)
            player[i].playerNotReady();
       return round++;//returning  the current round number
    }
    
     public void makeNewRoom()
    {
        player[maxPlayerValue] = new Player();
    }
     public void makeRulesDefault()
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
          if(player[playerID].credit > (worker*rule.workerValue))
              return -1; //unable to build unit
          else
          {
           player[playerID].getFarmer(worker + player[playerID].ValueFarmer());
           player[playerID].getCredit(player[playerID].credit 
                   - (worker*rule.workerValue));
           
           return worker*rule.workerValue;
                     //return moneyspent
          }          
      }
      
       public int buildAttackers(int playerID, int attacker)
      {
          if(player[playerID].credit > (attacker*rule.attackerValue))
              return -1;//unable to build unit
          else{
           player[playerID].getAttacker(attacker+ player[playerID].ValueAttacker());
          player[playerID].getCredit(player[playerID].credit 
                   - (attacker*rule.attackerValue));
          return attacker*rule.attackerValue;    //return moneyspent
          }
      }
       
         public int buildDefenders(int playerID, int defender)
      {
            if(player[playerID].credit > (defender*rule.defenderValue))
              return -1;//unable to build unit
          else{
           player[playerID].getDefender(defender + player[playerID].ValueDefender());
          player[playerID].getCredit(player[playerID].credit 
                   - (defender*rule.defenderValue));
          return defender*rule.defenderValue;
            }
          //return moneyspent
      }
      

    
    
}
 
