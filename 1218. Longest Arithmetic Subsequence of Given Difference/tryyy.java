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
    public int longestSubsequence(int[] arr, int difference) {
        int len = arr.length;
        int res = 0;
        int[] count = new int[40000];
        for (int i = 0; i < len; i++) {
            arr[i] += 20000;
        }
        count[arr[len - 1]] = 1;
        for (int i = len - 2; i >= 0; i--) {
            int tempAns = count[arr[i] + difference] + 1;
            count[arr[i]] = tempAns;
            res = Math.max(res, tempAns);
        }
        return res;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[] arr={1,2,3,4};
       int difference=1;
       int ans=tr.longestSubsequence(arr,difference);
       System.out.println(ans);           
    }
}