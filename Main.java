import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Which character would you like to be?\n1. Knight\n2. Mage\n3. TACP\n4. Winnie");
        int charChoice = s.nextInt();
        System.out.println("Name your gameCharacter: ");
        gameCharacter player;
        if (charChoice == 1) {
            player = new gameCharacter(220, 50, 20, s.next(), 200, "Cavalry Charge");
        }
        else if (charChoice == 2) {
            player = new gameCharacter(150, 10, 60, s.next(), 250, "Gaseus Inflatos");
        }
        else if (charChoice == 3) {
            player = new gameCharacter(100, 50, 100, s.next(), 2000, "AC-130H Precision Strike");
        }
        else if (charChoice == 4) {
            player = new gameCharacter(1000, 0, 0, s.next(), 10, "The Great Might of the People");
        }
        else {
            player = new gameCharacter(100, 10, 60, s.next(), 250, "Gaseus Inflatos");
        }
        System.out.println(player);
    }
}
