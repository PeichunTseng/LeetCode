import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
/////////////////////Mine//////////////////////
    // public void wiggleSort(int[] nums) {
    //     Arrays.sort(nums);
    //     for(int i=1;i<nums.length-1;i+=2)
    //         swap(nums,i,i+1);
        
        
    // }
    // private void swap(int[] arr, int x, int y){
    //     int temp=arr[x];
    //     arr[x]=arr[y];
    //     arr[y]=temp;
    // }


/////////////////////Others Better//////////////////////   
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++)
            if (((i % 2 == 0) && nums[i] > nums[i + 1]) || ((i % 2 == 1) && nums[i] < nums[i + 1]))
                swap(nums, i, i + 1);
    }

    private void swap(int[] arr, int x, int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] nums={3,5,2,1,6,4};
        tr.wiggleSort(nums);
        for(int a:nums)
            System.out.println(a);           
    }
}