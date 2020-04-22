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

///////////////////////自己寫/////////////////////
    // public int subarraySum(int[] nums, int k) 
    // {
    //     int count=0;
    //     for(int i=0;i<nums.length;i++)
    //     {
    //         int tem=0;
    //         for(int j=i;j<nums.length;j++)
    //         {
    //             tem=tem+nums[j];
    //             if(tem==k)
    //                 count++;
    //         }
    //     }
    //     return count;
    // }

//////////////////較好/////////////////////
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            ans+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
    // map
    //(0,1)
    //(2,1)
    //(6,1)  +1 減掉之前 sum為5的次數 (因為目標是k=6)
    //(5,1)
    //(5,2)
    //(6,2)  +1
    //(11,1) +1
    //(12,1) +2

    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       int[] a= {2,4,-1,0,1,5,1};
       int ans=tr.subarraySum(a,6);
       System.out.println(ans);
             
    }

}


