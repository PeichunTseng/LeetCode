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
////////////////////////Mine//////////////////////////////////
    public int shortestDistance(int[][] grid) {
        int row=grid.length;
        int col=row==0?0:grid[0].length;
        int[][] directions={{1,0},{0,1},{-1,0},{0,-1}};
        int[][] step=new int[row][col];
        int[][] building=new int[row][col];
        int numOfBuilding=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    numOfBuilding++;
                    int level=1;
                    boolean[][] visited=new boolean[row][col];
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int size=q.size();
                        for(int k=0;k<size;k++){
                            int[] temp=q.poll();
                            for(int[] dir:directions){
                                int x=temp[0]+dir[0];
                                int y=temp[1]+dir[1];
                                if(x>=0 && x<row && y>=0 && y<col && grid[x][y]==0 && !visited[x][y]){
                                    step[x][y]+=level;
                                    building[x][y]+=1;
                                    visited[x][y]=true;
                                    q.offer(new int[]{x,y});
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }

        int res=Integer.MAX_VALUE;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(building[i][j]==numOfBuilding)
                    res=Math.min(res,step[i][j]);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
  
    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[][] grid={{1,0,2,0,1},
                     {0,0,0,0,0},
                     {0,0,1,0,0}};
       int ans=tr.shortestDistance(grid);
       System.out.println(ans);
    }
}