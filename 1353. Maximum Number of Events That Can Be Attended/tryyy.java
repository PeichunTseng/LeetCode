import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
// /////////////////////Mine Time Limit////////////////////////
    // public int maxEvents(int[][] events) {
    //     int res=0;
    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]==0 ? a[0]-b[0] : a[1]-b[1]);
    //     for(int[] arr:events){
    //         pq.offer(arr);
    //     }
    //     Map<Integer,Boolean> map = new HashMap<>();
    //     while(!pq.isEmpty()){
    //         int[] temp=pq.poll();
    //         int start=temp[0];
    //         int end=temp[1];
    //         for(int i=start;i<=end;i++){
    //             if(!map.containsKey(i)){
    //                 map.put(i,true);
    //                 res++;
    //                 break;
    //             }
    //         }
    //         if(res==events.length)
    //             break;
    //     }
    //     return res;
        
    // }

/////////////////////Others Better////////////////////////
    public int maxEvents(int[][] events){
        int res=0;
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        for(int d=1;d<=100000;d++){
            while(!pq.isEmpty() && pq.peek()<d)
                pq.poll();
            while(i<events.length && events[i][0]==d){
                pq.offer(events[i][1]);
                i++;
            }
            if(!pq.isEmpty()){
                pq.poll();
                res++;
            }
            if(res==events.length)
                break;
        }
        return res;
    }

    
    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[][] events={{1,2},{1,2},{3,3},{1,5},{1,5}};//5
        //int[][] events={{1,3},{1,3},{1,3},{3,4}};//4
        int ans=tr.maxEvents(events);
        System.out.println(ans);
    }
}