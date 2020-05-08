import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math; 
import java.util.Vector;
import java.util.Collections;

public class tryyy
{
///////////////////////mine///////////////////////////
  // public int[] maxSlidingWindow(int[] nums, int k) {
  //   int M=nums.length;
  //   if(M<k || M * k == 0)
  //     return new int[0];
  //   int[] ans = new int[M-k+1];
  //   for(int i=0;i<ans.length;i++){
  //     int max=Integer.MIN_VALUE;
  //     int t=k;
  //     int index=i;
  //     while(t>0){
  //       max=Math.max(nums[index],max);
  //       index++;
  //       t--;
  //     }
  //     ans[i]=max;
  //   }
  //   return ans;
          
  // }


//////////////////////////Others better//////////////////////////////
    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums.length==0 || k==0)
            return new int[0];
        int[] res= new int[nums.length-k+1];
        // store index of nums array
        Deque<Integer> q = new LinkedList<>();
        int ind=0;
        for(int i=0;i<nums.length;i++){
            // check if out of the boundry 
            while(!q.isEmpty() && q.peek()<=i-k)
                q.poll();
            // poll out the small integer, beacuse we need the largest number in subarray
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i])
                q.pollLast();
            q.offer(i);
            
            if(i>=k-1)
                res[ind++]=nums[q.peek()];
        }
        return res;
    }
  
    public static void main(String[] args){
       tryyy tr = new tryyy();
       int[] num= {1,3,-1,-3,5,3,6,7};
       int k=3;
       for(int a:tr.maxSlidingWindow(num,k))
          System.out.println(a);
    }

}