//Lauren Hodges
public class RobotQueue<T> {
    private class ListNode{
        T data;
        ListNode link;
        public ListNode(T aData, ListNode aLink){
            data = aData;
            link = aLink;
        }
    }

    private ListNode head;
    private ListNode tail;
    public RobotQueue(){
        head = tail = null;
    }

    public void enqueue(T aData){
        ListNode newNode = new ListNode(aData,null);
        if(head==null){
            head = newNode;
            tail = head;
            return;
        }
        tail.link=newNode;
        tail = tail.link;
    }
    public T dequeue(){
        if(head==null)
            return null;
        T ret = head.data;
        head = head.link;
        return ret;
    }
    public T peek(){
        if(head ==null)
            return null;
        return head.data;
    }

    public void print(){
        for(ListNode temp = head; temp!=null;temp = temp.link){
            System.out.println(temp.data);
        }
    }
}
