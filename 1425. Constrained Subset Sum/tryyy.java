import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math; 
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.PriorityQueue; 
import java.util.Queue; 
import java.util.LinkedList; 

public class tryyy
{
  ////////////////////mine   Time Limit Exceeded/////////////////
  public int constrainedSubsetSum(int[] nums, int k){
    int[] dp = nums.clone();
    int ans=nums[0];
    for(int i=0;i<nums.length-1;i++){
        for(int j=1;j<=k;j++){
            if(i+j<nums.length){
                dp[i+j]=Math.max(dp[i+j],dp[i]+nums[i+j]);
                ans=Math.max(ans,dp[i+j]);
            }
        }
    }
    return ans;
  }

  ////////////////////others/////////////////
  public int constrainedSubsetSum(int[] nums, int k){
    Deque<Integer> q= new LinkedList<>();//store index from array nums
    int res=Integer.MIN_VALUE;
    for(int i=0;i<nums.length;i++){
      while(!q.isEmpty() && i-q.peek()>k)//remove the index wich's distance is longer than k from current position
        q.poll();
      int temp=q.isEmpty() ? 0 : nums[q.peek()];// get the largest number in queue
      nums[i]=Math.max(nums[i],temp+nums[i]);//the largest sum for current index
      res=Math.max(res,nums[i]);//Currently get the largest number
      while(!q.isEmpty() && nums[q.peekLast()]<nums[i])//poll the number that smaller the current number
        q.pollLast();
      q.offer(i);
    }
    return res;
  }

  public static void main(String[] args) {     
    tryyy tr= new tryyy();
    int[] nums={10,2,-10,5,20};
    int k=2;            
    System.out.println(tr.constrainedSubsetSum(nums,k));
  }
}


