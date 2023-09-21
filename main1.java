import java.util.*;





public class main1 {
    static Scanner sc = new Scanner(System.in);
    static int row = 10;
    static int column = 10;
    static int x, y;
    static String A;
    static int[][] battleField = new int [row][column];



    public static void printBoard(){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.print(battleField[j][i] +" ");
            }
            System.out.println();
        }
    }




    public static void twoShip(int x,int y, String A ){
        System.out.println("enter your the front of your 1x2 ship followed by what way you want it to face ex(2 2 l)");
        x = sc.nextInt();
        y = sc.nextInt();
        A = sc.next();
        battleField[x- 1][y - 1] = 1;
        switch(A){
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

    public static void threeShip(int x,int y, String A ){
        System.out.println("enter your the front of your 1x3 ship followed by what way you want it to face ex(2 2 l)");
        x = sc.nextInt();
        y = sc.nextInt();
        A = sc.next();
        battleField[x - 1][y - 1] = 1;
        switch(A){
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
    public static void fourShip(int x,int y, String A ){
        System.out.println("enter your the front of your 1x4 ship followed by what way you want it to face ex(2 2 l)");
        x = sc.nextInt();
        y = sc.nextInt();
        A = sc.next();
        battleField[x - 1][y - 1] = 1;
        switch(A){
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

    public static void fiveShip(int x,int y, String A ){
        System.out.println("enter your the front of your 1x5 ship followed by what way you want it to face ex(2 2 l)");
        x = sc.nextInt();
        y = sc.nextInt();
        A = sc.next();
        battleField[x - 1][y - 1] = 1;
        switch(A){
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

    public static void main(String[] args){

       printBoard();

       twoShip(x,y,A);
       threeShip(x,y,A);
       fourShip(x,y,A);
       fiveShip(x,y,A);

       printBoard();




    }
}
