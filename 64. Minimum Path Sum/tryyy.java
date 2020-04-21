import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class tryyy
{
  /////////////Time: O(n^2)////////////////
  // public int minPathSum(int[][] grid) {
  //         int m=grid.length;
  //         int n=grid[0].length;
  //         int[][] dp= new int[m][n];
  //         //dp[0][0]=grid[0][0];
  //         for(int i=0;i<m;i++)
  //             for(int j=0;j<n;j++)
  //             {
  //                 if(i==0 && j==0)
  //                     dp[i][j]=grid[i][j];
  //                 else if(i==0)
  //                     dp[i][j]=dp[i][j-1]+grid[i][j];
  //                 else if(j==0)
  //                     dp[i][j]=dp[i-1][j]+grid[i][j];
  //                 else{
  //                     dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
  //                 }    
  //             }
  //         return dp[m-1][n-1];
          
  //     }





  ///////////////////space O(1)/////////////////
    // public int minPathSum(int[][] grid) {
    //     int row = grid.length;
    //     int col = grid[0].length;
    //     for(int i=1;i<col;i++)
    //         grid[0][i]=grid[0][i-1]+grid[0][i];
    //     for(int i=1;i<row;i++)
    //         grid[i][0]=grid[i-1][0]+grid[i][0];
    //     for(int i=1;i<row;i++)
    //         for(int j=1;j<col;j++){
    //             grid[i][j]=grid[i][j]+Math.min(grid[i-1][j],grid[i][j-1]);
    //         }
    //     return grid[row-1][col-1];

    // }


  /////////////Time: O(nlogn)////////////////////
  public int minPathSum(int[][] grid) {
        return recur(grid, new boolean[grid.length][grid[0].length],0,0); 
  }

  public int recur(int[][] grid, boolean[][] visited, int col, int row) {
      if (visited[col][row]) 
        return grid[col][row];

      visited[col][row] = true;
      
      int res = 9999; 
      if (row+1 <= grid[0].length-1) 
        res = Math.min(res, recur(grid,visited,col,row+1)); 

      if (col+1 <= grid.length-1) 
        res = Math.min(res, recur(grid,visited,col+1,row));

      grid[col][row] = (res == 9999) ? grid[col][row] : grid[col][row] + res;            
      return grid[col][row];
  }


   

    public static void main(String[] args) 
    {
      tryyy tr=new tryyy();
      int[][] a={{1,3,1},
                  {1,5,1},
                  {4,2,1}};
      System.out.println(tr.minPathSum(a));//答案7
      

    }



}