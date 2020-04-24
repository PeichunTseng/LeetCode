import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
//import java.util.Entry;
//import java.util.*;



public class tryyy
{
////////////Time complexity : O(mn) //////////////////////
////////////Space complexity : O(mn)//////////////////////


   // public int maximalSquare(char[][] matrix) {
   //  int rows = matrix.length;
   //  int cols = rows > 0 ? matrix[0].length : 0;
   //      int[][] dp = new int[rows + 1][cols + 1];
   //      int maxsqlen = 0;
   //      for (int i = 1; i <= rows; i++) {
   //          for (int j = 1; j <= cols; j++) {
   //              if (matrix[i-1][j-1] == '1'){
   //                  dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
   //                  //System.out.println(dp[i][j]);
   //                  maxsqlen = Math.max(maxsqlen, dp[i][j]);
   //              }
   //          }
   //      }
   //      return maxsqlen * maxsqlen;
        
   //  }


////////////Time complexity : O(mn) //////////////////////
////////////Space complexity : O(n)//////////////////////

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }



  
   

    public static void main(String[] args) 
    {
      char grid[][] ={{'1','0','1','0','0'},
                      {'1','0','1','1','1'},
                      {'1','1','1','1','1'},
                      {'1','0','0','1','0'}};
       tryyy tr=new tryyy();
       int a=tr.maximalSquare(grid);
       System.out.println(a);
    }



}


