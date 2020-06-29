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
    class Node {
        public int val;
        public Node next;
        public Node() {}
        public Node(int _val){
            val = _val;
        }

        public Node(int _val, Node _next){
            val = _val;
            next = _next;
        }
    };
////////////////////Mine///////////////////////
    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node res=new Node(insertVal);
            res.next=res;
            return res;
        }
        Node pre=head;
        Node temp=head.next;
        Node minLast=pre;
        int min=temp.val;
        Node maxLast=pre;
        int max=temp.val;
        while(temp!=head){
            if(pre.val==insertVal ||(pre.val<=insertVal && temp.val>insertVal)){
                Node newOne=new Node(insertVal);
                pre.next=newOne;
                newOne.next=temp;
                return head;
            }
            pre=pre.next;
            temp=temp.next;
            if(temp.val<=min){
                minLast=pre;
                min=temp.val;
            }
            if(temp.val>=max){
                maxLast=pre;
                max=temp.val;
            }
        }
        if(insertVal<min){
            pre=minLast;
            temp=minLast.next;
        }
        else if(insertVal>max){
            pre=maxLast.next;
            temp=pre.next;
        }
        Node newOne=new Node(insertVal);
        pre.next=newOne;
        newOne.next=temp;
        return head;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
    }
}