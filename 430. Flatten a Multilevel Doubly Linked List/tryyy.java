import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.Collections;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    Node(int v){
      val=v;
    }
};

public class tryyy{
  ///////////////////Mine/////////////////
  // public Node flatten(Node head){
  //       if(head==null)
  //           return head;
  //       Node ans=head;
  //       Stack<Node> stack= new Stack<>();
  //       while(head.next!=null || head.child!=null){
  //           if(head.child!=null){
  //               if(head.next!=null){
  //                   stack.push(head.next);
  //               }
  //               head.next=head.child;
  //               head.next.prev=head;
  //               head.child=null;
  //           }
  //           head=head.next;
  //       }
        
  //       while(!stack.isEmpty()){
  //           Node node=stack.pop();
  //           head.next=node;
  //           node.prev=head;
  //           while(head.next!=null)
  //               head=head.next;
  //       }
  //       return ans;
  // }    

  ///////////////////Others Better/////////////////
  public Node flatten(Node head) {
        if(head == null) return head;
        Node res = head;
        
        while(head != null){
            if(head.child == null){
                head = head.next;
                continue;
            }
            
            Node headNext = head.next;
            head.next = head.child;
            head.child.prev = head;
            head.child = null;
            
            Node temp = head.next;
            while(temp.next != null){
                temp = temp.next;
            }
            if(headNext != null){
                headNext.prev = temp;
                temp.next = headNext;
            }
            
            head = head.next;
        }
        return res;
    }

  public static void main(String[] args) {
     tryyy tr=new tryyy();
     Node head= new Node(1);
     head.next= new Node(2);
     head.child= new Node(3);
     Node ans=tr.flatten(head);
     while(ans!=null){
        System.out.println(ans.val); 
        ans = ans.next;
     }
  }
}