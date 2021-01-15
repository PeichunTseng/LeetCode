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
import java.util.Collections;

public class tryyy
{
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int ind=0;
        for(int i=nums.length; i>0; i--){
            if(nums[ind]>=i){
                if(ind>0 && nums[ind-1]>=i) continue;
                return i;
            }
            ind++;
        }
        return -1;
    }

    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       int[] nums = {3,5}; 

       int ans=tr.specialArray(nums);
       System.out.println(ans); 
    }
}