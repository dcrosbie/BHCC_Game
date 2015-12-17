import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import userIO.*;
import ConnectToDB.*;

/**
 *
 * @author Soukaina
 */
public class UserLoginOrig extends Application {
       
    //Create a Button 
    Button loginBtn = new Button("Login");
    //Create Label
    Label usernameLabel = new Label("Enter username :");

    //Create Text Area
    TextField userNameInput = new TextField();
    

    FlowPane root; 
    
    @Override
    public void start(Stage primaryStage) {
  GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(20);

        //add the nodes in the pane
        pane.add(usernameLabel, 0, 0);
        pane.add(userNameInput, 1, 0);
       
        pane.add(loginBtn,1,2);

        //Create a border pane and place the other panes in it.
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        

      // event handler for the ligin button
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                 ConnecToDB conn=new ConnecToDB();// create a connection object
                 UserIO userIO=new UserIO();// create a userIo object fro the userIO class that deals with the user input
                 userIO.readUsers(conn);// pass conection readUsers() fuction to get all usernames and IDs fom database
                 if(userIO.checkTheUserOut(userNameInput.getText())!=0)
                 {
                     System.out.println("User existe");
                     // Rachid's code can go here
                 }
                 else 
                 {
                     //send the user to a registration page..... (Blake's code)
                     System.out.println("user doesn't existe.Create a new one...");
                 }
            }
        });
        
        Scene scene = new Scene(borderPane, 400, 350);
        primaryStage.setTitle(" User login ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
