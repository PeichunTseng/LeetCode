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
import java.util.Queue; 
import java.util.LinkedList; 

public class tryyy
{

////////////////////////Others//////////////////////////////////
    //3×(a+b+c)−(a+a+a+b+b+b+c)=2c
    public int singleNumber(int[] nums) {
        long sum=0;
        Set<Long> set = new HashSet<>();
        for(int n:nums){
            set.add((long)n);
            sum+=n;
        }
        long total=0;
        for(long a:set)
            total+=a;
        return (int)((3*total-sum)/2);
    }
  
    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[] nums={0,1,0,1,0,1,99};
       int ans =tr.singleNumber(nums);
       System.out.println(ans);
    }
}