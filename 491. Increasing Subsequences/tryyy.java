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
//////////////////Mine//////////////////
    // public List<List<Integer>> findSubsequences(int[] nums) {
        
    //     List<List<Integer>> res = new ArrayList<>();
    //     Set<Integer> set = new HashSet<>();
    //     for(int i=0;i<nums.length;i++) {
    //         if(set.contains(nums[i]))
    //                continue;
    //         set.add(nums[i]);
    //         List<Integer> list = new ArrayList<>();
    //         list.add(nums[i]);
    //         rec(res,list,nums,i);
    //     }
    //     return res;
    // }
    
    // public void rec(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
    //     if(index==nums.length && list.size()>=2)
    //         res.add(list);
    //     Set<Integer> set = new HashSet<>();
    //     for(int i=index+1;i<nums.length;i++){
    //         int temp=list.get(list.size()-1);
    //         if(set.contains(nums[i]))
    //                continue;
    //         if(nums[i]>=temp){
    //             list.add(nums[i]);
    //             if(list.size()>=2)
    //                 res.add(new ArrayList<>(list));
    //             set.add(nums[i]);
    //             rec(res,list,nums,i);
    //             list.remove(list.size()-1);
    //         }
    //     }
    // }
//////////////////Mine Improve//////////////////
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        rec(res,new ArrayList<>(),nums,0);
        return res;
    }

    public void rec(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        if(list.size()>=2)
            res.add(new ArrayList<>(list));
        Set<Integer> set = new HashSet<>();
        for(int i=index;i<nums.length;i++){
            if(set.contains(nums[i]))
                   continue;
            if(list.size()==0 || nums[i]>=list.get(list.size()-1)){
                list.add(nums[i]);
                set.add(nums[i]);
                rec(res,list,nums,i+1);
                list.remove(list.size()-1);
            }
        }
    }

 
    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[] nums={4, 6, 7, 7};
        List<List<Integer>> ans=tr.findSubsequences(nums);
        for(List<Integer> l:ans)
            System.out.println(l);
    }
}