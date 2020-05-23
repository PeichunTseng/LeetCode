import java.util.Random;
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
////////////////////////////Mine////////////////////////////
    public int missingElement(int[] nums, int k) {
        int start=nums[0];
        for(int i=1;i<nums.length;i++){
            while(k!=0 && nums[i]!=++start)
                k--;
            if(k==0)
                break;
        }
        return start+k;
    }

////////////////////////////Others////////////////////////////
    // public int missingElement(int[] nums, int k) {
    //     int len = nums.length;
    //     int l = 0;
    //     int r = len - 1;
    //     int missingNum = nums[len - 1] - nums[0] + 1 - len;
        
    //     if (missingNum < k) {
    //         return nums[len - 1] + k - missingNum;
    //     }
        
    //     while (l < r - 1) {
    //         int m = l + (r - l) / 2;
    //         int missing = nums[m] - nums[l] - (m - l);
            
    //         if (missing >= k) {
    //             // when the number is larger than k, then the index won't be located in (m, r]
    //             r = m;
    //         } else {
    //             // when the number is smaller than k, then the index won't be located in [l, m), update k -= missing
    //             k -= missing;
    //             l = m;
    //         }
    //     }
        
    //     return nums[l] + k;
    // }

    public static void main(String[] args){
      tryyy tr=new tryyy();
      int[] nums={1,2,4};
      int k=3;
      int ans=tr.missingElement(nums,k);
      System.out.println(ans);        
    }
}