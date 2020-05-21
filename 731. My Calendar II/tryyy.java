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
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;


public class tryyy
{
////////////////////Mine Brute Force////////////////////////
    // List<int[]> firstOverlaps;
    // List<int[]> secondOverlaps;
    // public tryyy(){
    //     firstOverlaps=new ArrayList<>();
    //     secondOverlaps=new ArrayList<>();
    // }
    
    // public boolean book(int start, int end){
    //     for(int[] arr:secondOverlaps)
    //         if(end-1>=arr[0] && start<arr[1])
    //             return false;

    //     for(int[] arr:firstOverlaps){
    //         if(end-1>=arr[0] && start<arr[1]){
    //             int[] over={Math.max(arr[0],start), Math.min(arr[1],end)};
    //             secondOverlaps.add(over);
    //         }
    //     }
    //     firstOverlaps.add(new int[]{start,end});
    //     return true;
    // }

////////////////////Mine TreeSet Fail Fail Fail////////////////////////
    // TreeSet<int[]> firstOverlaps;
    // TreeSet<int[]> secondOverlaps;
    // public tryyy(){
    //     firstOverlaps=new TreeSet<>((a,b)->a[0]-b[0]);
    //     secondOverlaps=new TreeSet<>((a,b)->a[0]-b[0]);
    // }
    
    // public boolean book(int start, int end){
    //     int[] arr ={start,end};
    //     int[] floor=secondOverlaps.floor(arr);
    //     int[] ceil=secondOverlaps.ceiling(arr);
    //     if(floor!=null && floor[1]-1>=start)
    //         return false;
    //     if(ceil!=null && ceil[0]<end)
    //         return false;

    //     floor=firstOverlaps.floor(arr);
    //     ceil=firstOverlaps.ceiling(arr);
    //     boolean flag1=false;
    //     boolean flag2=false;
    //     if(floor!=null && floor[1]-1>=start){
    //         secondOverlaps.add(new int[]{start,floor[1]});
    //         //floor[1]=end;
    //         flag1=true;
    //     }
    //     if(ceil!=null && ceil[0]<end){
    //         secondOverlaps.add(new int[]{ceil[0],end});
    //         ceil[0]=start;
    //         if(flag1)
    //             ceil[0]=floor[1];
    //         flag2=true;
    //     }
    //     if(flag1 && !flag2)
    //         floor[1]=end;
    //     else if(!flag1 && flag2)
    //         ceil[0]=start;
    //     if(!flag1 && !flag2)
    //         firstOverlaps.add(new int[]{start,end});
    //     return true;
    // }


////////////////////Others  better////////////////////////
    TreeMap<Integer, Integer> map;
    public tryyy() {
        map= new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);

        int count=0;
        for(int val:map.values()){
            count+=val;
            if(count>=3){
                map.put(start,map.get(start)-1);
                map.put(end,map.get(end)+1);
                // more efficiency for these two if statement
                if(map.get(start)==0)
                    map.remove(start);
                if(map.get(end)==0)
                    map.remove(end);
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       System.out.println(tr.book(10,20));// true
       System.out.println(tr.book(50,60));// true
       System.out.println(tr.book(10,40));// true
       System.out.println(tr.book(5,15)); // false
       System.out.println(tr.book(5,10)); // true
       System.out.println(tr.book(25,55));// true        
    }
}