//lauren Hodges
import java.util.*;
public class Grader {

    public static void main(String [] args){
        Scanner key = new Scanner(System.in);
        System.out.println("Welcome to the grader program!");

        boolean more = true;
        while(more){
            Student s = new Student();
            System.out.println("Enter a file name or \"quit\" to exit.");
            String file = key.nextLine();
            if(file.equalsIgnoreCase("quit")){
                more = false;
                break;
            }
            s.readGradeFile(file);
            System.out.println(s);
        }
        System.out.println("Goodbye.");
    }
}
