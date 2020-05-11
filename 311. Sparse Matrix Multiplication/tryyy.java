import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math; 
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.PriorityQueue; 
import java.util.Queue; 
import java.util.LinkedList; 

public class tryyy
{
////////////////////Mine///////////////////////
  // public int[][] multiply(int[][] A, int[][] B){
  //     int[][] res= new int[A.length][B[0].length];
  //     Map<Integer,List<Integer>> row= new HashMap<>();
  //     Map<Integer,List<Integer>> col= new HashMap<>();
  //     for(int i=0;i<A.length;i++){
  //         for(int j=0;j<A[i].length;j++){
  //             row.putIfAbsent(i,new ArrayList<>());
  //             row.get(i).add(A[i][j]);
  //         }
  //     }
  //     for(int i=0;i<B.length;i++){
  //         for(int j=0;j<B[i].length;j++){
  //             col.putIfAbsent(j,new ArrayList<>());
  //             col.get(j).add(B[i][j]);
  //         }
  //     }
  //     for(int i=0;i<res.length;i++)
  //       for(int j=0;j<res[i].length;j++){
  //           int count=0;
  //           List<Integer> a = row.get(i);
  //           List<Integer> b = col.get(j);
  //           for(int k=0;k<a.size();k++)
  //               count+=a.get(k)*b.get(k);
  //           res[i][j]=count;
  //       }
  //     return res;
  // }

////////////////////Others better///////////////////////
  public int[][] multiply(int[][] A, int[][] B) {
      int m = A.length, n = A[0].length, nB = B[0].length;
      int[][] C = new int[m][nB];
      for(int i = 0; i < m; i++) {
          for(int k = 0; k < n; k++) {
              if (A[i][k] != 0) {
                  for (int j = 0; j < nB; j++) {
                      if (B[k][j] != 0) 
                          C[i][j] += A[i][k] * B[k][j];
                  }
              }
          }
      }
      return C;   
  }

  public static void main(String[] args){
    tryyy tr=new tryyy();
    int n=7; 
    int[][] A={{1,0,0},{-1,0,3}};
    int[][] B={{7,0,0},{0,0,0},{0,0,1}};
    int[][] ans=tr.multiply(A,B);
    for(int[] arr:ans){
      for(int a:arr){
        System.out.print(a);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}


