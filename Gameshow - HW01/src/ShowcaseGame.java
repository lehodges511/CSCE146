//Lauren Hodges
import java.util.Scanner;

public class ShowcaseGame{
    public static void main(String [] args) {
        Scanner key = new Scanner(System.in);
        boolean repeat = true;
        double price=0;



        System.out.println("Welcome to the showcase showdown!");
        while(repeat){
            String [] rand = Showcase.getRand(); //creates random prize list
            for(int i=0;i<rand.length;i++){
                String[] pName = rand[i].split("\t",2); //separates name and price, keeps track of total price
                System.out.println(pName[0]);
                price = price+Double.parseDouble(pName[1]);
            }
            System.out.println("You must guess the total cost of all without going over.\nEnter your guess.");
            double guess = key.nextDouble();
            key.nextLine();
            System.out.println("You guessed "+guess+", the actual price is "+price+".");

            if(guess>price){
                System.out.println("Your guess was over! You lose!");
            }
            if(guess<price-2000){
                System.out.println("Your guess was too low! You lose!");
            }
            else if(guess<=price&&guess>=price-2000){
                System.out.println("Wow! Good guess! You win!");
            }
            System.out.println("Would you like to play again? Enter \"yes\" or \"no\".");
            String again = key.nextLine();
            if(again.equalsIgnoreCase("yes")){
                repeat = true;
            }
            if(again.equalsIgnoreCase("no")){
                repeat = false;
            }
        }
        System.out.println("Goodbye!");

    }
}