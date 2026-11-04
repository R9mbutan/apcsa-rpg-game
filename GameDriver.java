import java.util.*;
public class GameDriver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("You have entered the De'vil's dungeon... you must escape...");
        System.out.println("Which character would you like to be?\n1. Knight\n2. Mage\n3. TACP\n4. Winnie\n5. Random");
        int charChoice = s.nextInt();
        System.out.print("Name your character: ");
        Actor player;
        if (charChoice == 1) {
            player = new Actor(220, 50, 20, s.next(), 200, "Cavalry Charge", 0);
        }
        else if (charChoice == 2) {
            player = new Actor(150, 10, 60, s.next(), 250, "Gaseus Inflatos",0);
        }
        else if (charChoice == 3) {
            player = new Actor(100, 50, 100, s.next(), 2000, "AC-130H Precision Strike",0);
        }
        else if (charChoice == 4) {
            player = new Actor(1000, 0, 0, s.next(), 10, "The Great Might of the People",0);
        }
        else {
            player = new Actor((int) (Math.random()*101), (int) (Math.random()*80), (int) (Math.random()*80), s.next(), (int) (Math.random()*1000), "doo doo", 0);
        }
        
        System.out.println(player);

        s.close();
    }
}
