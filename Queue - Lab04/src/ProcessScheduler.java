//Lauren Hodges
public class ProcessScheduler {
    private LinkedListQueue<Process> processes= new LinkedListQueue<Process>(); //cuz this is a thing
    private Process current;

    public Process getCurrentProcess(){
        return current;
    }

    public void addProcess(Process aProc){ //adds to queue
        if(current==null){
            current = aProc;
        }
        else
            processes.enqueue(aProc);
    }
    public void runNextProcess(){
        current = processes.dequeue();
    }
    public void cancelCurrentProcess(){
        current = processes.peek(); //looks at data, sets current to it
        processes.dequeue(); //removes process
    }
    public void printProcessQueue(){
        processes.print();
    }

}

//I truly believe that the words "process" and "queue" are not real words after this lab.
