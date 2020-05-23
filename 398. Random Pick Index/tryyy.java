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
    // Map<Integer,Queue<Integer>> map = new HashMap<>();
    // public tryyy(int[] nums) {
    //     for(int i=0;i<nums.length;i++){
    //         map.putIfAbsent(nums[i],new LinkedList<>());
    //         map.get(nums[i]).add(i);
    //     }
    // }
    
    // public int pick(int target) {
    //     int temp=map.get(target).poll();
    //     map.get(target).add(temp);
    //     return temp;
    // }

////////////////////////////Other better////////////////////////////
    int[] nums;
    Random rand;
    public tryyy(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    public int pick(int target) {
        int total = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                // randomly select an int from 0 to the nums of target. If x equals 0, set the res as the current index. The probability is always 1/nums for the latest appeared number. For example, 1 for 1st num, 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums).
                int x = rand.nextInt(++total); 
                res = x == 0 ? i : res;
            }
        }
        return res;
    }

    public static void main(String[] args){
      int[] nums={1,2,3,3,3};
      tryyy tr=new tryyy(nums);
      int ans=tr.pick(3);
      System.out.println(ans); 
      ans=tr.pick(3);
      System.out.println(ans); 
      ans=tr.pick(3);
      System.out.println(ans);         
    }
}