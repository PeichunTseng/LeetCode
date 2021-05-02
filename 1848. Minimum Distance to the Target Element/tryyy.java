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

public class tryyy {

  public int getMinDistance(int[] nums, int target, int start) {
    int res = Integer.MAX_VALUE;
    for(int i=0;i<nums.length;i++){
        if(nums[i]==target){
            res=Math.min(res,help(start,i));
        }
    }
    return res;
  }
  
  public int help(int a, int b){
    return Math.abs(a-b);
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5};
    int target = 5;
    int start = 3;
    tryyy tr = new tryyy();
    int ans= tr.getMinDistance(nums,target,start);
    System.out.println(ans);
  }
}