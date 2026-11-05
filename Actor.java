public class Actor {
    private int hp = 100;
    private int contDMG = 5;
    private int ranDMG = 0;
    private String name;
    private int specDMG = 0;
    private double specCharge = 0;
    private String specAttack;
    private int location;

    public Actor(int h, int cD, int rD, String n, int sD, String sN, int l) {
        this.hp = h;
        this.contDMG = cD;
        this.ranDMG = rD;
        this.name = n;
        this.specDMG = sD;
        this.specAttack = sN;
        this.location = l;
    }

    public int getHP() {
        return hp;
    }

    public void takeDamage(int d) {
        hp -= d;
    }

    public String toString() {
        return "This is " + name + " with " + hp + " health points and deals " + contDMG + " contact damage" + ((ranDMG != 0) ? " and " + ranDMG + " ranged damage" : "") + " whose special attack is " + specAttack;
    }

    public void hit(Actor a) {
        if (a.location == this.location) {
            a.hp -= this.contDMG;
            System.out.println(this.name + " hit " + a.name + " for " + this.contDMG + " damage");
        }
        else 
            System.out.println("Missed!");
    }
    public void shoot(Actor a) {
        if (a.location - this.location < 3) {
            a.hp -= this.ranDMG;
            System.out.println(this.name + " shot " + a.name + " for " + this.ranDMG + " damage");
        }
        else 
            System.out.println("Missed!");
    }
    
    public void upgrade(int h, int cD, int rD, int sD, double sC) {
        this.hp += h;
        this.contDMG += cD;
        this.ranDMG += rD;
        this.specDMG += sD;
        this.specCharge += sC;
    }

    

    public void setLocation(int r){
        this.location = r;
    }
    public void linearMove(int d){
        this.location += d;
    }

    public int getLoc(){
        return location;
    }

    public String getName(){
        return name;
    }
}
