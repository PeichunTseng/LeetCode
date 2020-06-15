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
//////////////////////////Mine////////////////////////////////
    // public boolean increasingTriplet(int[] nums) {
    //     if(nums.length<3)
    //         return false;
    //     int l=0;
    //     int min=nums[l];
    //     int[] rec=new int[nums.length];
        
    //     rec[nums.length-2]=nums[nums.length-1];
    //     int temp=nums[nums.length-1];
    //     for(int i=nums.length-3;i>=0;i--){
    //         rec[i]=Math.max(temp,nums[i+1]);
    //         temp=rec[i];
    //     }
        
    //     for(int i=1;i<nums.length-1;i++){
    //         if(nums[i]>min && nums[i]<rec[i])
    //             return true;
    //         l++;
    //         min=Math.min(min,nums[l]);
    //     }
    //     return false;
    // }

//////////////////////////Other Better////////////////////////////////
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min) min = num;
            else if(num < secondMin) secondMin = num;
            else if(num > secondMin) return true;
        }
        return false;
    }



    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[] nums={1,2,3,4,5};
       boolean ans=tr.increasingTriplet(nums);
       System.out.println(ans);           
    }
}