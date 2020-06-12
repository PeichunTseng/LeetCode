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
/////////////////////////Mine/////////////////////// 
    public void sortColors(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int index=0;
        while(index<nums.length){
            if(nums[index]==2){
                swap(nums,right,index);
                right--;
            }
            else if(nums[index]==0){
                swap(nums,left,index);
                left++;
                index++;
            }
            else
                index++;
            if(index>right)
                break;
        }
        
    }
    
    public void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] nums={2,0,2,1,1,0};  
        tr.sortColors(nums);
        for(int ans:nums)
            System.out.print(ans);         
    }
}