import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.TreeMap;

public class tryyy{
//////////////////////////////Mine Time Limit Exceeded////////////////////////////////////////////
  // int res = 0;
  // int max = 0;
  // public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
  //   for(int i=0;i<startTime.length;i++){
  //     max = Math.max(max, startTime[i]);
  //   }
  //   for(int i=0;i<startTime.length;i++){
  //     int temp = help(startTime, endTime, profit, i, endTime[i], profit[i]);
  //     res = Math.max(res, temp);
  //   }
  //   return res;
  // }
  
  // public int help(int[] startTime, int[] endTime, int[] profit, int ind, int last, int sum){
  //   int total=0;
  //   if(last >max)
  //     return sum;
  //   for(int i=0;i<startTime.length;i++){
  //     if(startTime[i]<last)
  //       continue;
  //     total = Math.max(total, sum + help(startTime, endTime, profit, i, endTime[i], profit[i]));
  //   }
  //   return total;
  // }

//////////////////////////////Mine Improve, still Time Limit Exceeded////////////////////////////////////////////
  // int res = 0;
  // public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
  //   int[][] arr = new int [startTime.length][3];
  //   for(int i=0;i<startTime.length;i++){
  //     arr[i] = new int[] {startTime[i],endTime[i],profit[i]};
  //   }
  //   Arrays.sort(arr, (a,b)-> a[0]-b[0]);
  //   for(int i=0;i<startTime.length;i++){
  //     int temp = help(arr, i, arr[i][1], arr[i][2]);
  //     res = Math.max(res, temp);
  //   }
  //   return res;
  // }
  
  // public int help(int[][] arr, int ind, int last, int sum){
  //   int total=0;
  //   if(last >arr[arr.length-1][0])
  //     return sum;

  //   int next = find(arr,ind+1,arr.length-1,last);
  //   for(int i=next;i<arr.length;i++){
      
  //   }
  //   while(next<arr.length){
  //     total = Math.max(total, sum + help(arr, next, arr[i][1], arr[i][2]));
  //     next = find(arr,ind+1,arr.length-1,last);
  //   }
  //   return total;
  // }

  // public int find(int[][] arr, int left, int right, int last){
  //   while(left<right){
  //     int mid = left + (right-left)/2;
  //     if(arr[mid][0]<last)
  //       left=mid+1;

  //   }
  //   return arr.length;
  // }

//////////////////////////////Others TreeMap////////////////////////////////////////////
  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int n = startTime.length;
    int[][] jobs = new int[n][3];
    for (int i = 0; i < n; i++) {
        jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
    }
    Arrays.sort(jobs, (a, b)->a[1] - b[1]);
    TreeMap<Integer, Integer> dp = new TreeMap<>();
    dp.put(0, 0);
    for (int[] job : jobs) {
        int cur = dp.floorEntry(job[0]).getValue() + job[2];
        if (cur > dp.lastEntry().getValue())
            dp.put(job[1], cur);
    }
    return dp.lastEntry().getValue();
  }


  public static void main(String[] args){
     tryyy tr=new tryyy(); 
     int[] startTime = {1,2,3,4,6}; 
     int[] endTime = {3,5,10,6,9};
     int[] profit = {20,20,100,70,60};
     int ans = tr.jobScheduling(startTime,endTime,profit);
     System.out.println(ans);    
  }
}