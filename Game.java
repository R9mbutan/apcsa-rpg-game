import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {  
    public static boolean gameOver = false;

    public static ArrayList<Actor> environ = new ArrayList<>(); 
    public static ArrayList<Actor> enraged = new ArrayList<>(); 

    public static void main(String[] args){
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

        Collections.addAll(environ, hobe, skeletony, bone, skeletom, vex1, vex2, vex3, vex4, vex5, zom1, zom2, zom3, carnage);
    }

    public static void run(Actor player){
        Scanner input = new Scanner(System.in);

        if (player.getHP() > 0) {
            int numEnemies = 0;
            String targets = "";
            for (Actor a : environ){
                if (a.getLoc() == player.getLoc()){
                    enraged.add(a);
                    numEnemies++;
                    targets = targets + numEnemies + ". " + a.getName() + " (Room" + a.getLoc() + ")";
                }
            }
            System.out.println("You are in room " + player.getLoc() + ". There are " + numEnemies + " enemies. What would you like to do?");
            System.out.println("1. Move Forwards\n2. Hit\n3. Shoot\n4. Move Backwards");
            try{
                if (input.nextInt() == 1){
                    player.linearMove(1);
                    System.out.println("Moved to room " + player.getLoc());
                }
                else if (input.nextInt() == 2){
                    if (enraged.size() > 0){
                    System.out.println("Hit which enemy? " + targets);
                    player.hit(enraged.get(input.nextInt()));
                    }
                    else
                        System.out.println("There are no enemies to attack");
                }
                else if (input.nextInt() == 3){
                    if (enraged.size() > 0){
                    System.out.println("Shoot which enemy? " + targets);
                    player.shoot(enraged.get(input.nextInt()));
                    }
                    else
                        System.out.println("There are no enemies to attack");
                }
                else if (input.nextInt() == 4){
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
                            if(Math.random()>0.5)
                                enraged.get((int) ((double) Math.random()*enraged.size())).hit(player);
                            else
                                enraged.get((int) ((double) Math.random()*enraged.size())).shoot(player);

                        }
                    }
                }
        }
        else 
            gameOver = true;
    }
}
