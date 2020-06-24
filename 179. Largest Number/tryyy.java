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
    public String largestNumber(int[] nums) {
        // Integer[] input = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Integer[] input = new Integer[nums.length];
        for(int i=0;i<nums.length;i++)
            input[i]=nums[i];
        Arrays.sort(input,(a,b)->{
            String s1=String.valueOf(a);
            String s2=String.valueOf(b);
            return (s2+s1).compareTo(s1+s2);
        });
        String res="";
        for(int a:input)
            res+=a;
        if(res.charAt(0)=='0')
            return "0";
        return res;
    }
  
    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[] nums = {10,2};
       String ans= tr.largestNumber(nums);
       System.out.println(ans);
    }
}