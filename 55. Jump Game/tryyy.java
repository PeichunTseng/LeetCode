import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class tryyy
{

/////////////////mine////////////////////////
  // public boolean canJump(int[] nums){
  //   if(nums.length==1)
  //     return true;
  //   boolean[] record= new boolean[nums.length];
  //   int lastTrue=nums.length-1;
  //   for(int i=nums.length-2;i>=0;i--){
  //     if(nums[i]>=lastTrue-i){
  //       record[i]=true;
  //       lastTrue=i;
  //     }
  //   }
  //   return record[0];
  // }

/////////////////mine  improve////////////////////////
  public boolean canJump(int[] nums){
    if(nums.length==1)
      return true;
    int lastTrue=nums.length-1;
    for(int i=nums.length-2;i>=0;i--){
      if(nums[i]>=lastTrue-i){
        lastTrue=i;
      }
    }
    return lastTrue==0;
  }


  public static void main(String[] args) 
  {
    tryyy tr=new tryyy();
    int[] nums = {2,3,1,1,4};
    boolean ans=tr.canJump(nums);
    System.out.println(ans);
  }

}