import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math; 
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.PriorityQueue;

public class tryyy{

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  private ListNode first;

  public tryyy(){
    first=null;
  }

  public tryyy(int x){
    first=new ListNode(x);
  }

  public void addFirst(int x){
    if(first==null){
      first=new ListNode(x);
      //return;
    }
    else{
      ListNode newfirst=new ListNode(x);
      newfirst.next=first;
      first=newfirst;
 
    }
  }



  public int getFirst(){
    return first.val;
  }



  public void addLast(int x){
    if(first==null){
      first=new ListNode(x);
      return;
    }

    ListNode temp= first;
    while(temp.next != null){
      temp=temp.next;
    }

    temp.next=new ListNode(x);
  }


  public List getAll(){
    List<Integer> list = new ArrayList<>();
    ListNode temp = first;
    while(temp!=null){
      list.add(temp.val);
      temp=temp.next;

    }
    return list;
  }



    


/////////////////////Mine////////////////    
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    ListNode head = new ListNode();
    for(ListNode ln : lists){
      while(ln != null){
        pq.offer(ln.val);
        ln = ln.next;
      }
    }

    ListNode temp = head;
    while(!pq.isEmpty()){
      int value = pq.poll();
      temp.next = new ListNode(value);
      temp = temp.next;
    }

    return head.next;
  }

  public static void main(String[] args) {
    tryyy tr = new tryyy();
    tr.addLast(2);
    tr.addLast(4);
    tr.addFirst(1);

    tryyy trr = new tryyy();
    trr.addLast(1);
    trr.addLast(3);
    trr.addLast(5);
    trr.addFirst(0);

    ListNode[] lists = {tr.first, trr.first};
    tr.first = tr.mergeKLists(lists);
    List<Integer> li = tr.getAll();
    System.out.println(li);
  }
}