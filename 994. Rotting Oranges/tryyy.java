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
  // public int orangesRotting(int[][] grid) {
  //   int fresh=0, rotten=0, minutes=0;
  //   Queue <Integer> q = new LinkedList<>();
  //   for(int i=0;i<grid.length;i++){
  //     for(int j=0;j<grid[i].length;j++){
  //       if(grid[i][j]==1)
  //         fresh++;
  //       else if(grid[i][j]==2){
  //         rotten++;
  //         q.add(i);
  //         q.add(j);
  //       }
  //     }
  //   }
  //   if(fresh==0)
  //     return 0;
  //     // System.out.println(fresh);
  //     // System.out.println(rotten);

  //   while(q.size()!=0){
  //     minutes++;
  //     while(rotten>0){
  //       int x=q.poll();
  //       int y=q.poll();
  //       if(x+1<grid.length && grid[x+1][y]==1){
  //         grid[x+1][y]=2;
  //         fresh--;
  //         q.add(x+1);
  //         q.add(y);
  //       }
  //       if(x-1>=0 && grid[x-1][y]==1){
  //         grid[x-1][y]=2;
  //         fresh--;
  //         q.add(x-1);
  //         q.add(y);
  //       }
  //       if(y+1<grid[x].length && grid[x][y+1]==1){
  //         grid[x][y+1]=2;
  //         fresh--;
  //         q.add(x);
  //         q.add(y+1);
  //       }
  //       if(y-1>=0 && grid[x][y-1]==1){
  //         grid[x][y-1]=2;
  //         fresh--;
  //         q.add(x);
  //         q.add(y-1);
  //       }
  //       rotten--;

  //     }
  //     rotten=q.size()/2;
  //   }

  //   if(fresh!=0)
  //     return -1;
  //   return minutes-1;  
  // }

  //////////////////////Mine 20210501//////////////////////////////////
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = row==0 ? 0 : grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int total = 0;
        int res = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2)
                    q.offer(new int[]{i,j});
                if(grid[i][j]==1)
                    total++;
            }
        }
        
        while(!q.isEmpty() && total!=0){
            res++;
            int count = q.size();
            for(int i =0;i<count;i++){
                int[] temp = q.poll();
                for(int[] dir:directions){
                    int x = temp[0]+dir[0];
                    int y = temp[1]+dir[1];
                    if(x>=0 && x<row && y>=0 && y<col && grid[x][y]==1){
                        total--;
                        q.offer(new int[]{x,y});
                        grid[x][y]=2;
                    }
                }
            }
        }
        return total==0 ? res : -1;
    }

    public static void main(String[] args){     
      tryyy tr= new tryyy();
      int[][] grid={{2,1,1},{1,1,0},{0,1,1}};
      int[][] grid2={{2,1,1},{0,1,1},{1,0,1}};
      System.out.println(tr.orangesRotting(grid));
    }
}
