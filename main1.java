import java.util.*;
import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;


public class main1 extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent menu = FXMLLoader.load(main1.class.getResource("Main Menu.fxml"));
        Scene s = new Scene(menu);
        primaryStage.setScene(s);
        primaryStage.show();
    }

}
