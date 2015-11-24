/*
 This version of the app simply displays a form and allows the creation of the database

 */
package millerpintgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author dcros
 */
public class MillerPintGame extends Application {
            
    // Create the inout variables
    private final TextField tfSQLaddress = new TextField();
    private final TextField tfSQLusernsme = new TextField();
    private final TextField tfSQLpassword = new TextField();
    private final TextField tfSQLresults = new TextField();
    
        
       
    
    @Override
    public void start(Stage primaryStage) {
 
        // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding (new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        
        //Place the nodes on the pane
        pane.add(new Label("MySQL Server"), 0, 0);
        pane.add(tfSQLaddress, 1,0);
        pane.add(new Label("Username"), 1, 0);
        pane.add(new Label("Password"), 1, 1);
        
        // Place a results field
        pane.add(new Label("Result"), 0, 4);
        
        
        // Place a Connect Button
        Button btnConnect = new Button("Connect");
        pane.add(btnConnect, 1, 3);
        btnConnect.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                // Put the connect code in here!
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btnConnect);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Miller Pint Game");
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
