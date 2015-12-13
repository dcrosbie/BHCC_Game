package sample;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Blake on 12/12/15.
 */
public class updateTableService extends Service<Void> {

    protected Task createTask() {
        try{
            Connection c = DBConnect.connect();
        } catch (SQLException err){
            System.out.println(err.getMessage());
        }
        return null;
    }
}
