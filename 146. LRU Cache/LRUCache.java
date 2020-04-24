import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
//import java.util.Entry;
//import java.util.*;



public class LRUCache
{
  /////////////////////////others////////////////////////////////////
//   class DLinkedNode
//   {
//     int key;
//     int value;
//     DLinkedNode pre;
//     DLinkedNode next;
//   }
//   private Map<Integer, DLinkedNode> map = new HashMap<>();
//   private int cap;
//   private int nowSize;
//   private DLinkedNode head;
//   private DLinkedNode tail;


//   public LRUCache(int capacity) 
//   {
//     cap=capacity;
//     nowSize=0;
//     head = new DLinkedNode();
//     tail = new DLinkedNode();
//     head.next=tail;
//     tail.pre=head;

//   }

//   public int get(int key) 
//   {
//     DLinkedNode tem=map.get(key);
//     if(tem==null)
//       return -1;
//     else
//     {
//       remove(tem);
//       addToHead(tem);
//     }
//     return tem.value;

//   }

//   public void put(int key, int value) 
//   {
//     DLinkedNode tem = map.get(key);
//     if(tem==null)
//     {
//       nowSize++;
//       if(nowSize>cap)
//         popTail();

//       DLinkedNode newOne =new DLinkedNode();
//       newOne.key=key;
//       newOne.value=value;
//       map.put(key,newOne);
//       addToHead(newOne);
      
//     }
//     else
//     {

//       tem.value=value;
//       map.put(key,tem);
//       remove(tem);
//       addToHead(tem);
//     }
    

//   }

//   public void remove(DLinkedNode node)
//   {
    
//     DLinkedNode temPrev=node.pre;
//     DLinkedNode temNext=node.next;
//     temPrev.next=temNext;
//     temNext.pre=temPrev;
//   }

//   public void addToHead(DLinkedNode node)
//   {
//     DLinkedNode tem =head.next;
//     head.next=node;
//     node.pre=head;
//     node.next=tem;
//     tem.pre=node;
//   }

//   public void popTail()
//   {
//     DLinkedNode tem= tail.pre;
//     map.remove(tem.key);
//     tem.pre.next=tail;
//     tail.pre=tem.pre;
//   }



  /////////////////////////mine 20200425 ////////////////////////////////////
  class Node{
      int key;
      int val;
      Node pre;
      Node next;
      public Node(){}
      public Node(int k, int v){
          key=k;
          val=v;
      }
    }
      
    private Map<Integer,Node> map;
    int cap;
    int nowSize;
    Node head;
    Node tail;

    public LRUCache(int capacity) 
    {
      cap=capacity;
      nowSize=0;
      map = new HashMap<>();
      head=new Node();
      tail=new Node();
      head.next=tail;
      tail.pre=head;
    }

    public void put(int key, int value) 
    {
      Node tem=map.getOrDefault(key,new Node(key,value));
      nowSize++;
      if(map.containsKey(key)){
          tem.val=value;
          Node temNext=tem.next;
          Node temPre=tem.pre;
          temPre.next=temNext;
          temNext.pre=temPre;
          nowSize--;
      }

      Node sec=head.next;
      head.next=tem;
      tem.pre=head;
      tem.next=sec;
      sec.pre=tem;
      map.put(key,tem);
      if(nowSize>cap){
          removeTail();
          nowSize--;
      }

    }

    public int get(int key) 
    {
      if(!map.containsKey(key))
          return -1;
      Node tem=map.get(key);
      int v=tem.val;
      put(key,v);
      return v;
    }

    public void removeTail(){
      Node tem = tail.pre;
      Node temPre=tem.pre;
      //Node temNext=tem.next; //tail
      temPre.next=tail;
      tail.pre=temPre;
      tem.pre=null;
      tem.next=null;
      int k=tem.key;
      map.remove(k);
    }

  public static void main(String[] args) 
  {
     LRUCache obj=new LRUCache(2);
     obj.put(1,1);
     obj.put(2,2);
     int param_1 = obj.get(1);
     obj.put(3,3);
     int param_2 = obj.get(2);
     System.out.println(param_1);
     System.out.println(param_2);
     
  }

}


