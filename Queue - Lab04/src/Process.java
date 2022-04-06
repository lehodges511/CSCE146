//Lauren Hodges
public class Process {
    private String name;
    private double completionTime;

    public Process(){
        name = null;
        completionTime = 0;
    }
    public Process(String aName, double aComp){
        //TODO call mutators
        setName(aName);
        setCompletionTime(aComp);
    }

    public String getName(){
        return name;
    }

    public void setName(String aName){
        name = aName;
    }

    public double getCompletionTime(){
        return completionTime;
    }
    public void setCompletionTime(double aComp){ //check for valid values
        if(aComp>=0){
            completionTime = aComp;
        }
        else
            completionTime = 0.0;
    }

    public String toString(){
        return "\nProcess Name: "+getName()+"\nCompletion Time: "+getCompletionTime();
    }
}
