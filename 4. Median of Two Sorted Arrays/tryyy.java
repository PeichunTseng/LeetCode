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

public class tryyy{
//////////////////////////////Mine////////////////////////////////////////////
  // public double findMedianSortedArrays(int[] nums1, int[] nums2) {

  //   int m = nums1.length;
  //   int n = nums2.length;
  //   if(m == 0 && n == 0)
  //       return 0.0;
  //   List<Integer> list = new ArrayList<>();
  //   for(int a : nums1)
  //       list.add(a);
  //   for(int a : nums2)
  //       list.add(a);
  //   Collections.sort(list);
  //   int num = (m+n)/2;
  //   if((m+n) % 2 == 0){
  //       return ((double)list.get(num) + (double)list.get(num-1))/2;
  //   }
  //   return (double)list.get(num);
  // }
//////////////////////////////Mine Improve////////////////////////////////////////////
  int l1 = 0;
  int l2 = 0;
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    int m = nums1.length;
    int n = nums2.length;
    if(m == 0 && n == 0)
        return 0.0;

    int num = (m+n)%2==0 ? (m+n)/2-1 : (m+n)/2;
    int current = 0;

    while(l1 + l2 <= num){
      current = help(nums1,nums2,m,n);
    }
    if((m+n) % 2 == 0){
       int next = help(nums1,nums2,m,n);
       return ((double)current + (double)next)/2;
    }
    return (double)current;
  }

  public int help(int[] nums1, int[] nums2, int m, int n){
    if(l1 >= m)
      return nums2[l2++];
    else if(l2 >= n)
      return nums1[l1++];
    else if(nums1[l1] < nums2[l2])
      return nums1[l1++];
    return nums2[l2++];
  }

  public static void main(String[] args){
     tryyy tr=new tryyy(); 
     int[] nums1 = {1,3}; 
     int[] nums2 = {2};
     double ans = tr.findMedianSortedArrays(nums1,nums2);
     System.out.println(ans);    
  }
}