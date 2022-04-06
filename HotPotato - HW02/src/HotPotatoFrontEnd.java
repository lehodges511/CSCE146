//Lauren Hodges
import java.util.Random;
import java.util.Scanner;
public class HotPotatoFrontEnd {
    public static Scanner keyboard = new Scanner(System.in);
    public static int holdTime;
    public static void main(String [] args){
        System.out.println("Welcome to the hot potato game!");
        boolean replay = true;
        while(replay) { //while player wants to play
            HotPotato<String> sLL = new HotPotato<String>();
            System.out.println("Enter the number of players. (2 or more required)");
            int playerNum = keyboard.nextInt(); //number of players
            if(playerNum<2){
                System.out.println("Learn how to read directions, then come back."); //ooh the sass
                break;
            }
            keyboard.nextLine();
            for (int i = 1; i <= playerNum; i++) {
                System.out.println("Enter player " + i + "'s name.");
                String name = keyboard.nextLine();
                sLL.add(name); //creates list of names
            }

            while(playerNum>1) { //loop takes away one each time someone loses, so the game can declare a winner
                int tSec = 0;
                sLL.resetCurrent();
                setPotato();
                while (tSec < holdTime) {
                    System.out.println(sLL.getCurrent() + ", enter a number from 1-10 corresponding to the number of seconds to hold the potato.");
                    int sec = keyboard.nextInt();
                    //System.out.println(holdTime); //for checking purposes
                    if (sec > 10) {
                        System.out.println("The number must be between 1 and 10. We will assume you meant 10.");
                        sec = 10;
                    }
                    tSec += sec;
                    if (holdTime - tSec > 0) {
                        System.out.println(sLL.getCurrent() + " is safe for now.");
                        sLL.goToNext();
                    } else if (holdTime - tSec <= 0) {
                        System.out.println("HOT POTATO!!! " + sLL.getCurrent() + " is eliminated!");
                        sLL.removeCurrent();
                        playerNum--;
                    }
                }
            }
            System.out.println(sLL.getCurrent() + " wins!\nWould you like to play again? Enter yes or no"); //affects status of repeat
            keyboard.nextLine();
            String again = keyboard.nextLine();
            if (again.equalsIgnoreCase("yes")) {
                replay = true;
            } else {
                replay = false;
            }
        }
        System.out.println("Goodbye.");

    }

    public static void setPotato(){ //creates random hold time for hot potato
        Random r = new Random();
        holdTime = r.nextInt(180)+1;
    }
}
