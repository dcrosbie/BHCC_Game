package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//Created by Blake DeLee
//Used to put table updating on a different thread
//ignore this class for now

public class updateTableService extends ScheduledService<Void> {

    @FXML private TableView lobbyList;
    @FXML private TableColumn lobbyUserCol;
    @FXML private TableColumn lobbyReadyCol;
    private ObservableList<Player> playerList;

    protected Task createTask() {
        playerList = FXCollections.observableArrayList();
        try{
            String gameID = Integer.toString(Controller.getCurrentGame().getIdGAME()); //need to pass ID from game class to here
            Connection c = DBConnect.connect();
            lobbyUserCol.setCellValueFactory(new PropertyValueFactory<Player, String>("playerNAME"));
            lobbyReadyCol.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("isREADY"));

            String lobbyTableSQL = "SELECT playerNAME FROM PLAYER where idCurrentGAME = (?) ORDER BY playerNAME";

            PreparedStatement ps = c.prepareStatement(lobbyTableSQL);
            ps.setString(1, gameID);
            ResultSet rs = c.createStatement().executeQuery(lobbyTableSQL);

            while (rs.next()){
                Player p = new Player();
                p.setPlayerNAME(rs.getString("playerNAME"));
                p.setREADY(rs.getInt("isREADY"));
                playerList.add(p);
            }
            lobbyList.setItems(playerList);
        } catch (SQLException err){
            System.out.println(err.getMessage());
        }
        return null;
    }
}
