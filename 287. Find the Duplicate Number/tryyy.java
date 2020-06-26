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
////////////////////////Mine//////////////////////////////////
    // public int findDuplicate(int[] nums) {
    //     Arrays.sort(nums);
    //     for(int i=1;i<nums.length;i++)
    //         if(nums[i]==nums[i-1])
    //             return nums[i];
    //     return -1;
    // }

////////////////////////Others Better//////////////////////////////////
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[nums[0]];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        fast=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return fast;
    }

    // 1324
    // 3444

    // 013242
    // 424242
    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[] nums={1,3,4,2,2};
       int ans=tr.findDuplicate(nums);
       System.out.println(ans);
    }
}