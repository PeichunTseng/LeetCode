import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
public class tryyy
{
    private ListNode head;
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public void createLinkedList(int[] input) {
        if(head==null)
            head=new ListNode(input[0]);
        ListNode tem=head;
        for(int i=1;i<input.length;i++){
            tem.next=new ListNode(input[i]);
            tem=tem.next;
        }
         
    }

    public List<Integer> getAll()
    {
      List<Integer> list = new ArrayList<>();
      ListNode temp = head;
      while(temp!=null)
      {
        list.add(temp.val);
        temp=temp.next;

      }

      return list;
    }


///////////////////////////自己寫/////////////////////////////
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     if(head==null)
    //         return head;

    //      List<ListNode> list = new ArrayList<>();
    //      ListNode temp= head;
    //      while(temp!=null){
    //         list.add(temp);
    //         temp=temp.next;
    //      }
    //      int index=list.size()-n;
    //      if(list.size()==1)
    //         return null;
    //      if(index==0)
    //         head=list.get(1);
    //      else if(index==list.size()-1)
    //         list.get(index-1).next=null;
    //      else
    //         list.get(index-1).next=list.get(index+1);
    //      return head;
    // }

///////////////////////////別人寫 較好/////////////////////////////
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 0; i < n+1 ; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }




    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       int[] nums = {1,2,3,4,5};
       tr.createLinkedList(nums);
       //List<Integer> list=tr.getAll();
       int n = 2;
       ListNode ans =tr.removeNthFromEnd(tr.head,n);
       List<Integer> list=tr.getAll();
       System.out.println(list);
               
    }

}


