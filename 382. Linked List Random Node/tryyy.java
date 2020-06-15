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
//////////////////////////Mine////////////////////////////////
    ListNode root;
    int size=0;
    Random r;
    public tryyy(ListNode head) {
        root=head;
        r=new Random();
        while(head!=null){
            size++;
            head=head.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int count=r.nextInt(size);
        ListNode node=root;
        while(count>0){
            node=node.next;
            count--;
        }
        return node.val;
    }

}