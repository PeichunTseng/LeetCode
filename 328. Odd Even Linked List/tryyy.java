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

class ListNode{
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class tryyy
{
    ListNode root;
////////////////////Mine//////////////////////
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return head;
        ListNode headSec=head.next;
        ListNode temp=head;
        ListNode sec=headSec;
        while(sec!=null && sec.next!=null){
            temp.next=temp.next.next;
            sec.next=sec.next.next;
            temp=temp.next;
            sec=sec.next;
        }
        temp.next=headSec;
        return head;
    }
          
  public static void main(String[] args){
    tryyy tr=new tryyy();
    int[] nums={1,2,3,4,5};
    tr.root=new ListNode(nums[0]);
    ListNode temp=tr.root;
    for(int i=1;i<nums.length;i++){
        temp.next=new ListNode(nums[i]);
        temp=temp.next;
    }
    tr.root=tr.oddEvenList(tr.root);// 1 3 5 2 4
////////////////////Print//////////////////////    
    temp=tr.root;
    while(temp!=null){
        System.out.println(temp.val);
        temp=temp.next;
    }
  }
}