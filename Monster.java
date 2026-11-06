public class Monster extends Actor {
    public boolean activated = false;
    //Constructor of Monster that inherits from Actor
    public Monster(int h, int cD, int rD, String n, int sD, String sN, int l) {
        super(h, cD, rD, n, sD, sN, l);
    }
    //method that toggles whether or not a Monster object can see you
    public void activate(){
        activated = true;
    }
    //Method that targets the actor object passed into the parameter
    public void pursue(Actor target){
        if (target.getLoc() > this.getLoc()) {
            linearMove(1);
        }
        else if (target.getLoc() < this.getLoc()) {
            linearMove(-1);
        }
    }
}
