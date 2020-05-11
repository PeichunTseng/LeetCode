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
import java.util.Queue; 
import java.util.LinkedList; 

public class tryyy
{
////////////////////Mine///////////////////////
  public int[] intersection(int[] nums1, int[] nums2) {
      Set<Integer> set = new HashSet<>();
      int count=0;
      for(int a:nums1)
          set.add(a);
      for(int a:nums2){
          if(set.contains(a)){
              nums2[count++]=a;
              set.remove(a);
          }
      }
      return Arrays.copyOfRange(nums2,0,count);
  }

  public static void main(String[] args){
    tryyy tr=new tryyy();
    int n=7; 
    int[] nums1={1,2,2,1};
    int[] nums2={2,2};
    int[] ans=tr.intersection(nums1,nums2);
    for(int a:ans){
      System.out.print(a);
      System.out.print(" ");
    }
  }
}


