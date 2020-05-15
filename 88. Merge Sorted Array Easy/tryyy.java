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
import java.util.Random;

public class tryyy
{

////////////////////Mine//////////////////////
    // public void merge(int[] nums1, int m, int[] nums2, int n){
    //     if(n==0)
    //         return;
    //     int[] temp= new int[m];
    //     for(int i=0;i<m;i++)
    //         temp[i]=nums1[i];
    //     int indexM=0;
    //     int indexN=0;
    //     int index=0;
    //     while(indexM<m || indexN<n){
    //         if(indexM==m){
    //             nums1[index++]=nums2[indexN++];
    //         }
    //         else if(indexN==n){
    //             nums1[index++]=temp[indexM++];
    //         }
    //         else if(temp[indexM]<=nums2[indexN]){
    //             nums1[index++]=temp[indexM++];
    //         }
    //         else
    //             nums1[index++]=nums2[indexN++];
    //     }
    // }

////////////////////Others better//////////////////////
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }
    }
          
  public static void main(String[] args){
    tryyy tr=new tryyy();
    int[] nums1={1,2,3,0,0,0}; 
    int m=3; 
    int[] nums2={2,5,6};
    int n=3;
    tr.merge(nums1,m,nums2,n);
    for(int ans:nums1){
      System.out.println(ans);
    }
  }
}