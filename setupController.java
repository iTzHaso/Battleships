import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.Random;

public class setupController {
    static int row = 10;
    static int column = 10;
    static int x, y;
    static String A;
    static int[][] battleField = new int[row][column];
    static int[][] enemyBattleField = new int[row][column];
    static Random rand = new Random();
    static int ran;

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
        Facing +=A.charAt(2);
        battleField[x ][y] = 1;
        switch (Facing) {
            case "l":
                battleField[x - 1][y] = 1;
                break;
            case "d":
                battleField[x][y +1] = 1;
                break;
            case "r":
                battleField[x +1][y] = 1;
                break;
        }

    }

    private static void EtwoShip() {
        int x, y;
        x = rand.nextInt(4)+6;
        y = rand.nextInt(3)+1;
        enemyBattleField[x][y] = 1;
        if(y <= 1){
            enemyBattleField[x][y + 1] = 1;
        }else{
            enemyBattleField[x][y - 1] = 1;
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
        Facing +=A.charAt(2);
        battleField[x][y] = 1;
        switch (Facing) {
            case "l":
                battleField[x - 1][y] = 1;
                battleField[x - 2][y] = 1;
                break;
            case "d":
                battleField[x][y + 1] = 1;
                battleField[x][y + 2] = 1;
                break;
            case "r":
                battleField[x + 1][y] = 1;
                battleField[x + 2][y] = 1;
                break;
        }

    }

    private static void EthreeShip1() {
        int x, y;
        x = rand.nextInt(5)+1;
        y = rand.nextInt(3)+1;
        enemyBattleField[x][y] = 1;

        if(x < 3){
            enemyBattleField[x + 1][y] = 1;
            enemyBattleField[x + 2][y] = 1;
        }else{
            enemyBattleField[x - 1][y] = 1;
            enemyBattleField[x - 2][y] = 1;
        }

    }

    private static void EthreeShip2() {
        int x, y;
        x = rand.nextInt(4)+1;
        y = rand.nextInt(4)+4;
        enemyBattleField[x][y] = 1;

        if(y >6){
            enemyBattleField[x][y - 1] = 1;
            enemyBattleField[x][y - 2] = 1;
        }else{
            enemyBattleField[x][y + 1] = 1;
            enemyBattleField[x][y + 2] = 1;
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
        Facing +=A.charAt(2);
        battleField[x][y] = 1;
        switch (Facing) {
            case "l":
                battleField[x - 1][y] = 1;
                battleField[x - 2][y] = 1;
                battleField[x - 3][y] = 1;
                break;
            case "d":
                battleField[x][y + 1] = 1;
                battleField[x][y + 2] = 1;
                battleField[x][y + 3] = 1;
                break;
            case "r":
                battleField[x + 1][y] = 1;
                battleField[x + 2][y] = 1;
                battleField[x + 3][y] = 1;
                break;
        }

    }


    private static void EfourShip() {
        int x, y;
        x = rand.nextInt(6)+4;
        y = rand.nextInt(4)+4;
        enemyBattleField[x][y] = 1;
        if(x < 7){
            enemyBattleField[x + 1][y] = 1;
            enemyBattleField[x + 2][y] = 1;
            enemyBattleField[x + 3][y] = 1;
        }else{
            enemyBattleField[x - 1][y] = 1;
            enemyBattleField[x - 2][y] = 1;
            enemyBattleField[x - 3][y] = 1;
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
        Facing +=A.charAt(2);
        battleField[x][y] = 1;
        switch (Facing) {
            case "l":
                battleField[x - 1][y] = 1;
                battleField[x - 2][y] = 1;
                battleField[x - 3][y] = 1;
                battleField[x - 4][y] = 1;
                break;
            case "d":
                battleField[x][y + 1] = 1;
                battleField[x][y + 2] = 1;
                battleField[x][y + 3] = 1;
                battleField[x][y + 4] = 1;
                break;
            case "r":
                battleField[x + 1][y] = 1;
                battleField[x + 2][y] = 1;
                battleField[x + 3][y] = 1;
                battleField[x + 4][y] = 1;
                break;
        }
    }


    private static void EfiveShip() {
        int x, y;
        x = rand.nextInt(9)+1;
        y = rand.nextInt(2)+8;
        enemyBattleField[x][y] = 1;

        if(x < 5){
            enemyBattleField[x + 1][y] = 1;
            enemyBattleField[x + 2][y] = 1;
            enemyBattleField[x + 3][y] = 1;
            enemyBattleField[x + 4][y] = 1;
        }else{
            enemyBattleField[x - 1][y] = 1;
            enemyBattleField[x - 2][y] = 1;
            enemyBattleField[x - 3][y] = 1;
            enemyBattleField[x - 4][y] = 1;
        }
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
        fiveShip(fiveShip);
        EtwoShip();
        EthreeShip1();
        EthreeShip2();
        EfourShip();
        EfiveShip();
        printBoard();
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
    public static void printBoard(){
        for(int i=1; i<10; i++){
            for(int j=1; j<10; j++){
                System.out.print(battleField[j][i] +" ");
            }
            System.out.println();
        }
    }

}
