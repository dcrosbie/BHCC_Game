package sample;

import java.sql.Connection;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import java.util.concurrent.ScheduledExecutorService;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import org.datafx.reader.DataReader;


public class Main extends Application {

    ScheduledExecutorService svc = new ScheduledExecutorService(){
        protected Task<Void> createTask(){
            return null;
        }
    };

    svc.setPeriod(Duration.seconds(1));



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //user must click Log Out to exit, the x button does not work.
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

        primaryStage.setResizable(false);
        primaryStage.setTitle("BHCC Game");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();

    }




    public static void main(String[] args) {
        launch(args);
    }

}




