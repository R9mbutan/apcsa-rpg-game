import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {  
    public static boolean gameOver = false;

    public static ArrayList<Monster> environ = new ArrayList<>(); 
    public static ArrayList<Monster> enraged = new ArrayList<>(); 

    //public static void main(String[] args){
    static {
        Monster hobe = new Monster(10000, 1000, 0, "Hobe", 1000000, "Smush", -1);
        
        Monster skeletony = new Monster(100, 0, 50, "Skeletony", 100, "Flurry", 1);
        Monster bone = new Monster(100, 0, 50, "Bo(ne)", 100, "Flurry", 1);
        Monster skeletom = new Monster(100, 70, 50, "Skeletom", 100, "Flurry", 1);

        Monster vex1 = new Monster(50, 30, 0, "Vextor", 0, null, 4);
        Monster vex2 = new Monster(50, 30, 0, "Vex Luthor", 0, null, 4);
        Monster vex3 = new Monster(50, 30, 0, "Venx", 0, null, 4);
        Monster vex4 = new Monster(50, 30, 0, "Vextor", 0, null, 4);
        Monster vex5 = new Monster(50, 30, 0, "Robert", 0, null, 4);

        Monster zom1 = new Monster(150, 50, 0, "Zominic", 100, "Burp", 5);
        Monster zom2 = new Monster(150, 50, 0, "Zominic", 100, "Burp", 5);
        Monster zom3 = new Monster(150, 50, 0, "Zominic", 100, "Burp", 5);

        Monster carnage = new Monster(666, 120, 70, "Carnage", 300, "", 7);

        Collections.addAll(environ, hobe, skeletony, bone, skeletom, vex1, vex2, vex3, vex4, vex5, zom1, zom2, zom3, carnage);
    }

    public static void run(Player player){
        Scanner input = new Scanner(System.in);

        if (player.getHP() > 0) {
            int numEnemies = 0;
            String targets = "";
            for (Monster a : environ){
                if (a.getLoc() == player.getLoc()){
                    enraged.add(a);
                    numEnemies++;
                    targets = targets + numEnemies + ". " + a + "\n";
                }
            }
            System.out.println("You are in room " + player.getLoc() + ". There are " + numEnemies + " enemies: " + targets + " What would you like to do?");
            System.out.println("1. Move Forwards\n2. Hit\n3. Shoot\n4. Move Backwards");
            try{
                int action = input.nextInt();
                if (action == 1){
                    player.linearMove(1);
                    System.out.println("Moved to room " + player.getLoc());
                }
                else if (action == 2){
                    if (enraged.size() > 0){
                    System.out.println("Hit which enemy? " + targets);
                    player.hit(enraged.get(input.nextInt()-1));
                    }
                    else
                        System.out.println("There are no enemies to attack");
                }
                else if (action == 3){
                    if (enraged.size() > 0){
                    System.out.println("Shoot which enemy? " + targets);
                    player.shoot(enraged.get(input.nextInt()));
                    }
                    else
                        System.out.println("There are no enemies to attack");
                }
                else if (action == 4){
                    player.linearMove(-1);
                    System.out.println("Moved to room " + player.getLoc());
                }
                else
                    System.out.println("What? try again.");
                

                
            }catch(Exception e){System.out.println("invalid input");}


            if (enraged.size() > 0) {
                    for(int i = enraged.size(); i > 0; i--) {
                        if(Math.random()>0.5)
                        {
                            if(Math.random()>0.5){
                                if (!player.dodge()){
                                    enraged.get((int) ((double) Math.random()*enraged.size())).hit(player);
                                    System.out.println("You have " + player.getHP() + " health remaining.");
                                }
                                else System.out.println("The enemy missed!");
                            }
                            else{
                                if (!player.dodge()){
                                enraged.get((int) ((double) Math.random()*enraged.size())).shoot(player);
                                System.out.println("You have " + player.getHP() + " health remaining.");
                                }
                                else System.out.println("The enemy missed!");
                            }
                        }
                        enraged.get((int) ((double) Math.random()*enraged.size())).pursue(player);
                    }
                }
        }
        else {
            gameOver = true;
            System.out.println("You died!");
        }
    }
}
