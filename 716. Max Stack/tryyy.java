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
///////////////////////////Mine///////////////////////////////
    class Node{
        int val;
        Node pre;
        Node next;
        public Node(int val){
            this.val=val;
        };
    }

    Map<Integer,List<Node>> map;
    PriorityQueue<Integer> pq;
    Node head;
    Node tail;
    public tryyy() {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a,b)->b-a);
        head=new Node(0);
        tail=new Node(0);
        head.next=tail;
        tail.pre=head;
    }
    
    public void push(int x) {
        Node temp= new Node(x);
        map.putIfAbsent(x,new ArrayList<>());
        map.get(x).add(temp);
        pq.offer(x);
        Node tailPre=tail.pre;
        tailPre.next=temp;
        temp.pre=tailPre;
        temp.next=tail;
        tail.pre=temp;
    }
    
    public int pop() {
        Node tailPre=tail.pre;
        Node tpp=tailPre.pre;
        tpp.next=tail;
        tail.pre=tpp;
        List<Node> list=map.get(tailPre.val);
        list.remove(list.size()-1);
        if(list.size()==0)
            map.remove(tailPre.val);
        return tailPre.val;
    }
    
    public int top() {
        Node tailPre=tail.pre;
        return tailPre.val;
    }
    
    public int peekMax() {
        int res=0;
        while(!pq.isEmpty()){
            if(map.containsKey(pq.peek())){
                res=pq.peek();
                break;
            }
            else
                pq.poll();
        }
        return res;
    }
    
    public int popMax() {
        int max=0;
        while(!pq.isEmpty()){
            if(map.containsKey(pq.peek())){
                max=pq.peek();
                break;
            }
            else
                pq.poll();
        }
        List<Node> list =map.get(max);
        Node temp=list.remove(list.size()-1);
        if(list.size()==0)
            map.remove(max);
        Node tPre=temp.pre;
        Node tNext=temp.next;
        tPre.next=tNext;
        tNext.pre=tPre;
        return max;       
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        tr.push(5); 
        tr.push(1);
        tr.push(5);
        System.out.println(tr.top());
        System.out.println(tr.popMax());
        System.out.println(tr.top());
        System.out.println(tr.peekMax());
        System.out.println(tr.pop());
        System.out.println(tr.top());
    }
}