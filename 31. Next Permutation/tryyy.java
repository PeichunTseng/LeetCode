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
//////////////////////mine//////////////////////
    // public void nextPermutation(int[] nums) {
    //     int right=nums.length-1;
    //     int min=nums[right];
    //     int start=-1;
    //     for(int i=right-1;i>=0;i--){
    //         if(nums[i]<min){
    //             int ind=findRight(nums,i+1,nums[i]);
    //             swap(nums,i,ind);
    //             start=i;
    //             break;
    //         }
    //         min=Math.max(min,nums[i]);
    //     }
    //     int[] temp=Arrays.copyOfRange(nums,start+1,right+1);
    //     Arrays.sort(temp);
    //     int ind=0;
    //     for(int i=start+1;i<nums.length;i++){
    //         nums[i]=temp[ind++];
    //     }

    // }

    // public void swap(int[] nums, int l, int r){
    //     int temp=nums[l];
    //     nums[l]=nums[r];
    //     nums[r]=temp;
    // }

    // public int findRight(int[] nums, int start, int limit){
    //     int gap=Integer.MAX_VALUE;
    //     int right=start;
    //     for(int i=start;i<nums.length;i++){
    //         if(nums[i]>limit && nums[i]-limit<gap){
    //             gap=nums[i]-limit;
    //             right=i;
    //         }
    //     }
    //     return right;
    // }

//////////////////////mine improve//////////////////////
    public void nextPermutation(int[] nums) {
        int left=nums.length-2;
        while(left>=0 && nums[left]>=nums[left+1])
            left--;
        if(left>=0){
            int j=nums.length-1;
            while(nums[j]<=nums[left])
                j--;
            swap(nums,left,j);
        }
        reverse(nums,left+1,nums.length-1);
    }

    public void swap(int[] nums, int l, int r){
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }

    public void reverse(int[] nums, int start, int end){
        while(start<end)
            swap(nums,start++,end--);
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[] nums={1,5,8,4,7,6,5,3,1};  //158513467
       tr.nextPermutation(nums);
       for(int a:nums)
         System.out.println(a);   
    }
}


