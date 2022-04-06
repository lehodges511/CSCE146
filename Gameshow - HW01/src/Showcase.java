import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Showcase{
    private final static int ENTIRE = 50;
    private final static int RLIST = 5;
    private final static String file = "prizeList.txt";
    public static String [] entire = new String[ENTIRE];


    public static String[] readFile(String aFile){ //creates array of each line in file
        try {
            Scanner fileScanner = new Scanner(new File(aFile));
            for(int i = 0; i<ENTIRE;i++){

                String line = fileScanner.nextLine();
                entire[i]=line;
            }
            fileScanner.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return entire;
    }


    public static String[] getRand() { //creates random array
        Random r = new Random();
        String all[] = readFile(file);
        String prizes[] = new String[RLIST];
        int [] rand = new int [5];
        for(int i=0;i<prizes.length;i++) {
            int prize = r.nextInt(50);
            rand[i]=prize;
            for(int j=0; j<rand.length;j++){
                if(rand[j]==prize){
                   prize = r.nextInt(50);
                }
            }
            try { //splits info into names and prices
                prizes[i] = all[prize];
                String[] name = prizes[i].split("\t", 2);
                double price = Double.parseDouble(name[1]);
            } catch (Exception e) { //if no tab, ignores and reassigns i to fill line
                i--;
            }
        }
        return prizes;
    }
}
