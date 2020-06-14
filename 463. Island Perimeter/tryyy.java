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
/////////////////////////Mine/////////////////////// 
    // public int islandPerimeter(int[][] grid) {
    //     int res=0;
    //     int row=grid.length;
    //     int col= row==0 ? 0 : grid[0].length;
    //     int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    //     Queue<int[]> q = new LinkedList<>();
    //     boolean flag=false;
    //     for(int i=0;i<row;i++){
    //         for(int j=0;j<col;j++){
    //             if(grid[i][j]==1){
    //                 q.offer(new int[]{i,j});
    //                 grid[i][j]=-1;
    //                 flag=true;
    //                 break;
    //             }
    //         }
    //         if(flag)
    //             break;
    //     }
    //     while(!q.isEmpty()){
    //         int[] arr=q.poll();
    //         int count=0;
    //         for(int[] dir:directions){
    //             int x=arr[0]+dir[0];
    //             int y=arr[1]+dir[1];
    //             if(x>=0 && x<row && y>=0 && y<col && grid[x][y]!=0){
    //                 count++;
    //                 if(grid[x][y]==1){
    //                     q.offer(new int[]{x,y});
    //                     grid[x][y]=-1;
    //                 }
    //             }  
    //         }
    //         res+=4-count;
    //     }
    //     return res;
    // }


/////////////////////////Others Better˙/////////////////////// 
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
    

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        // int[][] grid={{0,1,0,0},
        //               {1,1,1,0},
        //               {0,1,0,0},
        //               {1,1,0,0}};
        int[][] grid={{1,1},
                      {1,1}};
        int ans=tr.islandPerimeter(grid);
        System.out.println(ans);         
    }
}