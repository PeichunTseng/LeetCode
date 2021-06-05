import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Deque;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Collections;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;


public class tryyy
{
//////////////////////////////Mine///////////////////////////////
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
    public char[][] updateBoard(char[][] board, int[] click) {
      int x = click[0];
      int y = click[1];
      char curr = board[x][y];

      if(curr == 'M'){
        board[x][y] ='X';
      }
      else if(curr == 'E'){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
          int count = q.size();
          for(int i=0;i<count;i++){
            int[] next = q.poll();
            int total = numOfMines(next[0],next[1],board);
            if(total!=0){
              board[next[0]][next[1]]=(char)(total+'0');
            }
            else{
              help(next[0],next[1],board,q);
            }
          }
        }

      }
      return board;
    }

    public int numOfMines(int x, int y, char[][] board){
      int count = 0;
      for(int[] dir : directions){
        int nextX = x+dir[0];
        int nextY = y+dir[1];
        if( nextX<board.length && nextX>=0 && nextY<board[0].length && nextY>=0){
          if(board[nextX][nextY]=='M'){
            count++;
          }
        }
      }
      return count;
    }

    public void help(int x, int y, char[][] board, Queue<int[]> q){
      if(board[x][y]!='E') return;
      board[x][y]='B';
      for(int[] dir : directions){
        int nextX = x+dir[0];
        int nextY = y+dir[1];
        if( nextX<board.length && nextX>=0 && nextY<board[0].length && nextY>=0){
          if(board[nextX][nextY]=='E'){
            q.offer(new int[]{nextX,nextY});
          }
        }
      }
    }


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        char[][] board = {{'E','E','E','E','E'},
                          {'E','E','M','E','E'},
                          {'E','E','E','E','E'},
                          {'E','E','E','E','E'}};
        int[] click = {3,0};
        char[][] ans = tr.updateBoard(board,click);
        for(char[] arr:ans){
          for(char ch:arr){
            System.out.print(ch+" ");
          }
          System.out.println();
        }
    }
}


