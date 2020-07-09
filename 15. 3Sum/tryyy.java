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



public class tryyy
{
/////////////////////Mine///////////////////////////////////
    // public List<List<Integer>> threeSum(int[] num) {
    //     Arrays.sort(num);
    //     List<List<Integer>> res = new ArrayList<>();

    //     for(int i=0;i<num.length-2;i++){
    //         if(i>0 && num[i]==num[i-1])
    //             continue;
    //         int sum=0-num[i];
    //         Map<Integer,Integer> map = new HashMap<>();
    //         for(int j=i+1;j<num.length;j++){
    //             if(map.containsKey(num[j])){
    //                 List<Integer> list = new ArrayList<>();
    //                 list.add(num[i]);
    //                 list.add(map.get(num[j]));
    //                 list.add(num[j]);
    //                 res.add(list);
    //                 while(j<num.length-1 && num[j]==num[j+1])
    //                     j++;
    //             }
    //             else
    //                 map.put(sum-num[j],num[j]);
    //         }
    //     }
    //     return res;
    // }


/////////////////////較快The total time complexity is O(n^2)/////////////////////////
  public List<List<Integer>> threeSum(int[] nums) 
  {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    for(int i=0;i<nums.length-2;i++)
    {
        if(i>0 && nums[i]==nums[i-1])//避免重複
            continue;
        int tar=-nums[i];
        int j=i+1;
        int k=nums.length-1;
        while(j<k)
        {
            if(nums[j]+nums[k]==tar)
            {
                list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                j++;
                k--;
                while(j<k && nums[j]==nums[j-1])//避免重複
                    j++;
                while(j<k && nums[k]==nums[k+1])//避免重複
                    k--;
            }
            else if(nums[j]+nums[k]>tar)
                k--;
            else
                j++;
        }
    }
    return list;
  }
        



    public static void main(String[] args) 
    {
       int[] nums = {-1, 0, 1, 2, -1, -4};
       tryyy tr = new tryyy();
       List<List<Integer>>  a= tr.threeSum(nums);
       System.out.println(a);

    }
    



}