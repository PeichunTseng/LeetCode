import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
public class tryyy
{

///////////////////////////較好解/////////////////////////////
    public int search(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>=nums[start]){
                if(target>=nums[start] && target<nums[mid])
                    end=mid-1;
                else
                    start=mid+1;
            }
            else{
                if(target<=nums[end] && target>nums[mid])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return -1;
    }




    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       int[] nums = {4,5,6,7,0,1,2};
       int target = 0;
       int ans =tr.search(nums,target);
       System.out.println(ans);
               
    }

}


