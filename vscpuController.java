import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ResourceBundle;

public class vscpuController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillBoards();
    }


    @FXML
    private GridPane eBoard;

    @FXML
    private GridPane pBoard;


    private void fillBoards(){
        Image blue = new Image("blue.jpg");
        pBoard.setGridLinesVisible(true);
        eBoard.setGridLinesVisible(true);
    }

}
