/*
 This version of the app simply displays a form and allows the creation of the database

 */
package millerpintgame;

import java.sql.SQLException;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static millerpintgame.DatabaseConnect.DatabaseConnect;
import static millerpintgame.DatabaseCreate.DatabaseCreate;

/**
 *
 * @author dcros
 */
public class MillerPintGame extends Application {
            
    // Create the inout variables
    private final TextField tfSQLaddress = new TextField();
    private final TextField tfSQLusernsme = new TextField();
    private final TextField tfSQLpassword = new TextField();
    private final TextArea tfSQLresults = new TextArea();
    private String databaseName = "localhost";
    private String databaseUser = "david";
    private String databasePassword = "leoleo";
    
    
        
       
    
    @Override
    public void start(Stage primaryStage) {
 
        // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding (new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        
        // Add some text to the top of the field
        Text banner = new Text (0,0, " Database Creation");
        
        //Place the nodes on the pane
        pane.add(new Label("MySQL Server"), 0, 1);
        pane.add(tfSQLaddress, 1,1);
        pane.add(new Label("Username"), 0, 2);
        pane.add(tfSQLusernsme, 1,2);
        pane.add(new Label("Password"), 0, 3);
        pane.add(tfSQLpassword, 1,3);
        
        // Set the initial values
        tfSQLaddress.minWidth(50);
        tfSQLaddress.setText(databaseName);
        tfSQLusernsme.setText(databaseUser);
        tfSQLpassword.setText(databasePassword);
        
        // Place a results field
        pane.add(new Label("Result"), 0, 6);
        tfSQLresults.isEditable();
        tfSQLresults.setPrefSize(50, 20);
        pane.add(tfSQLresults, 1,6);
        
        
        // Place a Connect Button
        Button btnConnect = new Button("Connect");
        pane.add(btnConnect, 1, 5);
        btnConnect.setOnAction((ActionEvent e) -> {
            
                try {
                    connectDB();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MillerPintGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MillerPintGame.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("first attemptat connection");
                } catch (InterruptedException ex) {
                    Logger.getLogger(MillerPintGame.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
        
        Scene scene = new Scene(pane, 600, 500);
        
        primaryStage.setTitle("Miller Pint Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void connectDB() throws SQLException, ClassNotFoundException, InterruptedException {
        // This is the code that calls the DataBase Create
        String dbFullAddress = tfSQLaddress.getText();
        String dbUserName = tfSQLusernsme.getText();
        String dbPassword = tfSQLpassword.getText();
        
        
        // Now display the text in the panel when the button is pressed
        tfSQLresults.setText(dbFullAddress + "\n" + dbUserName + "\n" + dbPassword);
        int dbReturn =  DatabaseConnect(dbFullAddress, dbUserName, dbPassword);
        String dbMessage = Integer.toString(dbReturn);
        tfSQLresults.setText(dbMessage);
        if (dbReturn == 8801){
            tfSQLresults.setText("Retrying");
            Thread.sleep(1000);
            int dbReturn2 =  DatabaseConnect(dbFullAddress, dbUserName, dbPassword);
            if (dbReturn2 == 8801){
                tfSQLresults.setText("Database does not respond.\nIs it running?");
            }
           
        }
    }
    private void createDB() throws SQLException, ClassNotFoundException {
        String schema = "game";
        int dbCreateStatus = DatabaseCreate(schema);
        System.out.println(schema);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


   
}
