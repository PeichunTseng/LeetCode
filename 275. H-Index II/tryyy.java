import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
//////////////////////////Mine////////////////////////////////
    // public int hIndex(int[] citations) {
    //     int res=0;
    //     int len=citations.length;
    //     for(int i=0;i<len;i++){
    //         int temp=len-i;
    //         if(citations[i]>=temp)
    //             res=Math.max(res,temp);
    //     }
    //     return res;
    // }

//////////////////////////Others better////////////////////////////////
    public int hIndex(int[] citations) {
        int n = citations.length;
        int pivot, left = 0, right = n - 1;
        while (left <= right) {
          pivot = left + (right - left) / 2;
          if (citations[pivot] == n - pivot) return n - pivot;
          else if (citations[pivot] < n - pivot) left = pivot + 1;
          else right = pivot - 1;
        }
        return n - left;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[] citations={0,1,3,5,6};
       int ans=tr.hIndex(citations);
       System.out.println(ans);           
    }
}