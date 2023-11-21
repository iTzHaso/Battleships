public class SNode {
//the individual ship parts

    protected int X,Y,S; //X & Y = Cords S = what position it is in the ship

    SNode(){}
    SNode (int x,int y,int s){
        X=setX(x);
        Y=setY(y);
        S=s;
    }

    private int setY(int num) {
        return num;
    }

    private int setX (int num){
        return num;
    }
}