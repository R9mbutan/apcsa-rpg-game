public class Player extends Actor {
    private double dodge;
    private int specDMG = 0;
    private double specCharge = 0;
    private String specAttack;
    public Player(int h, int cD, int rD, String n, int sD, String sN, int l, double d) {
        super(h, cD, rD, n, l);
        this.dodge = d;
        this.specDMG = sD;
        this.specAttack = sN;
    }
    public boolean dodge(){
        if (Math.random() > this.dodge)
            return true;
        else return false; 
    }
    public String toString(){
        return super.toString() + " (Dodge chance: " + dodge + ", Special Attack: " + specAttack + ", " + specDMG + " [" + specCharge + "])";
    }
    public void special(Monster m){
        if (specCharge <= 0){
            specCharge = 1;
            m.takeDamage(specDMG);
        }
    }
    public void charge(double c){
        specCharge -= c;
    }
}
