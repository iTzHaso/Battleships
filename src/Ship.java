import java.util.*;


public class Ship extends SNode{
//the ship...
    protected int HP, Length;
    protected String name;
    // determines type of ship maybe
    protected SNode []slot;
    protected char direction;
    //W=up A=left S=down D=right
    //start from 0 then move down the ship Cord[X(--{A})(++{D})][Y(--{S})(++{W})][f++]
    //ex. if direction=A the ship would look like this [4] [3] [2] [1] [0] = ship slot
    //                                                  <-  <-  <-  <-  <-
    //protected String player;




    public Ship(){}
    public Ship(String name, int X, int Y, int length, char face){
        super();
        setName(name);
        setCord(X,Y,length,face);
    }

    private void setCord(int x, int y, int l, char f) {
        direction=f;
        int xMove=0,yMove=0;
        int xm=0, ym=0;
        if (f=='W'){
            xMove=1;
        }else if(f=='S'){
            xMove=-1;
        }else if(f=='A'){
            yMove=-1;
        }else if(f=='D'){
            yMove=1;
        }

        for (int i=0;i < l;i++) {
            slot [l]= new SNode(X+xm, Y+ym, i);
            xm=xm+xMove;
            ym=ym+yMove;
        }
    }

    public int hit(int hp){
        return hp--;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void move(int X, int Y, char F){

    }
    public void sink(){

    }
    public int getLength(){
        return Length;
    }
}