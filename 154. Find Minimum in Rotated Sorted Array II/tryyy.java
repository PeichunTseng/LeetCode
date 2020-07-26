import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy{
///////////////////////////////Mine////////////////////////////
    // public int findMin(int[] nums) {
    //     int res=nums[0];
    //     for(int i=1;i<nums.length;i++){
    //         if(nums[i]<nums[i-1])
    //             res=nums[i];
    //     }
    //     return res;
    // }

///////////////////////////////Others Better////////////////////////////
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        if (nums[lo] < nums[hi]) 
            return nums[lo];
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } 
            else if (nums[mid] < nums[hi]) {
                hi = mid;
            } 
            else {
                hi--;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] nums={2,2,2,0,1};
        int res=tr.findMin(nums);
        System.out.println(res);           
    }
}