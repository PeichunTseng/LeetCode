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
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
///////////////////////Mine/////////////////////
    // public List<Integer> findDuplicates(int[] nums) {
    //     List<Integer> res = new ArrayList<>();
    //     Set<Integer> set =new HashSet<>();
    //     for(int a:nums){
    //         if(set.contains(a))
    //             res.add(a);
    //         set.add(a);
    //     }
    //     return res;
    // }

///////////////////////Others/////////////////////
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int a:nums){
            int index=Math.abs(a)-1;
            if(nums[index]<0)
                res.add(Math.abs(a));
            nums[index]=-nums[index];
        }
        return res;
    }



    public static void main(String[] args) {
        tryyy tr=new tryyy(); 
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> ans = tr.findDuplicates(nums);    
        System.out.println(ans);    
    }
}