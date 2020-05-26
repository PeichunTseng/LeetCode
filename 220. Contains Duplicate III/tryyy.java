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
/////////////////////Mine//////////////////////
    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=1;j<=k;j++){
    //             if(i+j>=nums.length)
    //                 continue;
    //             long temp=(long)nums[i]-(long)nums[i+j];
    //             if(temp>=-(long)t && temp<=(long)t)
    //                 return true;
    //         }
    //     }
    //     return false;
    // }


/////////////////////Others Better//////////////////////   
// Time complexity : O(nlog(min(n,k)))
// Space complexity : O(min(n,k))
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){

            Integer ceil=set.ceiling(nums[i]);
            if(ceil!=null && ceil<=t+nums[i]) //ceil-nums[i]<=t will beyond the border
                return true;
            Integer floor=set.floor(nums[i]);
            if(floor!=null && nums[i]<=t+floor) //nums[i]-floor<=t will beyond the border
                return true;
            set.add(nums[i]);
            if(set.size()>k)
                set.remove(nums[i-k]);
        }
        return false;
    }

 /////////////////////Others Best//////////////////////   (can not easily understand)
    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //     if (k < 1 || t < 0) 
    //         return false;
    //     Map<Long, Long> map = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
    //         long bucket = remappedNum / ((long) t + 1); // why t+1 ? because, if t not plus 1, when t == 0, num divide by 0 will cause crash.

    //         System.out.println(remappedNum); 
    //         System.out.println(bucket); 
    //         // means the key in the map duplicated, it means the must be exist two numbers 
    //         // that the different value between them are less than t
    //         if (map.containsKey(bucket) 
    //                 // if the two different numbers are located in two adjacent bucket, 
    //                 // the value still might be less than t
    //                 || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t) 
    //                     // the same reason for -1
    //                     || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
    //                         return true; 
    //         if (map.entrySet().size() >= k) { 
    //             long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
    //             map.remove(lastBucket);
    //         }
    //         map.put(bucket, remappedNum); //replace the duplicated key
    //     }
    //     return false;
    // }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       // int[] nums={1,5,9,1,5,9};
       // int k=2;// position
       // int t=3;
       int[] nums={1,2,3,1};
       int k=3;// position
       int t=0;
       boolean ans=tr.containsNearbyAlmostDuplicate(nums,k,t);
       System.out.println(ans);           
    }
}