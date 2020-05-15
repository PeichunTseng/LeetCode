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
import java.util.Stack;
import java.util.PriorityQueue; 
import java.util.Deque;
import java.util.LinkedList; 



public class tryyy
{
////////////////////mine time limited//////////////////////
  // public int maxSubarraySumCircular(int[] A) {
  //     int len = A.length;
  //     int res=A[0];
  //     for(int i=0;i<len;i++){
  //         int curr=A[i];
  //         for(int j=i+1;j<i+len;j++){
  //             int index=j%len;
  //             curr=Math.max(A[index],curr+A[index]);
  //             res=Math.max(res,curr);
  //         }
  //     }
  //     return res;
  // }

////////////////////Others better//////////////////////
  public int maxSubarraySumCircular(int[] A){
      Deque<Integer> q = new LinkedList<>();
      int len = A.length;
      int[] circle=new int[2*len+1];
      // Record the sum of current position in array
      for(int i=1;i<circle.length;i++){
          int index=i%len;
          circle[i]= circle[i-1]+A[index];
      }

      int res=A[0];
      q.offer(0);
      for(int i=1;i<circle.length;i++){
          // It is a circle for same number in array  //  -3  5  5  -3
          // Because we need to minus the first number in q (next step)
          if(!q.isEmpty() && q.peek()<i-len)
              q.poll();
          res=Math.max(res,circle[i]-circle[q.peek()]);

          // It need to minus the small num to produce a larger result,
          // so we need to poll the number which is bigger than current number
          while(!q.isEmpty() && circle[q.peekLast()]>=circle[i])
              q.pollLast();
          q.offer(i);
      }
      return res;
  }

          
  public static void main(String[] args) {
    tryyy tr=new tryyy();
    int[] A={5,-3,5};
    System.out.println(tr.maxSubarraySumCircular(A));
  }
}


