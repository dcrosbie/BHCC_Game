package sample;

//User Registration Page for BHCC Game
//Written by Blake DeLee

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;

public class userRegistration extends Application {
    static boolean bError = false; //flag for username already in database
    static boolean bSuccess = false; //flag for successfully registered username
    @Override
    public void start(Stage primaryStage) throws Exception {


        FlowPane titlePane = new FlowPane();
        Label title = new Label("Registration Page");
        titlePane.getChildren().addAll(title); //general javafx stuff


        titlePane.setAlignment(Pos.CENTER);

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(30, 10, 10, 10));

        TextField username = new TextField(); //username text field
        username.setPrefColumnCount(15);


        Label lUsername = new Label("Username:        ");

        Label lError = new Label("Username already taken."); //hidden error label
        lError.setTextFill(Color.RED);
        lError.setVisible(false);

        Label lSuccess = new Label("Username successfully registered!"); //hidden success label
        lSuccess.setTextFill(Color.GREEN);
        lSuccess.setVisible(false);

        Button bRegister = new Button("Register");
        Button bCancel = new Button("Cancel");

        bRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nameInput(username.getText()); //runs function to check if name exists, if not
                                               //it is registered
                if (bError){ //makes error label visible if flag is thrown
                    lError.setVisible(true);
                } else {
                    lError.setVisible(false);
                }

                if (bSuccess){ //makes success label visible if flag is thrown
                    lSuccess.setVisible(true);
                } else {
                    lSuccess.setVisible(false);
                }
            }

        });

        bCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit(); //just exits the program on cancel, can later be used to send to previous page
            }
        });

        Text pad = new Text(); // just padding for format

        pane.add(lUsername, 0, 0);
        pane.add(username, 1, 0);
        pane.add(pad, 0, 2);
        pane.add(bRegister, 0, 3);
        pane.add(bCancel, 1, 3);
        pane.add(lError, 2, 3);
        pane.add(lSuccess, 2, 3);


        primaryStage.setTitle("Resource Game");
        primaryStage.setResizable(false);
        Group root = new Group(titlePane, pane);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void nameInput(String s){  //this is the function that checks/uses database
        try {
            bError = false;
            bSuccess = false; //reset the flags each try
            String host = "jdbc:mysql://173.194.235.163:3306/BHCCgame";
            String dName = "scott";
            String dPass = "tiger";

            String insertName = "INSERT INTO PLAYER (playerNAME) VALUES (?)"; //mysql update
            String queryName = "SELECT * FROM PLAYER where playerNAME = (?)"; //mysql query

            Connection con = DriverManager.getConnection(host, dName, dPass);



            PreparedStatement queryStatement = con.prepareStatement(queryName);
            queryStatement.setString(1, s);
            ResultSet resultSet = queryStatement.executeQuery(); //use preparedstatement to deal with query

            if(resultSet.next()){ //if there is any match, it will return a result set, and it will throw error
                bError = true;
                return;
            }
            //if not, it will add the name to the database
            PreparedStatement insertStatement = con.prepareStatement(insertName);
            insertStatement.setString(1, s);
            insertStatement.executeUpdate();
            bSuccess = true;

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
