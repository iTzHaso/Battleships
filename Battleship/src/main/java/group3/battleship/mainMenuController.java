package group3.battleship;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;




public class mainMenuController{
    @FXML
    private Button advanced_button;

    @FXML
    private Button classic_button;

    @FXML
    private Button vscpu_button;

    @FXML
    void vscpu(MouseEvent event) throws Exception{
        Parent vscpuWindow = FXMLLoader.load(main2.class.getResource("boatpositionsetup.fxml"));
        Scene s = new Scene(vscpuWindow);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.setResizable(false);
    }
}
