import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;


public class tryyy
{
////////////////////Mine////////////////////////
    // List<int[]> list;
    // public tryyy(){
    //     list=new ArrayList<>();
    // }
    
    // public boolean book(int start, int end){
    //     for(int[] arr:list){
    //         if(start>=arr[0] && start<arr[1])
    //             return false;
    //         else if(end-1>=arr[0] && end-1<arr[1])
    //             return false;
    //         else if(arr[0]>=start && arr[0]<end)
    //             return false;
    //         else if(arr[1]-1>=start && arr[1]-1<end)
    //             return false;
    //     }
    //     list.add(new int[]{start,end});
    //     return true;
    // }
////////////////////Mine  Improve, but same complexity////////////////////////
    // List<int[]> list;
    // public tryyy(){
    //     list=new ArrayList<>();
    // }
    
    // public boolean book(int start, int end){
    //     for(int[] arr:list){
    //         if(start<arr[1] && end-1>=arr[0])
    //             return false;
    //     }
    //     list.add(new int[]{start,end});
    //     return true;
    // }

////////////////////Others  better////////////////////////
    TreeSet<int[]> set;
    public tryyy(){
        set=new TreeSet<>((a,b)->a[0]-b[0]);
    }
    
    public boolean book(int start, int end){
        int[] arr= new int[]{start,end};
        int[] floor=set.lower(arr);
        int[] ceil=set.higher(arr);
        if(floor!=null && start<floor[1])
            return false;
        if(ceil!=null && end-1>=ceil[0])
            return false;
        set.add(arr);
        return true;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       System.out.println(tr.book(10,20));
       System.out.println(tr.book(15,25));
       System.out.println(tr.book(20,30));          
    }
}