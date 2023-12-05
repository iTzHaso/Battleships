public class Player {
//who is who

    private String user;
    private int TP= 2;
    private int shipsAlive=6;

    public Player (String uName){
        user = setuName(uName);
    }

    public String setuName(String N) {
        boolean V=false;
        //check if name is usable
        if(N.length() <= 20){
            V=true;
        }
        return N;
    }
    public void sunkShip(){
        shipsAlive--;
    }
    public void TPgain(){
        TP++;
    }
    public void TPloss(int A){
        if (A<TP){
            TP=TP-A;
        }else{
            TP=0;
        }
    }

}