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
////////////////////////////////////Mine////////////////////////////////////
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row=maze.length;
        int col= row==0 ? 0 : maze[0].length;
        int[][] visited=new int[row][col];
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()){
            int[] arr= q.poll();
            visited[arr[0]][arr[1]]=1;
            
            if(arr[0]==destination[0] && arr[1]==destination[1])
                return true;
            
            for(int[] d:dir){
                int x=arr[0]+d[0];
                int y=arr[1]+d[1];
                if(x>=row || x<0 || y>=col || y<0 || maze[x][y]==1 || visited[x][y]==1)
                    continue;
                else
                    dfs(maze,visited,arr,d,q);
            }
        }
        return false;
    }
    
    public void dfs(int[][] maze, int[][] visited, int[] start, int[] direction, Queue<int[]> q){
        int row=maze.length;
        int col= row==0 ? 0 : maze[0].length;
        int x=start[0];
        int y=start[1];
        
        while(x<row && x>=0 && y<col && y>=0 && maze[x][y]!=1){
            x=x+direction[0];
            y=y+direction[1];
        }
        
        if(visited[x-direction[0]][y-direction[1]]==0)
            q.add(new int[]{x-direction[0],y-direction[1]});
        
        visited[x-direction[0]][y-direction[1]]=1;
    }

    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       int[][] maze={{0,0,1,0,0}
                    ,{0,0,0,0,0}
                    ,{0,0,0,1,0}
                    ,{1,1,0,1,1}
                    ,{0,0,0,0,0}};
       int[] start={0,4};
       int[] destination={4,4};
       boolean ans=tr.hasPath(maze,start,destination);
       System.out.println(ans);           
    }

}