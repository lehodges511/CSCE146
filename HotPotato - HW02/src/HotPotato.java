//Lauren Hodges
import java.util.Iterator;
public class HotPotato<T> implements Iterable<T> {
    private class ListNode{
        private T data;
        private ListNode link;
        public ListNode(T aData, ListNode aLink){
            data = aData;
            link = aLink;
        }
    }
    private class ListIterator implements Iterator<T>{
        private ListNode iCurr;
        public ListIterator(ListNode head){
            iCurr = head;
        }
        public boolean hasNext(){
            return iCurr!=null;
        }
        public T next(){
            T ret = iCurr.data;
            iCurr = iCurr.link;
            return ret;
        }
    }
    private ListNode head;
    private ListNode curr;
    private ListNode prev;
    private ListNode tail;

    public HotPotato(){
        tail = head = curr = prev = null;
    }

    public Iterator<T> iterator(){
        return new ListIterator(head);
    }

    public void add(T aData){
        ListNode newNode = new ListNode(aData,head);
        if(head==null){
            head = curr = tail = newNode;
            return;
        }
        tail.link=newNode;
        findTail();
    }
    public void goToNext(){
        if(curr!=null)
            prev = curr;
            curr = curr.link;
    }
    public T getCurrent(){
        if(curr!=null)
            return curr.data;
        return null;
    }
    public void setCurrent(T aData){
        if(curr!=null)
            curr.data=aData;
    }
    public void resetCurrent(){
        curr = head;
        prev=head;
    }

    /*public boolean hasMore(){
        return curr!=null;
    }

     */
    /*public boolean winner(){
        boolean ret;
        findTail();
        if(head!=tail){
            ret = false;
        }
        else
            ret = true;
        return ret;
    }

     */
    public void removeCurrent(){
        if(curr!=null&&prev!=null){
            prev.link = curr.link;
            curr = curr.link;
        }
        else if(curr!=null&&prev==null){
            head = head.link;
            curr = head;
        }
    }
    public void print(){
        ListNode temp = head;
        while(temp!=tail){
            System.out.println(temp.data);
            temp = temp.link;
        }
    }
    public void findTail(){
        ListNode temp = head.link;
        while(temp.link!=head){
            temp=temp.link;
        }
        tail = temp;

    }
    /*public int length(){
        int count = 0;
        ListNode position = head;
        findTail();
        while(position!=tail){
            count++;
            position=position.link;
        }
        return count;
    }

     */



}
