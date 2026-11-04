import java.util.ArrayList;

public class Room {
    Actor hobe = new Actor(10000, 0, 0, "Hobe", 1000000, "Smush", -1);
    
    Actor skeletony = new Actor(100, 0, 50, "Skeletony", 100, "Flurry", 1);
    Actor bone = new Actor(100, 0, 50, "Bo(ne)", 100, "Flurry", 1);
    Actor skeletom = new Actor(100, 70, 50, "Skeletom", 100, "Flurry", 1);

    Actor vex1 = new Actor(50, 30, 0, "Vextor", 0, null, 4);
    Actor vex2 = new Actor(50, 30, 0, "Vex Luthor", 0, null, 4);
    Actor vex3 = new Actor(50, 30, 0, "Venx", 0, null, 4);
    Actor vex4 = new Actor(50, 30, 0, "Vextor", 0, null, 4);
    Actor vex5 = new Actor(50, 30, 0, "Robert", 0, null, 4);

    Actor zom1 = new Actor(150, 50, 0, "Zominic", 100, "Burp", 5);
    Actor zom2 = new Actor(150, 50, 0, "Zominic", 100, "Burp", 5);
    Actor zom3 = new Actor(150, 50, 0, "Zominic", 100, "Burp", 5);

    Actor carnage = new Actor(666, 120, 70, "Carnage", 300, "", 7);
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
