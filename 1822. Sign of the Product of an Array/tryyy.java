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

public class tryyy{
/////////////////////////Mine/////////////////////////////////
    public int arraySign(int[] nums) {
        int ans = 1;
        for(int a : nums){
            if(a<0) ans = -ans;
            else if(a==0) return 0;
        }
        return ans;
    }

    public static void main(String[] args){
       tryyy tr = new tryyy(); 
       int[] nums = {-1,-2,-3,-4,3,2,1};
       int ans = tr.arraySign(nums);
       System.out.println(ans);           
    }
}