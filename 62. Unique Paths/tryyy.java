import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class tryyy
{
////////////////Mine DP/////////////////
  // public int uniquePaths(int m, int n) {
  //     int[][] dp=new int[m][n];
  //     for(int i=0;i<m;i++){
  //         for(int j=0;j<n;j++){
  //             if(i==0 || j==0){
  //                 dp[i][j]=1;
  //                 continue;
  //             }
  //             dp[i][j]=dp[i-1][j]+dp[i][j-1];
  //         }
  //     }
  //     return dp[m-1][n-1];
  // }


  /////////////Others Better////////////////
  public int uniquePaths(int m, int n) {
      if(m==1 || n==1)
          return 1;
        int total=m+n-2;
      if(m<n){
          int tem=m;
          m=n;
          n=tem;
      }

        double ans=1;
        int tt=1;
      for(int i=total;i>=m;i--){
          ans=ans*i/tt;
          tt++;
      }
      return (int)ans;
  }


  public static void main(String[] args){
    tryyy tr=new tryyy();
    System.out.println(tr.uniquePaths(36,7));
  }
}