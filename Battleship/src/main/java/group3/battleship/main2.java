package group3.battleship;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class main2 extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent menu = FXMLLoader.load(main2.class.getResource("Main Menu.fxml"));
        Scene s = new Scene(menu);
        primaryStage.setScene(s);
        primaryStage.show();
    }

}
