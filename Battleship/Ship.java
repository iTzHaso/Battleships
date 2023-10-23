package Battleship;

public class Ship {
    private int HP;
    private String name;
    //[X][Y][Ship slot]
    private int[][][] Cord;



    public Ship(String name){
        setName(name);
    }
    public int hit(int hp){
        return hp--;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int move(){

    }
}
