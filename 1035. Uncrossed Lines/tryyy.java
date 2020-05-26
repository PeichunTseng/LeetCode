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
/////////////////////Mine//////////////////////
    // public int maxUncrossedLines(int[] A, int[] B) {
    //     int row=A.length;
    //     int col=B.length;
    //     int[][] dp= new int[row][col];
    //     for(int j=0;j<col;j++){
    //       if(A[0]==B[j])
    //         dp[0][j]=1;
    //       else if(j>0)
    //         dp[0][j]=dp[0][j-1];
    //     }

    //     for(int i=0;i<row;i++){
    //       if(A[i]==B[0])
    //         dp[i][0]=1;
    //       else if(i>0)
    //         dp[i][0]=dp[i-1][0];
    //     }

    //     for(int i=1;i<row;i++){
    //         for(int j=1;j<col;j++){
    //             if(A[i]==B[j])
    //                 dp[i][j]=dp[i-1][j-1]+1;
    //             else
    //                 dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
    //         }
    //     }
    //     return dp[row-1][col-1];
    // }

/////////////////////Mine Improve//////////////////////
    public int maxUncrossedLines(int[] A, int[] B) {
        int row=A.length;
        int col=B.length;
        int[][] dp= new int[row+1][col+1];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(A[i]==B[j])
                    dp[i+1][j+1]=dp[i][j]+1;
                else
                    dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[row][col];
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       // int[] nums1={2,5,1,2,5};
       // int[] nums2={10,5,2,1,5,2};//3

       int[] nums1={2,1};
       int[] nums2={1,2,1,3,3,2};//2
       int ans=tr.maxUncrossedLines(nums1,nums2);
       System.out.println(ans);           
    }
}