import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class tryyy{
    
/////////////////////Mine//////////////////
    class Node{
        int key;
        int value;
        int frequency;
        int num; // for head
        Node pre;
        Node next;
        Node tail;
        public Node(){
            num = 0;
        }
        public Node(int k, int v){
            key = k;
            value = v;
            frequency = 1;
        }
    }

    int size;
    int curr;
    Map<Integer,Node> map; // key, value
    TreeMap<Integer,Node> freq;  //times,head

    public tryyy(int capacity){
        curr = 0;
        size = capacity;
        map = new HashMap<>();
        freq = new TreeMap<>();
    }

    public void put(int k, int v){
        if(map.containsKey(k)){
            Node temp = map.get(k);
            remove(temp);
            temp.value = v;
            temp.frequency = temp.frequency + 1;
            add(temp);
        }
        else if(size!=0){
            Node newNode = new Node(k,v);
            map.put(k,newNode);
            if(curr >= size){
                remove();
                curr--;
            }
            add(newNode);
            curr++;
        }
    }

    public int get(int k){
        if(!map.containsKey(k)) return -1;
        put(k,map.get(k).value);
        return map.get(k).value;
    }

    public void remove(Node node){
        Node nodePre = node.pre;
        Node nodeNext = node.next;
        nodePre.next = nodeNext;
        nodeNext.pre = nodePre;

        int f = node.frequency;
        Node head = freq.get(f);
        if(head.num==1) freq.remove(f);
        else head.num = head.num-1;
    }

    public void add(Node node){
        if(!freq.containsKey(node.frequency)){
            Node head = new Node();
            Node last = new Node();
            head.next = last;
            head.tail = last;
            last.pre = head;
            freq.put(node.frequency,head);
        }
        int f = node.frequency;
        Node head = freq.get(f);
        Node last = head.tail;
        head.num = head.num+1;
        Node lastPre = last.pre;
        lastPre.next = node;
        node.pre = lastPre;
        node.next = last;
        last.pre = node;
    }


    public void remove(){
        int times = freq.firstKey();
        Node head = freq.get(times);
        if(head.num == 1) {
            map.remove(head.next.key);
            freq.remove(times);
        }
        else{
            Node first = head.next;
            Node firstNext = first.next;
            head.next = firstNext;
            firstNext.pre = head;
            first.next = null;
            first.pre = null;
            head.num = head.num-1;
            map.remove(first.key);
        }
    }

    public static void main(String[] args) {
        tryyy tr=new tryyy(2);
        tr.put(1,1);
        tr.put(2,2);
        System.out.println(tr.get(1));
        tr.put(3,3);
        System.out.println(tr.get(2));
        System.out.println(tr.get(3));
        tr.put(4,4);
        System.out.println(tr.get(1));
        System.out.println(tr.get(3));
        System.out.println(tr.get(4));    
    }
}
