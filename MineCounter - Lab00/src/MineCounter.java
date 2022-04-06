//Lauren Hodges

import java.util.Random;
public class MineCounter {

    public static final int RAND_RANGE=10;
    public static void main(String[] args) {
        Random r = new Random();
        String empty="- ";
        String mine ="* ";


        //create array
        String [][] a = new String [10][10];

        System.out.println("Creating empty array...");

        //populate array
        for(int i=0;i<a.length;i++){
            for(int j=0; j<a.length;j++){
                a[i][j]=empty;
            }


        }
        printArray(a);

        System.out.println("Populating array with mines...");

        //create mines
        for(int count=0; count<10; count++){  //keeps track of how many mines are placed
            int x = r.nextInt(RAND_RANGE);
            int y = r.nextInt(RAND_RANGE);
            if(a[x][y]!=mine) {
                a[x][y] = mine;
            }
            else
                count--;
        }
        printArray(a);
        System.out.println();
        printArray(a);

        //count surrounding mines
        System.out.println("Counting mines...");


        for(int i=0;i<a.length;i++){
            for(int j=0; j<a.length;j++){
                if(a[i][j]==empty) {

                    int mineCount=0;
                    if (j<9&&a[i][j+1]==mine) {
                            mineCount++;
                        }
                    if (j>0&&a[i][j - 1] == mine) {
                           mineCount++;
                        }
                    if (i<9&&a[i+1][j] == mine) {
                            mineCount++;
                        }
                    if (i>0&&a[i-1][j] == mine) {
                            mineCount++;
                        }
                    if (j>0&&i>0&&a[i-1][j-1] == mine) {
                            mineCount++;
                        }
                    if (j<9&&i<9&&a[i+1][j+1] == mine) {
                            mineCount++;
                        }
                    if (j>0&&i<9&&a[i+1][j-1] == mine) {
                            mineCount++;
                        }
                    if (j<9&&i>0&&a[i-1][j+1] == mine) {
                            mineCount++;
                        }
                    a[i][j] = Integer.toString(mineCount) + " ";
                }

            }
        }


        printArray(a);

    }


    public static void printArray(String[][] cat){
        for(int i=0;i<cat.length;i++){
            for(int j=0; j<cat.length;j++){
                System.out.print(cat[i][j]);
            }
            System.out.println();

        }
    }

}
