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
  // private int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
  // public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
  //     boolean[][] visited = new boolean[image.length][image[0].length];
  //     dfs(image,sr,sc,image[sr][sc],newColor,visited);
  //     return image;
  // }
  // public void dfs(int[][] arr, int r, int c, int curr, int newColor, boolean[][] visited){
  //     visited[r][c]=true;
  //     arr[r][c]=newColor;
  //     for(int[] dir:direction){
  //         int x=r+dir[0];
  //         int y=c+dir[1];
  //         if(x<0 || x>=arr.length || y<0 || y>=arr[r].length || arr[x][y]!=curr || visited[x][y])
  //             continue;
  //         dfs(arr,x,y,curr,newColor,visited);
  //     }
  // }

  ////////////////////Mine improve///////////////////////
  private int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      if (image[sr][sc] == newColor) return image;
      dfs(image,sr,sc,image[sr][sc],newColor);
      return image;
  }
  public void dfs(int[][] arr, int r, int c, int curr, int newColor){
      arr[r][c]=newColor;
      for(int[] dir:direction){
          int x=r+dir[0];
          int y=c+dir[1];
          if(x<0 || x>=arr.length || y<0 || y>=arr[r].length || arr[x][y]!=curr)
              continue;
          dfs(arr,x,y,curr,newColor);
      }
  }

  public static void main(String[] args){
    tryyy tr=new tryyy();
    int[][] image={{1,1,1},{1,1,0},{1,0,1}};
    int sr=1; 
    int sc=1;
    int newColor=2;
    int[][] ans=tr.floodFill(image,sr,sc,newColor);
    for(int[] arr:ans){
      for(int a:arr){
        System.out.print(a);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}


