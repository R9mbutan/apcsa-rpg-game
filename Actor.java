public class Actor {
    private int hp = 100;
    private int contDMG = 5;
    private int ranDMG = 0;


    public Actor(int h, int cD, int rD) {
        this.hp = h;
        this.contDMG = cD;
        this.ranDMG = rD;
    }

    public int getHP() {
        return hp;
    }

    public void takeDamage(int d) {
        hp -= d;
    }

    public String toString() {
        return "This has " + hp + " health points and deals " + contDMG + " contact damage" + ((ranDMG != 0) ? " and " + ranDMG + " ranged damage." : ".");
    }

    public void dealDamage(Actor a, boolean isCont) {
        if (isCont) 
            a.takeDamage(contDMG);
        else
            a.takeDamage(ranDMG);
    }
    
    public void upgrade(int h, int cD, int rD) {
        this.hp += h;
        this.contDMG += cD;
        this.ranDMG += rD;
    }
}
