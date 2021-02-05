import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class tryyy{
    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = row==0 ? 0 :grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1)
                    res=Math.max(res,dfs(grid,i,j));
            }
        }
        return res;
    }
    
    public int dfs(int[][] grid, int x, int y){
        int res=1;
        grid[x][y]=0;
        for(int[] dir:direction){
            int newX = dir[0]+x;
            int newY = dir[1]+y;
            if(newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length && grid[newX][newY]==1){
                res=res+dfs(grid,newX,newY);
            }
        }
        return res;
    }

    public static void main(String[] args){
      int[][] grid ={{1,1,0,0,0},
                            {1,1,0,0,0},
                            {0,0,0,1,1},
                            {0,0,0,1,1}};
      tryyy tr=new tryyy();
      int ans=tr.maxAreaOfIsland(grid);
      System.out.println(ans);
    }
}