//Lauren Hodges
//I'm not gonna lie, this made me want to cry a lot
import java.util.Scanner;
public class RobotFrontEnd {
    public static void main(String [] args){
        Scanner key = new Scanner(System.in);
        RobotSimulator r = new RobotSimulator();
        boolean again = true;
        System.out.println("Welcome to the robot simulator");
        while(again) {
            System.out.println("Enter name of board file.");
            String bFile = key.nextLine(); //board file must be formatted as 10x10 block of '_', 'X', and one 'O' in top left corner, no spaces.
            System.out.println("Enter name of command file.");
            String cFile = key.nextLine(); //command file must have each commend stated as "move" + direction (up,down,left,right), one command on each line.
            System.out.println("Simulation Begins.");
            r.readBoardFile(bFile);
            r.readCommandFile(cFile);
            System.out.println("End.");
            System.out.println("Would you like to enter different files? Enter yes or no.");
            String ans = key.nextLine();
            if (ans.equalsIgnoreCase("yes")) {
                again = true;
            } else {
                again = false;
                break;
            }
        }
        System.out.println("Goodbye.");
        System.exit(0);

    }
}
