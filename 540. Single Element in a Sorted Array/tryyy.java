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
    public int singleNonDuplicate(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(mid%2==1)
                mid--;
            if(nums[mid]==nums[mid+1])
                left=mid+2;
            else
                right=mid;
        }
        return nums[left];
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[] nums={1,1,2,3,3,4,4,8,8};
       int ans = tr.singleNonDuplicate(nums); 
       System.out.println(ans);   
    }
}


