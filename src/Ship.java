import java.util.*;


public class Ship{
//the ship...
    private int HP, Length;
    private String name; // determines type of ship maybe (not yet or at all)
    private char direction; //W=up A=left S=down D=right
    //start from 0 then move down the ship Cord[X(--{A})(++{D})][Y(--{S})(++{W})][f++]
    //ex. if direction=A the ship would look like this [4] [3] [2] [1] [0] = ship part //[0] is the back of the ship
    //                                                  <-  <-  <-  <-  <-
    private int x, y; //ship's first cord
    private boolean sunk = false; //keeps track if the ship is sunk




    //public Ship(){}
    public Ship(String name, int X, int Y, int length, char face){
        setName(name);
        setHP(length);
        setInfo(X,Y,length,face);
    }

    private void setInfo(int x, int y, int l, char f) {
        direction=f;
        this.x=x;
        this.y=y;
        Length=l;
    }

    public int hit(){
        HP--;
        if(HP<0){
            sunk=true;
        }
        return HP;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void move(int X, int Y, char F){
        x=X;
        y=Y;
        direction=F;
    }
    public boolean getSink(){
        return sunk;
    }
    public void setSink(boolean s){
        sunk=s;
    }
    public int getLength(){
        return Length;
    }
    public char getDirection(){
        return direction;
    }
    public void setHP(int L){
        HP=L;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}