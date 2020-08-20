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

/////////////////////////Mine/////////////////////////////////
    public void reorderList(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode temp=head;
        int num=0;
        while(temp!=null){
            map.put(++num,temp);
            temp=temp.next;
        }
        if(num<=2)
            return;
        int round=(num-1)/2;
        temp=head;
        for(int i=0;i<round;i++){
            ListNode nextTemp=temp.next;
            temp.next=map.get(num--);
            temp.next.next=nextTemp;
            temp=nextTemp;
        }
        map.get(num).next=null;
    }

/////////////////////////Others Better/////////////////////////////////
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        
        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){ 
            p1=p1.next;
            p2=p2.next.next;
        }
        
        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }
        
        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }



    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] nums={1, 2, 3, 4, 5};
        ListNode head=tr.buildLinkedList(tr.root,nums);
        tr.reorderList(head);
        List<Integer> ans=tr.printOut(head);
        System.out.println(ans);           
    }
}