public class gameCharacter extends Actor {
    private String name;
    private int specDMG = 0;
    private double specCharge = 0;
    private String specAttack;
    
    public gameCharacter(int h, int cD, int rD, String n, int sD, String sN) {
        super(h, cD, rD);
        this.name = n;
        this.specDMG = sD;
        this.specAttack = sN;
    }

    public String toString() {
        return "This is " + name + " whose special attack is " + specAttack;
    } 

}
