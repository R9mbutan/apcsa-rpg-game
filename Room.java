import java.util.ArrayList;

public class Room {
    public ArrayList<Actor> monsters;
    Actor hobe = new Actor(10000, 0, 0, "Hobe", 1000000, "", -1);
    
    Actor skeletony = new Actor(100, 0, 50, "Skeletony", 100, "Flurry", 1);
    Actor bone = new Actor(100, 0, 50, "Bo(ne)", 100, "Flurry", 1);
    Actor skeletom = new Actor(100, 70, 50, "Skeletom", 100, "Flurry", 1);

    

    /*
    Room -1 : Hobe death
    Room 0 : starting
    Room 1 : Skeletons
    Room 2 : Ask between 2 paths
    Room 3 : Hobe
    Room 4 : 5 Vexes (after killing  1, the rest flee and wander)
    Room 5 : 3 zombies
    Room 6 : Restoration
    Room 7 : Carsiniage
    Room 8 : Bron
     */
    //testing
    public Room() {

    }
}
