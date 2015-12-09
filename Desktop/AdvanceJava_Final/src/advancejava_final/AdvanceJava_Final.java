
package advancejava_final;

import ConnectToDB.ConnecToDB;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rachid
 */

public class AdvanceJava_Final extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
       
        
       UserMenuPane menu= new UserMenuPane();
        
        Scene scene = new Scene(menu, 800, 500);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
