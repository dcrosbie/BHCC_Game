/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RuleClasses;

/**
 *
 * @author KaihengHe
 */
public class ScoringSystem {
    private class scorePerPlayer
    {
        int attackerKilled;
        int defenderKilled;
        int workerKilled;
        int remainingCredit;
        int creditSpend;
    }
    private class round
    {
        round lastRound;
        int[] playerNum;
        scorePerPlayer[] roundScore;
        int roundNumber;
        round nextRound;
    }
    
    int scorePerCreditSpent,
        scorePerKill,
        scorePerCredit;
    
   // private round roundLinkListPtr;
    private round currentRound;
    
    public void getCreditSpentScore(int input)
    {
        scorePerCreditSpent = input;
    }
    public void getKillScore(int input)
    {
        scorePerKill = input;
    }
    public void getRemaingingCreditScore(int input)
    {
        scorePerCredit = input;
    }
    
    ///////////// those are for getting current infomations, make sure that 
    ///////////// you are on the round you wanted to edit 
    public void getAttackerKilled(int playerID,int input)
    {
        currentRound.roundScore[playerID].attackerKilled = input;
    }
    
     public void getDefenderKilled(int playerID,int input)
    {
        currentRound.roundScore[playerID].defenderKilled = input;
    }
     
    public void getWorkerKilled(int playerID,int input)
    {
        currentRound.roundScore[playerID].workerKilled = input;
    }
    public void getCreditSpent(int playerID,int input)
    {
        currentRound.roundScore[playerID].creditSpend = input;
    }
     public void getRemainingCredit(int playerID,int input)
    {
        currentRound.roundScore[playerID].remainingCredit = input;
    }
    //////////////
    public int previouRound() 
    //returning the current round number, and move to the current round 
    //pointer to last round, -1 means no previous round
    {
        if(currentRound.lastRound == null)
            return -1;
        else
        {
            currentRound = currentRound.lastRound;
            return currentRound.roundNumber; 
        }
    }
    
        public int nextRound() 
    //returning the current round number, and move to the current round pointer to next round
    //, -1 means no previous round
    {
        if(currentRound.nextRound == null)
            return -1;
        else
        {
            currentRound = currentRound.nextRound;
            return currentRound.roundNumber; 
        }
    }
        public void createNewGameScore()
                //create new game Scoring board
        {
            currentRound = new round();
            currentRound.roundNumber = 1;
        }
        
        public int createNextRound()
                //create currentRound with only round number infomation
        {
            round roundPtr = currentRound;
            currentRound.nextRound = new round();
            currentRound = currentRound.nextRound;
            currentRound = roundPtr.lastRound;
            currentRound.roundNumber = roundPtr.roundNumber+1;
            return currentRound.roundNumber;
        }
        
      public int  playerCurrentScore(int playerID)
              //return to the score of the player for the current round
      {
          return currentRound.roundScore[playerID].creditSpend * scorePerCreditSpent
               + currentRound.roundScore[playerID].remainingCredit * scorePerCredit
               + (
                   currentRound.roundScore[playerID].attackerKilled
                 + currentRound.roundScore[playerID].defenderKilled
                 + currentRound.roundScore[playerID].workerKilled
                 ) * scorePerKill;
      }
    /*
    public void history(int roundNumber, int PlayerNum)// need to return the round number
    {
        //
    }
    */
    
}