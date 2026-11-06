import java.util.*;
public class GameDriver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Welcome message
        System.out.println("You have entered the De'vil's dungeon... you must escape...\n Get to room 8 to escape!");
        System.out.println("Which character would you like to be?\n1. Knight\n2. Mage\n3. TACP\n4. Winnie\n5. Random");
        int charChoice = s.nextInt();
        System.out.print("Name your character: ");
        //Series of if statements that checks 
        //what the player has chosen for its character
        Player player;
        if (charChoice == 1) {
            player = new Player(720, 100, 50, s.next(), 200, "Cavalry Charge", 0, 0.2);
        }
        else if (charChoice == 2) {
            player = new Player(650, 10, 200, s.next(), 250, "Gaseus Inflatos",0, .5);
        }
        else if (charChoice == 3) {
            player = new Player(600, 80, 150, s.next(), 2000, "AC-130H Precision Strike",0, 0.35);
        }
        else if (charChoice == 4) {
            player = new Player(1500, 1, 1, s.next(), 1, "The Great Might of the People",0, 1);
        }
        else {
            player = new Player((int) (Math.random()*501), (int) (Math.random()*500), (int) (Math.random()*500), s.next(), (int) (Math.random()*1000), "doo doo", 0, Math.random());
        }


        
        System.out.println(player);
        //The Game continues until the game is over 
        //And until they reach the end
        while (!Game.gameOver && player.getLoc() < 8){
            Game.run(player);
            System.out.println("___________________________");
        }
        //If player's not dead and gets to end, they win
        if (!Game.gameOver) 
            System.out.println("You win!");
        //Closes the input
        s.close();
    }
}
