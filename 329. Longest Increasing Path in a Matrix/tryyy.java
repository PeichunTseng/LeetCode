import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
//import java.util.*;



public class tryyy
{
/////////////////Mine time limited //////////////////////
  // public int longestIncreasingPath(int[][] matrix){
  //   int res=0;
  //   for(int i=0;i<matrix.length;i++){
  //     for(int j=0;j<matrix[i].length;j++){
  //       res=Math.max(res,dfs(matrix,i,j,1));
  //     }
  //   }
  //   return res;
  // }

  // public int dfs(int[][] matrix, int x, int y, int count){
  //   int res=count;
  //   if(x-1>=0 && matrix[x-1][y]>matrix[x][y])
  //     res=Math.max(res,dfs(matrix,x-1,y,count+1));
  //   if(x+1<matrix.length && matrix[x+1][y]>matrix[x][y])
  //     res=Math.max(res,dfs(matrix,x+1,y,count+1));
  //   if(y-1>=0 && matrix[x][y-1]>matrix[x][y])
  //     res=Math.max(res,dfs(matrix,x,y-1,count+1));
  //   if(y+1<matrix[x].length && matrix[x][y+1]>matrix[x][y])
  //     res=Math.max(res,dfs(matrix,x,y+1,count+1));
  //   return res;
  // }
/////////////////Mine improve//////////////////////
  public final int[][] direction= {{1,0},{-1,0},{0,1},{0,-1}};
  public int longestIncreasingPath(int[][] matrix){
    int res=0;
    int row=matrix.length;
    if(row==0)
        return 0;
    int col=matrix[0].length;
    int[][] dp=new int[row][col];
    for(int i=0;i<matrix.length;i++){
      for(int j=0;j<matrix[i].length;j++){
        res=Math.max(res,dfs(matrix,i,j,dp));
      }
    }
    return res;
  }

  public int dfs(int[][] matrix, int x, int y, int[][] dp){
    if(dp[x][y]!=0)
      return dp[x][y];
    int count=1;
    for(int[] dir:direction){
      int i=x+dir[0];
      int j=y+dir[1];
      if(i<0 || i>=matrix.length || j<0 || j>=matrix[i].length || matrix[i][j]<=matrix[x][y])
        continue;
      count=Math.max(count,dfs(matrix,i,j,dp)+1);
    }
    dp[x][y]=count;
    return count;
  }


  public static void main(String[] args){
    tryyy tr=new tryyy();
    int[][] matrix={{9,9,4},{6,6,8},{2,1,1}};
    System.out.println(tr.longestIncreasingPath(matrix));   
  }
}


