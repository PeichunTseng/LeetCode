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
import java.util.Stack;

public class tryyy
{
/////////////////Others////////////////
  // public int[] countBits(int num) {
  //       int[] res = new int[num+1];
  //       for(int i=0;i<=num;i++)
  //           res[i]=helper(i);
  //       return res;
  //   }
    
  // public int helper(int num){
  //     int count=0;
  //     while(num!=0){
  //         num=num & (num-1);//zeroing out the least significant nonzero bit
  //         count++;
  //     }
  //     return count;
  // }
/////////////////Others Better////////////////  
  public int[] countBits(int num) {
      int[] f = new int[num + 1];
      for (int i=0; i<=num; i++) 
        f[i] = f[i >> 1] + (i & 1);//除以２後+除２的餘數
      return f;
  }

  public static void main(String[] args){
    tryyy tr=new tryyy(); 
    int input=6;
    int[] ans=tr.countBits(input);
    for(int a:ans)
      System.out.println(a); 
  }
}


