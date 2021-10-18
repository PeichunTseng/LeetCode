import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy{
    private ListNode head;
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
////////////////////////////Mine//////////////////////////////
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = head.next;
        ListNode temp = head.next.next;
        res.next = head;
        head.next = temp;
        
        while(head.next != null && head.next.next != null){
            ListNode first = head.next;
            ListNode second = head.next.next;
            ListNode third = head.next.next.next;
            head.next = second;
            second.next = first;
            first.next = third;
            head = first;
        }
        return res;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
    }
}