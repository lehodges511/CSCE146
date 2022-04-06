public class GenStack<T> implements StackInterface<T>{
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
    private int size;
    public GenStack(){
        head = tail = null;
    }
    public int count(){
        return size;
    }
    public void resetCount(){
        size = 0;
    }
    public void push(T aData){
        ListNode newNode = new ListNode(aData, head);
        head = newNode;
        size++;
    }
    public T pop(){
        if(head ==null){
            return null;
        }
        T ret = head.data;
        head = head.link;
        size--;
        return ret;
    }
    public T peek(){
        if(head == null)
            return null;
        return head.data;
    }
    public void print(){
        for(ListNode temp = head;temp!=null;temp=temp.link)
            System.out.println(temp.data);
    }

}
