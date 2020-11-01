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
///////////////////////Mine /////////////////////////
    // public int firstMissingPositive(int[] nums) {
    //     int len=nums.length;
    //     boolean[] rec=new boolean[len+1];
    //     for(int i=0;i<len;i++){
    //         if(nums[i]>=1 && nums[i]<=len)
    //             rec[nums[i]]=true;
    //     }
    //     for(int i=1;i<rec.length;i++){
    //         if(!rec[i])
    //             return i;
    //     }
    //     return len+1;
    // }


///////////////////////Others better(No Space)/////////////////////////
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Base case.
        int contains = 0;
        for (int i = 0; i < n; i++)
          if (nums[i] == 1) {
            contains++;
            break;
          }

        if (contains == 0)
          return 1;

        // nums = [1]
        if (n == 1)
          return 2;

        // Replace negative numbers, zeros,
        // and numbers larger than n by 1s.
        // After this convertion nums will contain 
        // only positive numbers.
        for (int i = 0; i < n; i++)
          if ((nums[i] <= 0) || (nums[i] > n))
            nums[i] = 1;

        // Use index as a hash key and number sign as a presence detector.
        // For example, if nums[1] is negative that means that number `1`
        // is present in the array. 
        // If nums[2] is positive - number 2 is missing.
        for (int i = 0; i < n; i++) {
          int a = Math.abs(nums[i]);
          // If you meet number a in the array - change the sign of a-th element.
          // Be careful with duplicates : do it only once.
          if (a == n)
            nums[0] = - Math.abs(nums[0]);
          else
            nums[a] = - Math.abs(nums[a]);//abs -> negative
        }

        // Now the index of the first positive number 
        // is equal to first missing positive.
        for (int i = 1; i < n; i++) {
          if (nums[i] > 0)
            return i;
        }

        if (nums[0] > 0)
          return n;

        return n + 1;
    }



    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] nums={3,4,-1,1};
        int ans=tr.firstMissingPositive(nums);
        System.out.println(ans);        
    }
}