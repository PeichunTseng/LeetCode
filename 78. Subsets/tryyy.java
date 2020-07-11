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
//////////////////////////Mine/////////////////////////
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        dfs(res,new ArrayList<>(),0,nums);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> list, int index, int[] nums){
        res.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            dfs(res,list,i+1,nums);
            list.remove(list.size()-1);
        }
    }
//////////////////////////Other Method/////////////////////////
    // public List<List<Integer>> subsets(int[] nums){
    //     int max = 1 << nums.length; //int max = (int)Math.pow(2,nums.length);
    //     List<List<Integer>> result = new ArrayList<>();
        
    //     for(int i=0; i<max; i++){
    //       List<Integer> temp = new ArrayList<>();
    //       int index = 0, j = i; 
    //       while(j > 0){
    //         if((j&1) == 1) // 奇數的最後一位都是1
    //           temp.add(nums[index]);

    //         index ++;
    //         j = j >> 1; //j=j/2;
    //       }
    //       result.add(temp);
    //     }
    //     return result;
    // }


    public static void main(String[] args){
       tryyy tr = new tryyy();
       int[] a={1,2,3,4};
       List<List<Integer>> result=tr.subsets(a);
       System.out.println(result);
        // int  j =3;
        // System.out.println(0&1);
        // System.out.println(0&0);
        // System.out.println(1&1);
        // System.out.println(1&0);
        // System.out.println(5&6);
    }
}


