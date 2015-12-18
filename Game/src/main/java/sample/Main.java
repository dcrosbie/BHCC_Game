package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.sql.Connection;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //ignore the next three lines
        //updateTableService svc = new updateTableService();
        //svc.setPeriod(Duration.seconds(5));
        //svc.start();

        DBConnect.connect();


        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));

        //user must click Log Out to exit, the x button does not work.
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                DBConnect.disconnect();
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




