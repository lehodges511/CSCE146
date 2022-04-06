//Lauren Hodges

public class LinkedListQueue<T>{
    private class ListNode{
        T data;
        ListNode link;
        public ListNode(T aData, ListNode aLink){
            data = aData;
            link = aLink;
        }
    }

    private ListNode head; //first
    private ListNode tail; //last

    public LinkedListQueue(){
        head = tail = null;
    }
    public void enqueue(T aData){ //adds to queue
        ListNode newNode = new ListNode(aData,null);
        if(head==null){
            head = newNode;
            tail = head;
            return;
        }
        tail.link=newNode;
        tail = tail.link;
    }
    public T dequeue(){ //deletes from queue
        if(head==null)
            return null;
        T ret = head.data;
        head = head.link;
        return ret;
    }
    public T peek(){ //allows you to look at data in queue
        if(head==null) {
            return null;
        }
        return head.data;
    }
    public void print(){ //queue is a fun word to type
        for(ListNode temp = head; temp!=null; temp=temp.link){
            System.out.println(temp.data);
        }
    }
}
