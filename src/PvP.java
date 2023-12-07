import java.util.Scanner;

public class PvP {
    private int turnCount=0;
    private Board PB1;
    private Player P1;
    private Board PB2;
    private Player P2;
    Scanner inputUser = new Scanner(System.in); //input [not sure what to do here]
    private int CORDX; //X input
    private int CORDY; //Y input
    private char FACE; //ship direction input
    private String NAME; //username


    public PvP (){
        PB1= new Board();
        P1= new Player(NAME);
        PB2= new Board();
        P2= new Player(NAME);
    }
    public void receiveX(){
        CORDX=inputUser.nextInt();
    }
    public void receiveY(){
        CORDY = inputUser.nextInt();
    }
    public void receiveFACE(){
        FACE = inputUser.next().charAt(0);
    }
    public void receiveNAME(){

    }
}
