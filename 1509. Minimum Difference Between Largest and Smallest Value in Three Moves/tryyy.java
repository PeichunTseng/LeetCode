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
////////////////////Mine///////////////////////
    public int minDifference(int[] nums) {
        if(nums.length<5) return 0;
        Arrays.sort(nums);
        int res = nums[nums.length-4] - nums[0]; // 0 and 3
        for(int i=1 ; i <= 3 ; i++){
            int right = nums[nums.length-4+i];
            int left = nums[0+i];
            res = Math.min(res,right - left);
        }
        return res;
    }

    public static void main(String[] args){
       tryyy tr = new tryyy(); 
       int[] nums = {1,5,6,14,15};   
       int ans = tr.minDifference(nums);   
       System.out.println(ans);   
    }
}