import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Deque;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Collections;


public class tryyy
{
//////////////////////////////Mine///////////////////////////////
    // public int longestSubarray(int[] nums, int limit) {
    //     int res=1;
    //     for(int i=0;i<nums.length;i++){
    //         if(res>=nums.length-i)
    //             break;
    //         int max=nums[i];
    //         int min=nums[i];
    //         int temp=1;
    //         for(int j=i+1;j<nums.length;j++){
    //             max=Math.max(max,nums[j]);
    //             min=Math.min(min,nums[j]);
    //             if(max-min<=limit)
    //                 temp++;
    //             else{
    //                 res=Math.max(res,temp);
    //                 break;
    //             }
    //             if(j==nums.length-1)
    //                 res=Math.max(res,temp);
    //         }
    //     }
    //     return res;
    // }

//////////////////////////////Others Better///////////////////////////////
    public int longestSubarray(int[] A, int limit) {
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int res=1;
        int start=0;
        for(int i=0;i<A.length;i++){
            while(!max.isEmpty() && A[i]>max.peekLast())
                max.pollLast();
            while(!min.isEmpty() && A[i]<min.peekLast())
                min.pollLast();
            max.offer(A[i]);
            min.offer(A[i]);
            while(max.peek()-min.peek()>limit){
                if(max.peek()==A[start])
                    max.poll();
                if(min.peek()==A[start])
                    min.poll();
                start++;
            }
            res=Math.max(res,i-start+1);
        }
        return res;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] nums={8,2,1,4,10,11};//3
        int limit=4;
        int ans = tr.longestSubarray(nums,limit);
        System.out.println(ans);      
    }
}


