package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import java.sql.*;

public class Controller {

    @FXML private Label regBad;
    @FXML private Label regGood;
    @FXML private TextField regUsername;


    @FXML protected void regButtonClicked (ActionEvent event){
        try {
            String s = regUsername.getText();
            regBad.setVisible(false);
            regGood.setVisible(false);
            //bError = false;
            //bSuccess = false; //reset the flags each try
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
                //bError = true;
                regBad.setVisible(true);
                return;
            }
            //if not, it will add the name to the database
            PreparedStatement insertStatement = con.prepareStatement(insertName);
            insertStatement.setString(1, s);
            insertStatement.executeUpdate();
            regGood.setVisible(true);
            //bSuccess = true;

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
