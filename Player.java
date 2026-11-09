public class Player extends Actor {
    //dodge chance
    private double dodge;
    private int specDMG = 0;
    //charge (0 to use. start with one charge)
    public double specCharge = 0;
    //name of special attack
    private String specAttack;
    //construction
    public Player(int h, int cD, int rD, String n, int sD, String sN, int l, double d) {
        //call actor constructor
        super(h, cD, rD, n, l);
        //set other attributes
        this.dodge = d;
        this.specDMG = sD;
        this.specAttack = sN;
    }
    public boolean dodge(){
        //successful dodge: charge 1/4 
        if (Math.random() > this.dodge){
            this.charge(0.25);
            return true;
        }
        //unsuccessful dodge: charge 1/10
        else {
            this.charge(0.1);
            return false;
        }
    }
    //@Override
    public String toString(){
        return super.toString() + " (Dodge chance: " + dodge + ", Special Attack: " + specAttack + ", " + specDMG + " [" + specCharge + "])";
    }
    //check the charge. If enough, use
    public void special(Monster m){
        if (specCharge <= 0){
            specCharge = 1;
            m.takeDamage(specDMG);
            System.out.println("You used " + specAttack + " on " + m.getName() + " for " + specDMG + " damage!");
        }
        else
            System.out.println("You do not have enough charge to use the special attack.");
    }
    //charge
    public void charge(double c){
        specCharge -= c;
        //limit to not exceed 100%
        if (specCharge < 0) specCharge = 0;
    }
}
