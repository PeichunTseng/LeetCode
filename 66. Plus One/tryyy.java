import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math; 

public class tryyy
{
  ///////////////////mine///////////////////////////////////////
  // public int[] plusOne(int[] digits) {
  //     int temp=1;
  //     int[] ans=new int[digits.length+1];
  //     for(int i=digits.length-1;i>=0;i--){
  //         digits[i]+=temp;
  //         temp=digits[i]/10;
  //         digits[i]=digits[i]%10;
  //     }
  //     if(temp==0)
  //         return digits;
  //     ans[0]=temp;
  //     for(int i=0;i<digits.length;i++)
  //         ans[i+1]=digits[i];
  //     return ans;
  // }

  ///////////////////較好解///////////////////////////
  public int[] plusOne(int[] digits) {
     for(int i = digits.length - 1; i >= 0; i--) {
        if(digits[i] != 9) {
            digits[i]++;
            return digits;
        } 
        else {
            digits[i] = 0;
        }
      }
      
      int[] result = new int[digits.length + 1];
      result[0] = 1;
      return result;
  }


  public static void main(String[] args){
     tryyy tr = new tryyy();
     // int[] a={9};
     // int[] a={1,2,3};
     int[] a={9,9};
     int[] b=tr.plusOne(a);
     for(int c:b)
        System.out.println(c);
  }
}


