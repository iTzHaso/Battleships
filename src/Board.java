import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board{
//the Board

    Scanner inputUser = new Scanner(System.in); //input [not sure what to do here]
    //private Player General; //player object
    private int CORDX; //X input
    private int CORDY; //Y input
    private char FACE; //ship direction input
    private int row=10,column=10; //map size
    private int[][] battleField; //where the player's ships go. Status 0=empty / 1=ship / 2=miss / 3=hit
    private int[][] viewField; //where the info about the opponent go
    private Ship[] Fleet; //list of ships
    private String[] Name={"DIS","SUB","CU1","CU2","CAR","BAT"}; //names (not needed)
    private int[] leng = {2,3,3,4,5}; //lengths
    private int xMove=0, yMove=0; //controls direction
    private int xm=0, ym=0;

    public Board (){
        battleField= new int[row][column];
        //setting empty field
        for(int r=0;r<row;r++){
            for(int c=0;c<column;c++){
                battleField[r][c]=0;
                viewField[r][c]=0;
            }
        }
        //making the fleet
        for(int i=0;i < 6;i++){
            storeInput();
            Fleet[i] = new Ship(Name[i],CORDX, CORDY, leng[i], FACE);
        }
    }
    public void storeInput(){
        //stores the user input
        CORDX = inputUser.nextInt();
        CORDY = inputUser.nextInt();
        FACE = inputUser.next().charAt(0);
    }
    public boolean CHECK(int l, int x, int y, char face){
        //checks if location is free
        boolean pass=true;
        //checks if it's a valid location
        if(0<=x && x<=row) {
            if(0<=y && y<=column) {
                setDirection(face);
                for (int i = 0; l > i; i++) {
                    if (battleField[x + xm][y + ym] != 0) {
                        pass = false;
                    }
                    xm = xm + xMove;
                    ym = ym + yMove;
                }
            }else {pass=false;}
        }else {pass=false;}
        return pass;
    }
    public boolean MOVE(int ship,int l, int x, int y, char face){
        //Move starts with CHECK
        boolean moved=false;
        if(CHECK(l,x,y,face)){
            //then Clears previous location and fills new one
            int OX =Fleet[ship].getX();
            int OY =Fleet[ship].getY();
            Fleet[ship].move(x,y,face);
            setDirection(face);
            CLEAR(l,x,y,face);
            for(int i =0;l>i;i++){
                battleField[x+xm][y+xm]=1;
                xm=xm+xMove;
                ym=ym+yMove;
            }
            moved=true;
        }
        return moved;
    }
    public void torp(int x, int y, char FACE, int F){
        setDirection(FACE);
        //F=amount of tiles it travels
        for(int i = 0; F > i; i++){
            if (battleField[x + xm][y + ym] == 1) {
                F=0;
            }
            //returns cord status

            xm = xm + xMove;
            ym = ym + yMove;
        }
    }
    public void CLEAR(int l, int x, int y, char face){
        //remove ship from location [status==1 then set status=0 otherwise leave the status alone]
        //setDirection(face);
        for(int i =0;l>i;i++){
            if(battleField[x+xm][y+ym]==1){
                battleField[x+xm][y+xm]=0;
            }
            xm=xm+xMove;
            ym=ym+yMove;
        }
    }

    public boolean incoming (int x, int y){
        boolean h = true;
        //set the player's board status
        if(battleField[x][y]==0){
            //miss sends back 2
            battleField[x][y]=2;
            h=false;
        }else if(battleField[x][y]==1){
            //hit sends back 3
            battleField[x][y]=3;
            boolean finding = true;
            //finds what ship was hit
            int slot=0;
            while(finding && Fleet.length > slot){
                if(!Fleet[slot].getSink()){
                    setDirection(Fleet[slot].getDirection());
                    for(int i =0;i<Fleet[slot].getLength();i++){
                        if(Fleet[slot].getX()+xm==x && Fleet[slot].getY()+ym==y) {
                            Fleet[slot].hit();
                            sink(slot);
                        finding = false; //stops the ship finding
                        }
                        xm=xm+xMove;
                        ym=ym+yMove;
                    }
                }
                slot++;
            }
        }
        //return the status to the other player[not done]
        return h;
    }
    public void returnFire(int x, int y){
        boolean deciding=true;
        //loop that ends when a valid spot is chosen
        while(deciding){
            if(viewField[x][y]==0){
                deciding=false;
                //somehow send cords to other player
                    sendX(x);
                    sendY(y);
                //receives if hit and all cords of ship if sunk
                int L=receiveL(2);
                for(int i =0;i<2;i++) {
                    sendX(x);
                }
                //updates map

            }else {
                //print massage to choose another spot

            }
        }

    }

    public void sink(int ship){
        int x,y;
        x=Fleet[ship].getX();
        y=Fleet[ship].getY();
        setDirection(Fleet[ship].getDirection());
        Fleet[ship].setSink(true);
        //set all cords on battlefield of all the spots the ship occupies to 3
        for(int i=0;i<Fleet[ship].getLength();i++){
            if(battleField[x][y]==1){
                battleField[x+xm][y+xm]=3;
                //Get this info to the other player
                //[somehow]
            }
            xm=xm+xMove;
            ym=ym+yMove;
        }
    }
    public void setDirection (char face){
        xMove=0;
        yMove=0;
        xm=0;
        ym=0;
        if (face=='W'){
            xMove=1;
        }else if(face=='S'){
            xMove=-1;
        }else if(face=='A'){
            yMove=-1;
        }else if(face=='D'){
            yMove=1;
        }
    }
    //placeholder because I don't know how to get the two player boards to communicate
    public void sendX(int X){

    }
    public int receiveX(int X){
        return X;
    }
    public void sendY(int Y){

    }
    public int receiveY(int Y){
        return Y;
    }
    public void sendStat(int Stat){

    }
    public int receiveStat(int Stat){
        return Stat;
    }
    public void sendL(int L){

    }
    public int receiveL(int L){
        return L;
    }
}