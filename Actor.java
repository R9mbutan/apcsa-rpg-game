public class Actor {
    //attributes
    private int hp = 100;
    private int contDMG = 5;
    private int ranDMG = 0;
    private String name;
    private int location;

    // constructor
    public Actor(int h, int cD, int rD, String n, int l) {
        this.hp = h;
        this.contDMG = cD;
        this.ranDMG = rD;
        this.name = n;
        this.location = l;
    }

    //getter: hp
    public int getHP() {
        return hp;
    }

    //damage
    public void takeDamage(int d) {
        hp -= d;
    }

    // toString
    public String toString() {
        return "" + name + " (" + hp + " HP, " + contDMG + " hit DMG, " + ranDMG + " range DMG, room " + location + ")";
    }

    //hit; uses damage()
    public void hit(Actor a) {
        //must be same room
        if (a.location == this.location) {
            a.hp -= this.contDMG;
            System.out.println(this.name + " hit " + a.name + " for " + this.contDMG + " damage");
        }
        else 
            System.out.println(this.getName() + " missed!");
    }
    //shoot; uses damage()
    public void shoot(Actor a) {
        //range is 2 rooms
        if (a.location - this.location < 3) {
            a.hp -= this.ranDMG;
            System.out.println(this.name + " shot " + a.name + " for " + this.ranDMG + " damage");
        }
        else 
            System.out.println(this.getName() + " missed!");
    }

    public void upgrade(int h, int cD, int rD) {
        this.hp += h;
        this.contDMG += cD;
        this.ranDMG += rD;
    }


    //not used
    public void setLocation(int r){
        this.location = r;
    }
    //move fwd or bkwd
    public void linearMove(int d){
        this.location += d;
    }

    //getter: location
    public int getLoc(){
        return location;
    }
    //getter: name
    public String getName(){
        return name;
    }
}
