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
/////////////////////////Mine/////////////////////// 
    // public boolean canPartition(int[] nums) {
    //     int total=0;
    //     for(int a:nums)
    //         total+=a;
    //     if(total%2!=0)
    //         return false;
    //     int target=total/2;
        
    //     for(int i=0;i<nums.length;i++){
    //         if(helper(i,nums,nums[i],target))
    //             return true;
    //     }

    //     return false;
    // }
    
    // public boolean helper(int index, int[] arr, int sum,int t){
    //     if(sum==t)
    //         return true;
    //     if(sum>t)
    //         return false;
    //     for(int i=index+1;i<arr.length;i++){
    //         if(helper(i,arr, sum+arr[i],t))
    //             return true;
    //         while(i<arr.length-1 && arr[i]==arr[index])
    //             i++;
    //     }
    //     return false;
    // }
/////////////////////////Others DP/////////////////////// 
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum%2==1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        // for (int i = 0; i < dp.length; i++) {
        //     Arrays.fill(dp[i], false);
        // }
        
        dp[0][0] = true;
        
        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        // for (int j = 1; j < sum+1; j++) {
        //     dp[0][j] = false;
        // }
        
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[i].length;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
       
        return dp[n][sum];
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        //int[] nums={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100};
        //System.out.println(nums.length);         
        int[] nums={1,5,11,5}; //5 5 6 7 11 13 23
        boolean ans=tr.canPartition(nums);
        System.out.println(ans);         
    }
}