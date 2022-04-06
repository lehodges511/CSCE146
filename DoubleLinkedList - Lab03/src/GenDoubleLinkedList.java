//Lauren Hodges
import java.util.Iterator;
public class GenDoubleLinkedList<T> implements Iterable<T> {
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
    public GenDoubleLinkedList(){
        head = curr = prev = null;
    }
    public Iterator<T> iterator(){
        return new ListIterator(head);
    }
    public void insert(T aData){
        ListNode newNode = new ListNode(aData,null);
        if(head == null){
            head = curr = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.link!=null){
            temp = temp.link;
        }
        temp.link = newNode;
    }
    public void deleteCurrent(){
        if(curr!=null&&prev==null){
            head = head.link;
            curr = head;
        }
        else if(curr!=null&&prev!=null){
            prev.link=curr.link;
            curr = curr.link;
        }
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
    public void goToNext(){
        if(curr!=null)
            prev = curr;
            curr = curr.link;
    }
    public void goToPrev(){
        curr=prev;
        prev=head;
        while(prev.link!=curr){
            prev = prev.link;
        }
    }
    public void resetCurrent(){
        curr = head;
    }
    public boolean moreToIterate(){
        return curr.link!=null;
    }
    public void insertAfterCurrent(T aData){
        ListNode newNode = new ListNode(aData,null);
        if(curr!=null){
            newNode.link=curr.link;
            curr.link=newNode;
        }
        else if(head!=null){
            System.out.println("Current is outside of linked list.");
        }
        else
            System.out.println("The list is empty");
    }

    public boolean contains(T aData){
        return findNodeWith(aData)!=null;
    }
    private ListNode findNodeWith(T aData){
        ListNode temp = head;
        while(temp!=null){
            if(temp.data.equals(aData)){
                return temp;
            }
            temp = temp.link;
        }
        return null;
    }

    public void print(){
        ListNode temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.link;
        }
    }


}
