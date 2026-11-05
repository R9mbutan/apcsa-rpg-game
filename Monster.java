public class Monster extends Actor {
    public boolean activated = false;
    
    public Monster(int h, int cD, int rD, String n, int sD, String sN, int l) {
        super(h, cD, rD, n, sD, sN, l);
    }

    public void activate(){
        activated = true;
    }
    
    public void pursue(Actor target){
        if (target.getLoc() > this.getLoc()) {
            linearMove(1);
        }
        else if (target.getLoc() < this.getLoc()) {
            linearMove(-1);
        }
    }
}
