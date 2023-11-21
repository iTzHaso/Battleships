import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board{
//the Board

    Scanner inputUser = new Scanner(System.in);
    int CORDX = inputUser.nextInt();
    //X input
    int CORDY = inputUser.nextInt();
    //Y input
    char FACE = inputUser.next().charAt(0);
    //ship direction input
    protected int row=10,column=10, status = 0;
    //status 0=empty / 1=fill / 2=miss / 3=hit
    protected int[][] battleField;
    private boolean mainB;

    public Board (){
        battleField= new int[row][column];
        //setting empty field
        for(int r=0;r<row;r++){
            for(int c=0;c<column;c++){
                battleField[r][c]=status;
            }
        }
        SET();
        Ship Destroyer = new Ship("DIS",CORDX, CORDY, 2, FACE);
        SET();
        Ship Submarine = new Ship("SUB",CORDX, CORDY, 3, FACE);
        SET();
        Ship Cruiser1 = new Ship("CU1",CORDX, CORDY, 3, FACE);
        SET();
        Ship Cruiser2 = new Ship("CU2",CORDX, CORDY, 3, FACE);
        SET();
        Ship Carrier = new Ship("CAR",CORDX, CORDY, 4, FACE);
        SET();
        Ship Battleship = new Ship("BAT",CORDX, CORDY, 5, FACE);
    }
    public void SET(){
        CORDX = inputUser.nextInt();
        CORDY = inputUser.nextInt();
        FACE = inputUser.next().charAt(0);
        battleField[CORDX][CORDY]=1;
    }
    public boolean MOVE(int l){
        boolean V = false;
        SET();
        //checks if location is free
        for(int i=0; l>i;i++){
            if(battleField[CORDX][CORDY]==0){

            }
        }
        return V;
    }

    public void incoming (int x, int y){
        if(battleField[x][y]==0){
            battleField[x][y]=2;
        }else if(battleField[x][y]==1){
            battleField[x][y]=3;
        }
    }

    public void sink(){

    }
}