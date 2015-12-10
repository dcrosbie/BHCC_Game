
package advancejava_final;

import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import ConnectToDB.ConnecToDB;
import roundIO.*;

/**
 *
 * @author rachid
 */

import javafx.scene.control.Button;

public class UserMenuPane extends BorderPane{
    
    //Create Buttons
    private Button newGameButton = new Button ("Start new game ");
    private Button joinAgame = new Button ("Join a game ");
    private Button continueGameButton = new Button("Game in progress");
    
    //Create a Label,
    private Label title = new Label("User Menu");
    
    //Create an Hbox pane where the buttons willbe listed
    private VBox vbox = new VBox (10);
    
    //Create a connection to database 
    private ConnecToDB connect = new ConnecToDB();
    
    //Create a round and roundIO object to get records from rounds table to verify is the user already an active member in a game
    private RoundIO roundIO = new RoundIO();
    
    //Create an arraylist to save all records founded in round table in database.
    private  ArrayList<Round> rounds = new ArrayList<>();
    
    //userid obtained when user logged in 
    //This default value must be deleted and replaced by the ID that's being returned from soukaina's code 
    //once we put the peaces together.
    int userId =1;
    
    //Create a boolean variable to see if the player existe in Round table
    boolean exist = false;
    
    //Create a constructor
    public UserMenuPane()
    {
      rounds = roundIO.readRounds(connect);
      
      for (int i=0; i<rounds.size(); i++)
      {
       // System.out.println("playerId"+rounds.get(i).getPlayerId()+" player name: "+rounds.get(i).getPlayerName()+"\n");
        
         
          if(rounds.get(i).getPlayerId()==userId)
          {
              exist=true;
              break;
          }
         
      }
      vbox.setAlignment(Pos.CENTER);
      
      newGameButton.setPrefWidth(150);
      joinAgame.setPrefWidth(150);
      continueGameButton.setPrefWidth(150);
      //title.setPrefWidth(150);
     if(exist)
          vbox.getChildren().addAll(title,newGameButton,joinAgame,continueGameButton);
      else
          vbox.getChildren().addAll(title,newGameButton);
      
      
      setCenter(vbox);
      
    }
    
        
}
