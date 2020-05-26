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
/////////////////////////////Others/////////////////////////////
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int row=nums1.length;
        int col=nums2.length;
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dp[i][j]=nums1[i]*nums2[j];
                if(i>0 && j>0)
                    dp[i][j]=dp[i][j]+Math.max(dp[i-1][j-1],0);
                if(i>0)
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j]);
                if(j>0)
                    dp[i][j]=Math.max(dp[i][j-1],dp[i][j]);
            }
        }
        return dp[row-1][col-1];        
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[] nums1={5,-4,-3};
       int[] nums2={-4,-3,0,-4,2};//28

       // int[] nums1={0,5,8,5,10,-7};
       // int[] nums2={-1,5,6,-2,7,2,6,0};//168

       // int[] nums1={-1,-1};
       // int[] nums2={1,1};//-1
       int ans=tr.maxDotProduct(nums1,nums2);
       System.out.println(ans);           
    }
}