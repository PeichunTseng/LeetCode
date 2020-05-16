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
import java.util.Random;

public class tryyy
{
//////////////////mine//////////////////
    // private Node first;
    // private Node end;
    // class Node{
    //   int val;
    //   Node pre;
    //   Node next;
    //   Node(int a){
    //     val=a;
    //   }
    //   Node(){}
    // }

    // Set<Integer> set = new HashSet<>();
    // Map<Integer,Node> map = new HashMap<>();
    // public tryyy(int[] nums) {
    //     first=new Node();
    //     end=new Node();
    //     first.next=end;
    //     end.pre=first;
    //     for(int a:nums){
    //         add(a);
    //     }
    // }
    
    // public int showFirstUnique() {
    //   if(first.next==end)
    //     return -1;
    //   return first.next.val;
    // }
    
    // public void add(int value){
    //   //appear the same number 
    //   if(map.containsKey(value) && !set.contains(value)){
    //     Node temp=map.get(value);
    //     Node tempPre=temp.pre;
    //     Node tempNext=temp.next;
    //     tempPre.next=tempNext;
    //     tempNext.pre=tempPre;
    //     temp.pre=null;
    //     temp.next=null;
    //     set.add(value);
    //   }

    //   else if(set.contains(value))
    //     return;

    //   //first time added to LinkedList
    //   else{
    //     Node n= new Node(value);
    //     Node temp=end.pre;
    //     temp.next=n;
    //     n.pre=temp;
    //     n.next=end;
    //     end.pre=n;
    //     map.put(value,n);
    //   }
    // }
//////////////////Others better//////////////////
    Queue<Integer> pq = new LinkedList<>();
    Map<Integer,Boolean> map = new HashMap<>();
    public tryyy(int[] nums) {
        for(int a:nums)
            add(a);
    }

    public int showFirstUnique() {
      while(!pq.isEmpty()){
        if(!map.get(pq.peek()))
            pq.poll();
        else
            return pq.peek();
      }
      return -1;
    }

    public void add(int value){
        if(map.containsKey(value)){
            map.put(value,false);
        }
        else{
            pq.offer(value);
            map.put(value,true);
        }
    }

    public static void main(String[] args){
        int[] nums={2,3,5};
        tryyy tr=new tryyy(nums);
        System.out.println(tr.showFirstUnique());
        tr.add(5);
        System.out.println(tr.showFirstUnique());
        tr.add(2);
        System.out.println(tr.showFirstUnique());
        tr.add(3);
        System.out.println(tr.showFirstUnique());
    }
}