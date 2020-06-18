import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
    
//////////////////////////Mine////////////////////////////////
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1}}; 
    public void solve(char[][] board) {
        int row=board.length;
        int col=row==0?0:board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if((i==0 || i==row-1 || j==0 || j==col-1) && board[i][j]=='O')
                    dfs(board,i,j);
            }
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='0')
                    board[i][j]='O';
                else
                    board[i][j]='X';
            }
        }
    }
    
    public void dfs(char[][] arr, int i, int j){
        arr[i][j]='0';
        for(int[] dir:directions){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && x<arr.length && y>=0 && y<arr[0].length && arr[x][y]=='O')
                dfs(arr,x,y);
        }
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       char[][] board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
       tr.solve(board);
       for(char[] arr:board){
            for(char ch:arr)
                System.out.print(ch+" "); 
            System.out.println();
       }           
    }
}