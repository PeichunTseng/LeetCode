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
        //我寫 
        // Time complexity : O(n)
        // Space complexity : O(n))
        // public int majorityElement(int[] nums) {
        //   Map<Integer,Integer> map = new HashMap<>();
        //   int major=nums.length/2;
        //   for(int a:nums){
        //       map.put(a,map.getOrDefault(a,0)+1);
        //       if(map.get(a)>major)
        //           return a;
        //   }
        //   return 0;     
        // }

       

        //較好的寫法
        //Time complexity : O(n)
        //Space complexity : O(1) 
        public int majorityElement(int[] num){
          int major=num[0], count = 1;
          for(int i=1; i<num.length;i++){
              if(count==0){
                count++;
                major=num[i];
              }
              else if(major==num[i])
                count++;
              else 
                count--;
          }
          return major;
        }
            

    public static void main(String[] args) 
    {
      tryyy tr=new tryyy();
      int[] a={2,2,1,1,1,2,2};
      int[] b={3,2,3};
      int ans=tr.majorityElement(a);
      System.out.println(ans);
      int ans1=tr.majorityElement(b);
      System.out.println(ans1);


    }



}