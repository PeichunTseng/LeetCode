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
    int[] arr;
    public tryyy(int[] nums) {
        arr=nums.clone();
        for(int i=1;i<arr.length;i++){
            arr[i]=arr[i-1]+nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        int temp= i-1<0 ? 0 : arr[i-1];
        return arr[j]-temp;
    }

    public static void main(String[] args){
        int[] nums={-2, 0, 3, -5, 2, -1};
        tryyy tr=new tryyy(nums); 
        System.out.println(tr.sumRange(0,2));
        System.out.println(tr.sumRange(2,5));
        System.out.println(tr.sumRange(0,5));           
    }
}