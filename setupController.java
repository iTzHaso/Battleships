import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.swing.*;

public class setupController {
    static int row = 10;
    static int column = 10;
    static int x, y;
    static String A;
    static int[][] battleField = new int[row][column];
    static int[][] enemyBattleField = new int[row][column];


    @FXML
    public TextField fiveShipPos;

    @FXML
    public TextField fourShipPos;

    @FXML
    public Button submitPositions;

    @FXML
    public TextField threeShipOnePos;

    @FXML
    public TextField threeShipTwoPos;

    @FXML
    public TextField twoShipPos;




    private static void twoShip(String A) {
        String str1 = "";
        String str2 = "";
        str1 += A.charAt(0);
        str2 += A.charAt(1);
        x = Integer.parseInt(str1);
        y = Integer.parseInt(str2);


        String Facing = "";
        System.out.println(Facing);
        battleField[x][y] = 1;



        switch (Facing) {
            case "l":
                battleField[x - 2][y - 1] = 1;
                break;
            case "d":
                battleField[x - 1][y] = 1;
                break;
            case "r":
                battleField[x][y - 1] = 1;
                break;
        }

    }

    private static void threeShip(String A) {
        String str1 = "";
        String str2 = "";
        str1 += A.charAt(0);
        str2 += A.charAt(1);
        x = Integer.parseInt(str1);
        y = Integer.parseInt(str2);
        String Facing = "";
        battleField[x - 1][y - 1] = 1;
        switch (A) {
            case "l":
                battleField[x - 2][y - 1] = 1;
                battleField[x - 3][y - 1] = 1;
                break;
            case "d":
                battleField[x - 1][y] = 1;
                battleField[x - 1][y + 1] = 1;
                break;
            case "r":
                battleField[x][y - 1] = 1;
                battleField[x + 1][y - 1] = 1;
                break;
        }

    }

    private static void fourShip(String A) {
        String str1 = "";
        String str2 = "";
        str1 += A.charAt(0);
        str2 += A.charAt(1);
        x = Integer.parseInt(str1);
        y = Integer.parseInt(str2);
        String Facing = "";
        battleField[x - 1][y - 1] = 1;
        switch (A) {
            case "l":
                battleField[x - 2][y - 1] = 1;
                battleField[x - 3][y - 1] = 1;
                battleField[x - 4][y - 1] = 1;
                break;
            case "d":
                battleField[x - 1][y] = 1;
                battleField[x - 1][y + 1] = 1;
                battleField[x - 1][y + 2] = 1;
                break;
            case "r":
                battleField[x][y - 1] = 1;
                battleField[x + 1][y - 1] = 1;
                battleField[x + 2][y - 1] = 1;
                break;
        }

    }
    private static void fiveShip(String A) {
        String str1 = "";
        String str2 = "";
        str1 += A.charAt(0);
        str2 += A.charAt(1);
        x = Integer.parseInt(str1);
        y = Integer.parseInt(str2);
        String Facing = "";
        battleField[x - 1][y - 1] = 1;
        switch (A) {
            case "l":
                battleField[x - 2][y - 1] = 1;
                battleField[x - 3][y - 1] = 1;
                battleField[x - 4][y - 1] = 1;
                battleField[x - 5][y - 1] = 1;
                break;
            case "d":
                battleField[x - 1][y] = 1;
                battleField[x - 1][y + 1] = 1;
                battleField[x - 1][y + 2] = 1;
                battleField[x - 1][y + 3] = 1;
                break;
            case "r":
                battleField[x][y - 1] = 1;
                battleField[x + 1][y - 1] = 1;
                battleField[x + 2][y - 1] = 1;
                battleField[x + 3][y - 1] = 1;
                break;
        }
    }
    private static void fillenemyBattleField() {
        enemyBattleField[1][1] = 1;
        enemyBattleField[2][1] = 1;
        enemyBattleField[7][2] = 1;
        enemyBattleField[7][3] = 1;
        enemyBattleField[7][4] = 1;
        enemyBattleField[5][9] = 1;
        enemyBattleField[6][9] = 1;
        enemyBattleField[7][9] = 1;
        enemyBattleField[8][9] = 1;
        enemyBattleField[1][4] = 1;
        enemyBattleField[1][5] = 1;
        enemyBattleField[1][6] = 1;
        enemyBattleField[1][7] = 1;
        enemyBattleField[1][8] = 1;
        enemyBattleField[6][2] = 1;
        enemyBattleField[6][3] = 1;
        enemyBattleField[6][4] = 1;

    }
    public void placeShips(MouseEvent event){
        String twoShip = twoShipPos.getText();
        twoShip(twoShip);

        String threeShipOne = threeShipOnePos.getText();
        threeShip(threeShipOne);
        String threeShipTwo = threeShipTwoPos.getText();
        threeShip(threeShipTwo);
        String fourShip = fourShipPos.getText();
        fourShip(fourShip);
        String fiveShip = fiveShipPos.getText();
        fourShip(fiveShip);
        fillenemyBattleField();
        try{
            Parent vscpuWindow = FXMLLoader.load(main1.class.getResource("vscpu.fxml"));
            Scene s = new Scene(vscpuWindow);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(s);
            window.setResizable(false);
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}
