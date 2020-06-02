import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;
import java.util.Random;


public class tryyy
{
///////////////////////Mine////////////////////////
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>target)
                r=mid-1;
            else if(nums[mid]<target)
                l=mid+1;
            else
                return mid;
        }
        if(l==r && nums[l]<target)
            return l+1;
        return l;
    }
    
    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[] nums={1,3,5,6};
        int target=7;
        int ans=tr.searchInsert(nums,target);
        System.out.println(ans);
    }
}