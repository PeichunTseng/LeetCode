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
import java.util.Queue; 
import java.util.LinkedList; 

public class tryyy
{
////////////////////////Mine//////////////////////////////////
    public class Node{
        Node pre;
        Node next;
        int val;
        String s;
        Node(int num, String S){
            val=num;
            s=S;
        };
    }

    Node head;
    Node tail;
    Map<String,Node> map;
    public tryyy() {
        map=new HashMap<>();
        head=new Node(0,"");
        tail=new Node(0,"");
        head.next=tail;
        tail.pre=head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(!map.containsKey(key)){
            Node node=new Node(1,key);
            Node temp=tail.pre;
            temp.next=node;
            node.pre=temp;
            node.next=tail;
            tail.pre=node;
            map.put(key,node);
        }
        else{
            Node node=map.get(key);
            node.val=node.val+1;
            int num=node.val;
            Node np=node.pre;
            Node nn=node.next;
            np.next=nn;
            nn.pre=np;
            while(np.val<num && np!=head){
                np=np.pre;
            }
            Node temp=np.next;
            np.next=node;
            node.pre=np;
            node.next=temp;
            temp.pre=node;
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!map.containsKey(key))
            return;
        Node node=map.get(key);
        int num=node.val;
        if(num==1){
            Node temp=node.pre;
            temp.next=node.next;
            node.next.pre=temp;
            node.pre=null;
            node.next=null;
            map.remove(key);
        }
        else{
            node.val=num-1;
            num=node.val;
            Node np=node.pre;
            Node nn=node.next;
            np.next=nn;
            nn.pre=np;
            while(nn.val>num && nn!=tail){
                nn=nn.next;
            }
            Node temp=nn.pre;
            temp.next=node;
            node.pre=temp;
            node.next=nn;
            nn.pre=node;
            
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return head.next.s;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return tail.pre.s;
    }
    


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       tr.inc("hello");
       System.out.println(tr.getMaxKey());
       System.out.println(tr.getMinKey());
    }
}