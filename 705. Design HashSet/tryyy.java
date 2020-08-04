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
///////////////////////Mine/////////////////////
    boolean[] arr;
    public tryyy() {
        arr=new boolean[1000001];
    }
    
    public void add(int key) {
        arr[key]=true;
    }
    
    public void remove(int key) {
        arr[key]=false;
    }
    
    public boolean contains(int key) {
        return arr[key];
    }

///////////////////////Others/////////////////////
    // List<Integer>[] container = null;
    // int cap = 1000;
    // double loadFactor = 0.75;
    // int count = 0; 

    // public tryyy() {
    //     container = new LinkedList[cap];
    // }
    
    // public void add(int key) {
    //     if(contains(key)) return;
    //     if(loadFactor*cap == count){
    //         count = 0;
    //         //rehash
    //         cap *= 2;
    //         List<Integer>[] oldC = container;
    //         container = new LinkedList[cap];
    //         for(int i=0; i < oldC.length; i++){
    //             List<Integer> list = oldC[i];
    //             if(list != null){
    //                 for(int entry : list)
    //                    this.add(entry); 
    //             }
    //         }
    //     }
    //     int hash = key % cap;
    //     if(container[hash] == null)
    //         container[hash] = new LinkedList<>();
    //     container[hash].add(key);
    //     ++count;
    // }
    
    // public void remove(int key) {
    //     int hash = key % cap;
    //     List<Integer> list = container[hash];
    //     if(list != null){
    //         Iterator<Integer> itr = list.iterator();
    //         while(itr.hasNext())
    //             if(itr.next() == key){
    //                 itr.remove();
    //                 --count;
    //             }
    //     }
    // }
    
    // /** Returns true if this set contains the specified element */
    // public boolean contains(int key) {
    //     int hash = key % cap;
    //     List<Integer> list = container[hash];
    //     if(list != null){
    //         Iterator<Integer> itr = list.iterator();
    //         while(itr.hasNext())
    //             if(itr.next() == key)
    //                 return true;
    //     }
    //     return false;
    // }
    


    public static void main(String[] args) {
       tryyy hashSet=new tryyy(); 
       hashSet.add(1);         
       hashSet.add(2);         
       System.out.println(hashSet.contains(1));    // returns true
       System.out.println(hashSet.contains(3));    // returns false (not found)
       hashSet.add(2);          
       System.out.println(hashSet.contains(2));    // returns true
       hashSet.remove(2);          
       System.out.println(hashSet.contains(2));    // returns false (already removed)      
    }
}