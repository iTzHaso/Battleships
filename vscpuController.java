import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import static java.lang.Character.isDigit;

public class vscpuController extends setupController implements Initializable{

    int playerRemainingHits = 17;
    int enemyRemainingHits = 17;
    boolean wl = false;
    Random rand = new Random();
    int rMax = 9;
    int rMin = 0;

    @FXML
    private GridPane eBoard;

    @FXML
    private GridPane pBoard;

    @FXML
    private Button submitAttack;

    @FXML
    private TextField target;

    @FXML
    private Text enemyHMNotif;

    @FXML
    private Text hmNotif;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        eBoard.setGridLinesVisible(true);
        eBoard.setStyle("-fx-background-Color: blue");
        pBoard.setGridLinesVisible(true);
        pBoard.setStyle("-fx-background-Color: blue");



        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++) {
                if (enemyBattleField[i][j] == 1) {

                    Rectangle Rect = new Rectangle(39, 39);
                    Rect.setFill(Color.BLACK);
                    pBoard.add(Rect, i - 1, j - 1);

                }

            }
        }
    }



    public void submitAttack(MouseEvent event){
        int xcoord;
        int ycoord;
        String str1 = "";
        String str2 = "";
        String attackTarget = target.getText();
        str1 += attackTarget.charAt(0);
        xcoord = Integer.parseInt(str1);



        for (int i = 1; i<=attackTarget.length(); i++){
            if (isDigit(attackTarget.charAt(i))){
                str2 += attackTarget.charAt(i);
                i = attackTarget.length()+1;
            }
        }
        ycoord = Integer.parseInt(str2);
        System.out.println(xcoord);
        System.out.print(ycoord);



        if(enemyBattleField[xcoord][ycoord] == 1){
            enemyBattleField [xcoord][ycoord] = 0;
            hmNotif.setText("Hit!");

            Rectangle Rect = new Rectangle(39, 39);
            Rect.setFill(Color.RED);
            eBoard.add(Rect,xcoord - 1,ycoord - 1 );


            enemyRemainingHits--;
            if (enemyRemainingHits == 0){
                hmNotif.setText("All enemy ships sunk! You win!");
                enemyHMNotif.setText("");
                wl = true;
            }
        }
        else{
            hmNotif.setText("Miss!");

            Rectangle Rect = new Rectangle(39, 39);
            Rect.setFill(Color.WHITE);
            eBoard.add(Rect,xcoord - 1,ycoord - 1 );
        }
        if (!wl){
            xcoord = rand.nextInt(rMax-rMin) + 1;
            ycoord = rand.nextInt(rMax-rMin) + 1;


        }
        if (battleField [xcoord][ycoord] == 1){
            battleField [xcoord][ycoord] = 9;
            enemyHMNotif.setText("Enemy attacked [" + xcoord + "], [" + ycoord + "], Hit!");
            playerRemainingHits -= 1;

            Rectangle Rect = new Rectangle(39, 39);
            Rect.setFill(Color.RED);
            pBoard.add(Rect,xcoord - 1,ycoord - 1 );
        }
        else{
            enemyHMNotif.setText("Enemy attacked [" + xcoord + "], [" + ycoord + "], Miss!");

            Rectangle Rect = new Rectangle(39, 39);
            Rect.setFill(Color.WHITE);
            pBoard.add(Rect,xcoord - 1,ycoord - 1 );
        }
        if (playerRemainingHits == 0){
            enemyHMNotif.setText("All ships sunk! You lose!");
            hmNotif.setText("");
            wl = true;
        }
    }
}

