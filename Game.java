import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {  
    public static boolean gameOver = false;

    //environ for loops
    public static ArrayList<Monster> environ = new ArrayList<>(); 
    //enraged to store enemies who know you exist and will follow/attack you
    public static ArrayList<Monster> enraged = new ArrayList<>(); 

    //public static void main(String[] args){
    static {
        Monster hobe = new Monster(10000, 1000, 0, "Hobe", -1);
        
        Monster skeletony = new Monster(100, 0, 50, "Skeletony",  1);
        Monster bone = new Monster(100, 0, 50, "Bo(ne)", 1);
        Monster skeletom = new Monster(100, 70, 50, "Skeletom", 1);

        Monster vex1 = new Monster(50, 30, 0, "Vextor", 4);
        Monster vex2 = new Monster(50, 30, 0, "Vex Luthor", 4);
        Monster vex3 = new Monster(50, 30, 0, "Venx", 4);
        Monster vex4 = new Monster(50, 30, 0, "Vextor", 4);
        Monster vex5 = new Monster(50, 30, 0, "Robert", 4);

        Monster zom1 = new Monster(150, 50, 0, "Zominic", 5);
        Monster zom2 = new Monster(150, 50, 0, "Zames", 5);
        Monster zom3 = new Monster(150, 50, 0, "Zayden", 5);

        Monster carnage = new Monster(666, 120, 70, "Carnage", 7);

        //add all objects
        Collections.addAll(environ, hobe, skeletony, bone, skeletom, vex1, vex2, vex3, vex4, vex5, zom1, zom2, zom3, carnage);
    }

    //run on a player
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
            System.out.println("1. Move Forwards\n2. Hit\n3. Shoot\n4. Move Backwards\n5. Special Attack (" + (int) ((1.0-player.specCharge)*100) + "% ready)");
            try{
                int action = input.nextInt();
                if (action == 1){// move
                    //pass if final boss gone
                    if (!(player.getLoc() == 7 && environ.indexOf(carnage) != -1)) {
                        player.linearMove(1);
                        System.out.println("Moved to room " + player.getLoc());

                        //if you move into room 6, upgrade and heal
                        //secret tactic: move to and fro room 6 to heal and upgrade a ton
                        if (player.getLoc() == 6)
                            player.upgrade(200, 100, 100);
                    }
                        //can't move
                    else System.out.println("You must defeat Carnage to pass!");
                }
                else if (action == 2){// hit
                    if (enraged.size() > 0){// enemies?
                        System.out.print("Hit which enemy? " + targets + "Enemy: ");
                        player.hit(enraged.get(input.nextInt()-1));
                    }
                    else
                        System.out.println("There are no enemies to attack");
                }
                else if (action == 3){// shoot
                    if (enraged.size() > 0){// enemies?
                    System.out.print("Shoot which enemy? " + targets + "Enemy: ");
                    player.shoot(enraged.get(input.nextInt())-1);
                    }
                    else
                        System.out.println("There are no enemies to attack");
                }
                else if (action == 4){ // move backward
                    player.linearMove(-1);
                    //room 6 upgrade and stuff
                    if (player.getLoc() == 6)
                            player.upgrade(200, 100, 100);
                    System.out.println("Moved to room " + player.getLoc());
                }
                else if (action == 5){// use special
                    System.out.println("Beat down which enemy? " + targets);
                    player.special(enraged.get(input.nextInt()));
                }
                else //invalid inputs - skip turn
                    System.out.println("No action selected.");
                

                
            }catch(Exception e){System.out.println("invalid input");}//catch errors


            if (enraged.size() > 0) {//monster act
                //50% chance for each activated enemy to act (or 3, if there are 6 or more enemies)
                    for(int i = (Math.min(enraged.size(),3)); i > 0; i--) {
                        
                        //50-50 chance to hit or shoot
                        if(Math.random()>0.5)
                        {
                            if(Math.random()>0.5){
                                if (!player.dodge()){
                                    //hit if player didn't dodge
                                    enraged.get(i).hit(player);
                                    System.out.println("You have " + player.getHP() + " health remaining.");
                                }
                                else System.out.println(i.getName() + " missed!");
                            }
                            else{
                                if (!player.dodge()){
                                    //shoot if player didn't dodge
                                    enraged.get(i).shoot(player);
                                    System.out.println("You have " + player.getHP() + " health remaining.");
                                }
                                else System.out.println(i.getName() + " missed!");
                            }
                        }

                        //3 or fewer random monsters pursue
                        enraged.get((int) ((double) Math.random()*enraged.size())).pursue(player);
                    }
                }
        }
        else {
            //end game and say that player died
            gameOver = true;
            System.out.println("You died!");
        }
    }
}
