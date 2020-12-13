import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy
{
////////////////////////Mine/////////////////////////
    // public int removeDuplicates(int[] nums) {
    //     if(nums.length<=2)
    //         return nums.length;
    //     int pre=nums[0];
    //     int curr=0;
    //     int temp=1;
    //     for(int i=1;i<nums.length;i++){

    //         if(nums[i]!=pre){
    //             if(temp>2){
    //                 nums[++curr]=nums[i];
    //                 curr--;
    //             }
    //             temp=1;
    //         }
    //         else
    //             temp++;

    //         if(temp<=2){
    //             if(curr<i){
    //                 nums[++curr]=nums[i];
    //                 curr--;
    //             }
    //             curr++;
    //         }
    //         pre=nums[i];
 
    //     }
    //     return curr+1;
    // }

//////////////////Others better///////////////
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] arr={0,0,1,1,1,2,3,3};
        int ans=tr.removeDuplicates(arr);
        System.out.println(ans);      
    }
}


