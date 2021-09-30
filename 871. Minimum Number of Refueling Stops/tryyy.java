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

public class tryyy{
//////////////////////////Others///////////////////////////
//////////////////////////DP O(N^2)///////////////////////////
    // public int minRefuelStops(int target, int startFuel, int[][] stations) {
    //     int[] dp = new int[stations.length+1];
    //     dp[0] = startFuel;
    //     for(int i = 0; i < stations.length; i++){
    //         for(int t = i; t >= 0; t--){
    //             if(dp[t] >= stations[i][0]){
    //                 dp[t+1] = Math.max(dp[t+1], dp[t]+stations[i][1]);
    //             }
    //         }
    //     }

    //     for(int i = 0; i < dp.length; i++){
    //         if(dp[i] >= target) return i;
    //     }
    //     return -1;
    // }
//////////////////////////Others Better///////////////////////////
//////////////////////////O(NlogN)///////////////////////////
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        int res = 0;
        int ind = 0;
        int max = startFuel;

        if( startFuel >= target) return res;
        while(max < target){
            while(ind < stations.length && max >= stations[ind][0]){
                q.offer(stations[ind][1]);
                ind++;
            }
            if(q.isEmpty()) return -1;
            max += q.poll();
            res++;
        }
        return res;

    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int target = 100; 
        int startFuel = 10;
        int[][] stations = {{10,60},
                            {20,30},
                            {30,30},
                            {60,40}};
        int ans=tr.minRefuelStops(target, startFuel, stations);
        System.out.println(ans);           
    }
}