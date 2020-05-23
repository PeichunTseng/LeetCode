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
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0)
            return 0;
        int res=1;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                count++;
                res=Math.max(count,res);
            }
            else
                count=1;
        }
        return res;
    }

    public static void main(String[] args){
      tryyy tr=new tryyy();
      int[] nums={1,3,5,4,7};
      int ans=tr.findLengthOfLCIS(nums,k);
      System.out.println(ans);        
    }
}