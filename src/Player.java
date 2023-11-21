public class Player {
//who is who

    private String user;
    private int TP= 2;
    private int shipsAlive=6;

    public Player (String uName){
        user = setuName(uName);
    }

    private String setuName(String N) {
        boolean V=false;
        //check if name is usable
        if(N.length() <= 20){
            V=true;
        }
        return N;
    }

}