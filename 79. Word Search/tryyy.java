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
  //////////////////////////////////Mine///////////////////////////////////
  int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
  public boolean exist(char[][] board, String word) {
      int row=board.length;
      int col= row==0?0:board[0].length;
      int[][] arr= new int[row][col];
      for(int i=0;i<row;i++){
          for(int j=0;j<col;j++){
              if(board[i][j]==word.charAt(0)){
                  arr[i][j]=1;
                  if(check(board,i,j,arr,word,1))
                      return true;
                  arr[i][j]=0;
              }
          }
      }
      return false;
  }
  
  public boolean check(char[][] board, int x, int y, int[][] arr, String word, int ind){
      if(ind==word.length())
          return true;
      for(int[] dir:directions){
          int temX=x+dir[0];
          int temY=y+dir[1];
          if(temX>=0 && temX<arr.length && temY>=0 && temY<arr[0].length && arr[temX][temY]==0 && board[temX][temY]==word.charAt(ind)){
              arr[temX][temY]=1;
              if(check(board, temX, temY, arr, word, ind+1))
                  return true;
              arr[temX][temY]=0;
          }
      }
      return false;
  }

  public static void main(String[] args){     
    tryyy tr= new tryyy();
    String word="ABC";
    char[][] grid={{'A','B','C','C'},
                     {'S','F','C','S'},
                     {'A','D','E','E'}};                 
    System.out.println(tr.exist(grid,word));
  }
}


