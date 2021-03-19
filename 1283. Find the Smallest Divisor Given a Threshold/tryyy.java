import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.TreeMap;

public class tryyy{
//////////////////////////////Mine Time Limit Exceeded////////////////////////////////////////////
  // public int smallestDivisor(int[] nums, int threshold) {
  //   Arrays.sort(nums);
  //   int n = nums.length;
  //   int l=1;
  //   int r=nums[n-1];
  //   if(threshold==n)
  //       return nums[n-1];
    
  //   for(int i=l;i<=r;i++){
  //       int temp=0;
  //       for(int a:nums){
  //         temp+= help(a,i);
  //         if(temp>threshold)
  //           break;
  //       }
  //       if(temp<=threshold)
  //         return i;
  //   }
  //   return 0;  
  // }
    
  // public int help(int a, int divisor){
  //   if(a%divisor == 0)
  //       return a/divisor;
  //   return a/divisor+1;
  // }

//////////////////////////////Others Binary search////////////////////////////////////////////
  public int smallestDivisor(int[] nums, int threshold) {
    Arrays.sort(nums);
    int n = nums.length;
    int l=1;
    int r=nums[n-1];
    if(threshold==n)
        return nums[n-1];
    
    while(l<r){
      int mid = l +(r-l)/2;
      int temp = 0;
      for(int a:nums){
        temp+=help(a,mid);
        if(temp>threshold){
          l = mid+1;
          break;
        }
      }
      if(temp<=threshold)
        r=mid;
    }
    return l;
  }
    
  public int help(int a, int divisor){
    if(a%divisor == 0)
        return a/divisor;
    return a/divisor+1;
  }

  public static void main(String[] args){
     tryyy tr=new tryyy(); 
     int[] nums = {1,2,5,9}; 
     int threshold = 6;
     int ans = tr.smallestDivisor(nums,threshold);
     System.out.println(ans);    
  }
}