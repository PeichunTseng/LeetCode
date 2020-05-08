import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

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

    /////////////////////////return index//////////////////////
    public int[] maxSubArray(int[] nums){
       int res=nums[0];
       int curr=nums[0];
       int start=0;
       int end=0;
       if(nums.length==1)
           return new int[] {curr,start,end};      
       for(int i=1;i<nums.length;i++){
         if(nums[i]>curr+nums[i]){
           start=i;
         }
         curr=Math.max(curr+nums[i],nums[i]);
         if(curr>res)
           end=i;
         res=Math.max(res,curr);
       }
       return new int[]{res,start,end};
    }

    ///////////////////at lease length>=k//////////////////////
    public int[] maxSubArray(int[] nums, int k){
      int res=Integer.MIN_VALUE;
      int curr=0;
      int start=0;
      int end=0;
      for(int i=0;i<nums.length;i++){
        curr+=nums[i];
        if(i>=k-1 && curr>res){
          res=curr;
          end=i;
        }
        if(i-start>=k-1){
          curr-=nums[start];
          start++;
        }
      }
      return new int[]{res,end-k+1,end};
    }

    public static void main(String[] args){
      tryyy tr=new tryyy();
      int[] a={-2,1,-3,4,-1,6,-1,10};
      // int[] ans=tr.maxSubArray(a);
      // for(int b:ans)
      //   System.out.println(b+"  ");
      int[] ans=tr.maxSubArray(a,3);
      for(int b:ans)
        System.out.println(b+"  ");
    }
}
