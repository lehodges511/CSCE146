//Lauren Hodges
//First board will not print out O in top left corner. Oops.
import java.io.*;
import java.util.Scanner;
public class RobotSimulator{
    private char [][] board=new char[10][10];
    RobotQueue<String> q = new RobotQueue<String>();

    public void readBoardFile(String aFile){
        try{
            Scanner fileScanner = new Scanner(new File(aFile));
            String line =fileScanner.nextLine();
            int i=0;
            while(fileScanner.hasNextLine()){ //board
                Scanner b = new Scanner(fileScanner.nextLine());
                board[i]=b.nextLine().toCharArray();
                i++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        printBoard(board);
    }

    public void readCommandFile(String aFile){
        try{
            Scanner fileScanner = new Scanner(new File(aFile));
            int i=0;
            int j=0;
            int com=0;
            while(fileScanner.hasNextLine()){
                System.out.println("Command "+com);
                String line = fileScanner.nextLine();
                if(line.equalsIgnoreCase("move up")){
                    q.enqueue(line);
                    moveUp(i,j,board);
                    i=i-1;
                    printBoard(board);
                }
                if(line.equalsIgnoreCase("move down")){
                    q.enqueue(line);
                    moveDown(i,j,board);
                    i=i+1;
                    printBoard(board);
                }
                if(line.equalsIgnoreCase("move right")){
                    q.enqueue(line);
                    moveRight(i,j,board);
                    j=j+1;
                    printBoard(board);
                }
                if(line.equalsIgnoreCase("move left")){
                    q.enqueue(line);
                    moveLeft(i,j,board);
                    j=j-1;
                    printBoard(board);
                }
                com++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void moveUp(int i,int j, char a[][]){
        if(safe(i-1,j,a)) {
            a[i][j] = '_';
            a[i - 1][j] = 'O';
        }
        else
            System.exit(0);
    }
    public void moveDown(int i,int j, char a[][]){
        if(safe(i+1,j,a)) {
            a[i][j] = '_';
            a[i + 1][j] = 'O';
        }
        else
            System.exit(0);
    }
    public void moveRight(int i, int j, char a[][]){
        if(safe(i,j+1,a)) {
            a[i][j] = '_';
            a[i][j + 1] = 'O';
        }
        else
            System.exit(0);
    }
    public void moveLeft(int i,int j, char a [][]){
        if(safe(i,j-1,a)) {
            a[i][j] = '_';
            a[i][j - 1] = 'O';
        }
        else System.exit(0);
    }

    public void printBoard(char [][] a){

        for(int i=0;i<a.length;i++){
            System.out.println(board[i]);
        }
    }
    public static boolean safe(int i, int j, char a[][]){
        if(i>=0&&j>=0&&i<=9&&j<=9&&a[i][j]=='_') {
            return true;
        }
        System.out.println("Crash!\nSimulation End.\nGoodbye.");
        return false;

    }




}