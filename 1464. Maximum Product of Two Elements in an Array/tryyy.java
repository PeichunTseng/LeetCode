import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
////////////////////////////Mine//////////////////////////////
    // public int maxProduct(int[] nums) {
    //     Arrays.sort(nums);
    //     return Math.max((nums[0]-1)*(nums[1]-1),(nums[nums.length-1]-1)*(nums[nums.length-2]-1));
    // }

/////////////Mine Improve////////////////
    public int maxProduct(int[] nums) {
        int first=0;
        int sec=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>first){
                sec=first;
                first=nums[i];
            }
            else if(nums[i]>sec)
                sec=nums[i];
        }
        return (first-1)*(sec-1);
    }

    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[] nums={3,4,5,2};
        int ans=tr.maxProduct(nums);
        System.out.println(ans);
    }
}