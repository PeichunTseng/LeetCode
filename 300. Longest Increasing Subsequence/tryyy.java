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
//////////////////////////////Mine////////////////////////////////////////////
  // public int lengthOfLIS(int[] nums) {
  //   int[] rec = new int [nums.length];
  //   int res = 1;
  //   rec[rec.length-1]=1;
  //   for(int i=rec.length-2;i>=0;i--){
  //       for(int j=i+1;j<nums.length;j++){
  //           if(nums[j]>nums[i])
  //               rec[i] = Math.max(rec[i],1+rec[j]);
  //           else
  //               rec[i] = Math.max(rec[i],1);
  //       }
  //       res = Math.max(res,rec[i]);
  //   }
  //   return res;
  // }

//////////////////////////////Mine Improve////////////////////////////////////////////
  public int lengthOfLIS(int[] nums) {
    int res = 1;
    TreeMap<Integer,Integer> map = new TreeMap<>();
    map.put(nums[nums.length-1],1);

    for(int i=nums.length-2;i>=0;i--){
      int temp = nums[i];
      int count = map.higherKey(temp)==null ? 1 : help(map,temp)+1;
      if(map.containsKey(temp)){
        count = Math.max(count,map.get(temp));
      }
      map.put(temp,count);
      res = Math.max(res,map.get(temp));
    }
    return res;
  }

  public int help (TreeMap<Integer,Integer> map, int temp){
    int res = 1;
    while(map.higherKey(temp)!=null){
      res = Math.max(map.get(map.higherKey(temp)),res);
      temp=map.higherKey(temp);
    }
    return res;
  }


  public static void main(String[] args){
     tryyy tr=new tryyy(); 
     int[] nums = {10,9,2,5,3,7,101,18}; 
     int ans = tr.lengthOfLIS(nums);
     System.out.println(ans);    
  }
}