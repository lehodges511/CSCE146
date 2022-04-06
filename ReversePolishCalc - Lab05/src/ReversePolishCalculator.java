//Lauren Hodges
import java.util.Scanner;
public class ReversePolishCalculator{
    private StackInterface<Integer> valueStack;
    public ReversePolishCalculator(){
        valueStack = new GenStack<Integer>();
    }

    public int calculate(String in){
        int total = 0;
        int ret = 0;
        String [] token = in.split(" ");
        for(int i=0;i<token.length;i++){
            if(token[i].equals("*")&&valueStack.count()>=2){
                int a = valueStack.pop();
                int b = valueStack.pop();
                total = a*b;
                ret = total;
                valueStack.push(ret);
            }
            else if(token[i].equals("+")&&valueStack.count()>=2){
                int a = valueStack.pop();
                int b = valueStack.pop();
                total = a+b;
                ret = total;
                valueStack.push(ret);
            }
            else if(token[i].equals("/")&&valueStack.count()>=2){
                int a = valueStack.pop();
                int b = valueStack.pop();
                if(b==0){
                    System.out.println("You can't divide by zero.");
                }
                else
                    total = a/b;
                ret = total;
                valueStack.push(ret);
            }
            else if(token[i].equals("-")&&valueStack.count()>=2){
                int a = valueStack.pop();
                int b = valueStack.pop();
                total = b-a;
                ret = total;
                valueStack.push(ret);
            }
            else
                try{
                    int num = Integer.parseInt(token[i]);
                    valueStack.push(num);
                }
                catch(NumberFormatException e){
                    if(valueStack.count()==1){
                        System.out.println("Too many operators, not enough numbers");
                        total = 0;
                        valueStack = new GenStack<Integer>();
                    }
                    else if(valueStack.count()>=2){
                        System.out.println("invalid operator");
                        total = 0;
                        valueStack = new GenStack<Integer>();
                    }
                }
        }
        if(valueStack.count()>1){
            System.out.println("Too many numbers, not enough operators");
            total = 0;
            valueStack.resetCount();
            valueStack = new GenStack<Integer>();
        }
        valueStack.pop();
        return total;
    }
}