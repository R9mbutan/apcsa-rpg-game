public class Player extends Actor {
    private double dodge;
    public Player(int h, int cD, int rD, String n, int sD, String sN, int l, double d) {
        super(h, cD, rD, n, sD, sN, l);
        this.dodge = d;
    }
    public boolean dodge(){
        if (Math.random() > this.dodge)
            return true;
        else return false; 
    }
    public String toString(){
        return super.toString() + " (Dodge chance: " + dodge;
    }
}
