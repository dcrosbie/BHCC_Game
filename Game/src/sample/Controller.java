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
    @FXML private Tab loginTab;
    @FXML private Tab registerTab;




    @FXML protected void logoutClicked (ActionEvent e){
        Platform.exit();
    }

    @FXML protected void logToRegClicked (ActionEvent e){
        registerTab.setDisable(false);
        loginTab.setDisable(true);
    }

    @FXML protected void regToLogClicked (ActionEvent e){
        registerTab.setDisable(true);
        loginTab.setDisable(false);
    }

    @FXML protected void assignButtonClicked (ActionEvent e){
        gameScroll.setScrollTop(0);
        gameScroll.appendText("Hey\n");
    }

    @FXML protected void regButtonClicked (ActionEvent e){
        try {
            String s = regUsername.getText();
            regBad.setVisible(false);
            regGood.setVisible(false);
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
}
