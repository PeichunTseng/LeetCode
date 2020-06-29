import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
////////////////////Others///////////////////////
    public boolean isPossibleDivide(int[] nums, int k) {
        int len=nums.length;
        if(len%k!=0)
            return false;
        Map<Integer,Integer> map = new TreeMap<>();
        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)==0)
                continue;
            for(int i=k-1;i>=0;i--){
                if(!map.containsKey(key+i) || map.get(key+i)<map.get(key))
                    return false;
                map.put(key+i,map.get(key+i)-map.get(key));
            }
        }
        return true;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[] nums = {3,3,2,2,1,1}; 
       int k = 3; 
       boolean ans=tr.isPossibleDivide(nums,k);
       System.out.println(ans);           
    }
}