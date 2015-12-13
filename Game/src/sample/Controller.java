package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import java.sql.*;

public class Controller {

    @FXML private Label regBad;
    @FXML private Label regGood;
    @FXML private TextField regUsername;
    @FXML private TextArea gameScroll;

    @FXML protected void loginClicked (ActionEvent e){} //soukaina, put your log in logic here

    @FXML protected void logoutClicked (ActionEvent e){
        Platform.exit();
    }

    @FXML protected void regButtonClicked (ActionEvent e){
        try {
            String s = regUsername.getText();
            regBad.setVisible(false);
            regGood.setVisible(false);

            String insertName = "INSERT INTO PLAYER (playerNAME) VALUES (?)"; //mysql update
            String queryName = "SELECT * FROM PLAYER where playerNAME = (?)"; //mysql query

            Connection con = DBConnect.connect();

            PreparedStatement queryStatement = con.prepareStatement(queryName);
            queryStatement.setString(1, s);
            ResultSet resultSet = queryStatement.executeQuery(); //use preparedstatement to deal with query

            if(resultSet.next() || s == ""){ //if there is any match, or if it is an empty string, it will return a result set, and it will throw error
                regBad.setVisible(true);
                return;
            }
            //if not, it will add the name to the database
            PreparedStatement insertStatement = con.prepareStatement(insertName);
            insertStatement.setString(1, s);
            insertStatement.executeUpdate();
            regGood.setVisible(true);

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    @FXML protected void startGameClicked (ActionEvent e){} //rachid, put your start game logic here

    @FXML protected void joinLobbyClicked (ActionEvent e){} //rachid, put your join lobby logic here

    @FXML protected void joinGameClicked (ActionEvent e){} //rachid, put your join current game logic here

    @FXML protected void assignClicked (ActionEvent e){} //link, put your logic in here to assign unassigned workers

    @FXML protected void attackClicked (ActionEvent e){} //link, put your logic here to use game rules to attack

    @FXML protected void quitGameClicked(ActionEvent e){}

    //@FXML protected void
}
