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

public class tryyy
{
    ListNode root;
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode build(int[] arr){
        ListNode temp=new ListNode(0);
        ListNode res=temp;
        for(int a:arr){
            temp.next=new ListNode(a);
            temp=temp.next;
        }
        return res.next;
    }
///////////////////////Mine/////////////////////
    public int getDecimalValue(ListNode head) {
        int res=0;
        while(head!=null){
            res=2*res+head.val;
            head=head.next;
        }
        return res;
    }



    public static void main(String[] args) {
        tryyy tr=new tryyy(); 
        int[] arr={1,0,1};
        tr.root=tr.build(arr);
        int ans = tr.getDecimalValue(tr.root);    
        System.out.println(ans);    
    }
}