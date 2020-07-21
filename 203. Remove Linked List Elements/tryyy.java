import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
};
public class tryyy
{
    ListNode root=new ListNode();
    public ListNode buildLinkedList(ListNode head, int[] arr){
        ListNode temp=head;
        for(int n:arr){
            temp.next=new ListNode(n);
            temp=temp.next;
        }
        return head.next;
    }
    public List<Integer> printOut(ListNode head){
        List<Integer> res= new ArrayList<>();
        while(head!=null){
            res.add(head.val);
            head=head.next;
        }
        return res;
    }

//////////////////////////////////////////////////////////
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp=new ListNode();
        ListNode res=temp;
        while(head!=null){
            if(head.val!=val){
                temp.next=new ListNode(head.val);
                temp=temp.next;
            }
            head=head.next;
        }
        return res.next;
    }



    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] nums={1, 2, 6, 3, 4, 5, 6};
        ListNode head=tr.buildLinkedList(tr.root,nums);
        int val=6;
        ListNode res=tr.removeElements(head,val);
        List<Integer> ans=tr.printOut(res);
        System.out.println(ans);           
    }
}