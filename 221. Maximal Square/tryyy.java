import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class tryyy
{
////////////Time complexity : O(mn) //////////////////////
////////////Space complexity : O(mn)//////////////////////

  // public int maximalSquare(char[][] matrix){
  //   int row = matrix.length;
  //   int col = row==0 ? 0 : matrix[0].length;
  //   int[][] dp = new int[row+1][col+1];
  //   int maxLen=0;
  //   for(int i=1;i<row+1;i++){
  //     for(int j=1;j<col+1;j++){
  //       if(matrix[i-1][j-1]=='1'){
  //         dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
  //         maxLen=Math.max(maxLen,dp[i][j]);
  //       }
  //     }
  //   }
  //   return maxLen*maxLen;
  // }
  

////////////Time complexity : O(mn) //////////////////////
////////////Space complexity : O(n)//////////////////////

    public int maximalSquare(char[][] matrix){
      int row = matrix.length;
      int col = row==0 ? 0 : matrix[0].length;
      int[] dp = new int[col+1];
      int maxLen=0;
      for(int i=1;i<row+1;i++){
        int pre=0;
        for(int j=1;j<col+1;j++){
          int temp=dp[j];
          if(matrix[i-1][j-1]=='1'){
            dp[j]=Math.min(Math.min(dp[j-1],dp[j]),pre)+1;
            maxLen=Math.max(maxLen,dp[j]);
          }
          else
            dp[j]=0;
          pre=temp;
        }
      }
      return maxLen*maxLen;
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


