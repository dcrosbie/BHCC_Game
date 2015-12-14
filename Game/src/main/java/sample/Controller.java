package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import java.sql.*;

public class Controller {

    @FXML private Label regBad;
    @FXML private Label regGood;
    @FXML private TextField regUsername;
    @FXML private TextArea gameScroll;
    @FXML private Tab loginTab;
    @FXML private Tab registerTab;
    @FXML private Tab listTab;
    @FXML private Tab lobbyTab;
    @FXML private Tab gameTab;
    @FXML private TabPane tabPane;

    private static Game currentGame;
    private static Player currentPlayer;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Controller.currentGame = currentGame;
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        Controller.currentPlayer = currentPlayer;
    }

    @FXML protected void loginClicked (ActionEvent e){
        listTab.setDisable(false);
        tabPane.getSelectionModel().select(listTab);
    } //soukaina, put your log in logic here

    @FXML protected void logoutClicked (ActionEvent e){
        Platform.exit();
    }

    @FXML protected void switchToRegClicked (ActionEvent e){
        registerTab.setDisable(false);
        tabPane.getSelectionModel().select(registerTab);
        loginTab.setDisable(true);
    }

    @FXML protected void switchToLogClicked (ActionEvent e){
        loginTab.setDisable(false);
        tabPane.getSelectionModel().select(loginTab);
        registerTab.setDisable(true);
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

    @FXML protected void startGameClicked (ActionEvent e){

        lobbyTab.setDisable(false);
        tabPane.getSelectionModel().select(lobbyTab);
        listTab.setDisable(true);
    } //rachid, put your start game logic here

    @FXML protected void joinLobbyClicked (ActionEvent e){} //rachid, put your join lobby logic here

    @FXML protected void joinGameClicked (ActionEvent e){} //rachid, put your join current game logic here

    @FXML protected void leaveLobbyClicked (ActionEvent e){
        listTab.setDisable(false);
        tabPane.getSelectionModel().select(listTab);
        lobbyTab.setDisable(true);
    }

    @FXML protected void assignClicked (ActionEvent e){} //link, put your logic in here to assign unassigned workers

    @FXML protected void attackClicked (ActionEvent e){} //link, put your logic here to use game rules to attack

    @FXML protected void quitGameClicked(ActionEvent e){}

}
