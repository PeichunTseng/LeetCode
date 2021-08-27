import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math; 
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.PriorityQueue; 
import java.util.Random;

public class tryyy
{
////////////////////mine//////////////////////
  // public int findShortestSubArray(int[] nums){

  //   Map<Integer,Integer> map = new HashMap<>();
  //   Map<Integer,Integer> firstPositon = new HashMap<>();
  //   int time = 0;
  //   int res = nums.length;

  //   for(int i=0;i<nums.length;i++){
  //     int value = map.getOrDefault(nums[i],0);
  //     map.put(nums[i],value+1);
  //     time = Math.max(time,map.get(nums[i]));
  //   }

  //   for(int i=0;i<nums.length;i++){
  //     int temp = nums[i];
  //     if(map.get(temp)==time && !firstPositon.containsKey(temp)){
  //         firstPositon.put(temp,i);
  //     }  
  //     if(firstPositon.containsKey(temp)){
  //         int v = map.get(temp);
  //         map.put(temp,v-1);
  //         if(map.get(temp) == 0) res = Math.min(res,i-firstPositon.get(temp)+1);
  //     }
  //   }
  //   return res;
  // }

////////////////////mine improve//////////////////////
  public int findShortestSubArray(int[] nums){

    Map<Integer,List<Integer>> map = new HashMap<>();
    int time = 0;
    int res = nums.length;

    for(int i=0;i<nums.length;i++){
      List<Integer> list = map.getOrDefault(nums[i],new ArrayList<>());
      list.add(i);
      map.put(nums[i],list);
      time = Math.max(time,map.get(nums[i]).size());
    }

    for(int i=0;i<nums.length;i++){
      if(map.get(nums[i]).size()==time){
        List<Integer> list = map.get(nums[i]);
        int len = list.get(list.size()-1)-list.get(0)+1;
        res = Math.min(res,len);
      }
    }

    return res;
  }
          
  public static void main(String[] args) {
    tryyy tr=new tryyy();
    int[] nums={1,2,2,3,1};
    int ans = tr.findShortestSubArray(nums);
    System.out.println(ans);
  }
}