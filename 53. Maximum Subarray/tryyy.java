import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
//import java.util.Entry;
//import java.util.*;



public class tryyy
{
    public int maxSubArray(int[] nums){
      int res=nums[0];
      int current=nums[0];
      for(int i=1;i<nums.length;i++){
        current=Math.max(current+nums[i],nums[i]);
        res=Math.max(res,current);
      }
      return res;
    }


    public static void main(String[] args){
       tryyy tr=new tryyy();
       int[] a={-2,1,-3,4,-1,6,-1,10};//18
       int b=tr.maxSubArray(a);
       System.out.println(b);        
    }

    /////////////////////////返回index//////////////////////
        //  public int[] maxSubArray(int[] nums){
        //     int max=nums[0];
        //     int currentvalue=nums[0];
        //     int begin=0;
        //     int end=0;
        //     if(nums.length==1)
        //         return new int[] {currentvalue,begin,end};      
        //     for(int i=1;i<nums.length;i++){
        //         if(nums[i]>currentvalue+nums[i])
        //           begin=i;
        //         currentvalue=Math.max(nums[i],currentvalue+nums[i]);
        //         if(currentvalue>=max)
        //           end=i;
        //         max=Math.max(max,currentvalue);
        //     }
        //     return Arrays.copyOfRange(nums,begin,end+1);;
        // }

        // public static void main(String[] args){
        //    tryyy tr=new tryyy();
        //    int[] a={-2,1,-3,4,-1,6,-1,10};
        //    int[] ans=tr.maxSubArray(a);
        //    for(int b:ans)
        //    System.out.println(b+"  ");
        // }
}