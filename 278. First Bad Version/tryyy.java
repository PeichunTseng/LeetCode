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

//binary tree//


public class tryyy
{
   Map<Integer,Boolean> map = new HashMap<>();
/////////////Mine Time Limit Exceeded////////////
   // public int firstBadVersion(int n) {
   //         for(int i=1;i<=n;i++){
   //             if(isBadVersion(i))
   //                 return i;
   //         }
   //         return 0;
   //  }

   public int firstBadVersion(int n) {
       int left = 1;
       int right = n;
       while (left < right) {
           int mid = left + (right - left) / 2;
           if (isBadVersion(mid)) {
               right = mid;
           } else {
               left = mid + 1;
           }
       }
       return left;//return right also correct
   }

   public void initial(int total, int bad){
       for(int i=1;i<=total;i++){
           if(i>=bad)
               map.put(i,true);
           else
               map.put(i,false);
       }
   }
   public boolean isBadVersion(int version){
       return map.get(version); 
   }


///////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       tr.initial(5,4);
       int ans=tr.firstBadVersion(5);
       System.out.println(ans);       
    }

}


