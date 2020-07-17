import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.PriorityQueue;

public class tryyy{
/////////////////////Mine///////////////////////////
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int a:nums){
           map.put(a,map.getOrDefault(a,0)+1);
        }
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int key:map.keySet())
           pq.offer(key);
        int[] res= new int[k];
        int index=0;
        while(index<k){
           res[index++]=pq.poll();
        }
        return res;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[] a={1,1,1,2,2,3,3};
        int[] b={3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        /////////Expected: [1,2,5,3,7,6,4,8,10,11]////////
        int[] ans=tr.topKFrequent(a,2);
        int[] ans1=tr.topKFrequent(b,10);

        for(int a:ans)
            Systems.out.println(a);
    }
}


