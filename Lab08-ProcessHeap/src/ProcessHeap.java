//Lauren Hodges
public class ProcessHeap {
    private Process[] heap;
    public static final int SIZE = 127;
    private int size;
    public ProcessHeap(){
        init(SIZE);
    }
    public ProcessHeap(int aSize){
        init(aSize);
    }
    private void init(int aSize){
        if(aSize>0){
            heap = new Process[aSize];
            this.size=0;
        }
        else
            init(SIZE);
    }

    public void add(Process aProc){
        if(size>=heap.length)
            return;
        heap[size]=aProc;
        this.bubbleUp();
        size++;
    }

    private void bubbleUp(){
        int index = this.size;
        while(index>0&& heap[(index-1)/2].compareTo(heap[index])>0){
            Process temp = heap[(index-1)/2];
            heap[(index-1)/2]=heap[index];
            heap[index]=temp;
            index=(index-1)/2;
        }
    }

    public Process peek(){
        return heap[0];
    }
    public Process remove(){
        if(peek()==null)
            return null;
        Process ret = peek();
        heap[0]=heap[size-1];
        heap[size-1]=null;
        size--;
        this.bubbleDown();
        return ret;
    }

    private void bubbleDown(){
        int index=0;
        while(index*2+1<size){
            int bigIndex = index*2+1;
            if(index*2+2<size&&heap[index*2+2].compareTo(heap[index*2+1])>0)
                bigIndex=index*2+2;
            if(heap[index].compareTo(heap[bigIndex])>0){
                Process temp = heap[index];
                heap[index]=heap[bigIndex];
                heap[bigIndex]=temp;
            }
            else
                break;
            index=bigIndex;
        }
    }
    public void printHeap(){
        for(Process p : heap){
            if(p==null)
                break;
            System.out.println(p);
        }
    }
    public boolean isEmpty(){
        return heap[0]==null;
    }
}
