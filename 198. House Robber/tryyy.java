import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class tryyy{
///////////////////Mine///////////////////////
    public int rob(int[] nums) {
        for(int i=1; i<nums.length; i++){
            if(i == 1) {
                nums[i] = Math.max(nums[0],nums[1]);
            }
            else{
                nums[i] = Math.max(nums[i-2]+nums[i], nums[i-1]);
            }
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
      tryyy tr = new tryyy();
      int[] nums = {2,7,1,3,13};
      int ans = tr.rob(nums);
      System.out.println(ans);
    }
}