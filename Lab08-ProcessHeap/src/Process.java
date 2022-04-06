//Lauren Hodges
public class Process implements Comparable<Process> {
    private int priority;
    private double time;
    private String name;
    public Process(){ //default
        this.priority=0;
        this.time=0.0;
        this.name="none";
    }
    public Process(String aName, int aPriority, double aTime){//parameterized
        //call mutators
        this.setPriority(aPriority);
        this.setTime(aTime);
        this.setName(aName);
    }
    public int getPriority(){
        return this.priority;
    }
    public double getTime(){
        return this.time;
    }
    public String getName(){
        return this.name;
    }

    public void setPriority(int aPrior){
        if(aPrior>=0)
            this.priority=aPrior;
        else
            this.priority=0;
    }
    public void setTime(double aTime){
        if(aTime>=0.0)
            this.time=aTime;
        else
            this.time=0.0;
    }
    public void setName(String aName){
        if(aName==null)
            this.name="none";
        else
            this.name=aName;
    }

    public String toString(){
        return "Name: "+this.name+"   Time: "+this.time+"   Priority: "+this.priority;
    }
    public int compareTo(Process aProc){
        if(aProc==null)
            return 0;
        if(this.priority<aProc.getPriority())
            return -1;
        else if(this.priority>aProc.getPriority())
            return 1;
        else
            return 0;
    }
}
