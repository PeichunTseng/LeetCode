import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class tryyy
{

///////////////////mine modify by Leetcode 1074////////////////////////
  // public int maxSumSubmatrix(int[][] matrix, int k){
  //   int row=matrix.length;
  //   int col=matrix[0].length;
  //   int ans=Integer.MIN_VALUE;
  //   int[][] rec=new int[row+1][col+1];

  //   for(int i=1;i<rec.length;i++){//先把(0,0)到每個index時的和記錄下來
  //       for(int j=1;j<rec[i].length;j++){
  //           rec[i][j]=rec[i-1][j]+rec[i][j-1]-rec[i-1][j-1]+matrix[i-1][j-1];
  //       }
  //   }

  //   Map<Integer,Integer> map = new HashMap<>();//map用來記錄走過每個column時出現過的值
  //   for(int r1=1;r1<rec.length;r1++)//r1為要計算的row 的範圍
  //       for(int r2=r1;r2<rec.length;r2++){//r2為一個row一個row往下找
  //           Set<Integer> set = new HashSet<>();
  //           for(int c=1;c<rec[r1].length;c++){//c為每一個row裡要走的column(會走遍全部的column)
  //               int curr=rec[r2][c]-rec[r1-1][c];
  //               if(curr==k)
  //                 return curr;
  //               else if(curr<k)
  //                 ans=Math.max(ans,curr); 
  //               for(int a:set){
  //                 if(curr-a==k)
  //                   return k;
  //                 else if(curr-a<k)
  //                   ans=Math.max(ans,curr-a); 
  //               }               
  //               set.add(curr);
  //           }
  //       }
  //   return ans;
  // }
///////////////////others////////////////////////
  public int maxSumSubmatrix(int[][] matrix, int k) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
          return 0;
      int rows = matrix.length, cols = matrix[0].length;
      int[][] areas = new int[rows][cols];
      for (int r = 0; r < rows; r++) {
          for (int c = 0; c < cols; c++) {
              int area = matrix[r][c];
              if (r-1 >= 0)
                  area += areas[r-1][c];
              if (c-1 >= 0)
                  area += areas[r][c-1];
              if (r-1 >= 0 && c-1 >= 0)
                  area -= areas[r-1][c-1];
              areas[r][c] = area;
          }
      }
      int max = Integer.MIN_VALUE;
      for (int r1 = 0; r1 < rows; r1++) {
          for (int c1 = 0; c1 < cols; c1++) {
              for (int r2 = r1; r2 < rows; r2++) {
                  for (int c2 = c1; c2 < cols; c2++) {
                      int area = areas[r2][c2];
                      if (r1-1 >= 0)
                          area -= areas[r1-1][c2];
                      if (c1-1 >= 0)
                          area -= areas[r2][c1-1];
                      if (r1-1 >= 0 && c1 -1 >= 0)
                          area += areas[r1-1][c1-1];
                      if (area <= k)
                          max = Math.max(max, area);
                  }
              }
          }
      }
      return max;
  }


  public static void main(String[] args) 
  {
    tryyy tr=new tryyy();
    // int[][] matrix={{1,0,1},{0,-2,3}};
    int[][] matrix={{2,2,-1}};
    int k = 0;
    int ans=tr.maxSumSubmatrix(matrix,k);
    System.out.println(ans);
  }

}