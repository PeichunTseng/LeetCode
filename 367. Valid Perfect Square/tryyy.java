import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class tryyy
{
  /////////////////////Mine//////////////////////
  // public boolean isPerfectSquare(int num){
  //   if(num==1)
  //       return true;
  //   int end=num/2;
  //   for(int i=1;i<=end;i++)
  //       if(num%i==0 && num/i==i)
  //           return true;
  //   return false;
  // }


  /////////////////////Others better//////////////////////
  public boolean isPerfectSquare(int num){
    int left=1;
    int right=num;
    while(left<=right){
        int mid=left+(right-left)/2;
        int res=num/mid;
        int tail=num%mid;
        if(tail==0 && res==mid)
            return true;
        if(res<mid)
            right=mid-1;
        else
            left=mid+1;
    }
    return false;
  }


  public static void main(String[] args){
     tryyy tr=new tryyy();
     int num=16;
     boolean ans = tr.isPerfectSquare(num);
     System.out.println(ans);        
  }
}


