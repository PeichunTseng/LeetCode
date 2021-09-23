import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy {

//////////////////////Other/////////////////////
  public int shortestPath(int[][] grid, int k) {

    int res = 0;
    int m = grid.length;
    int n = m == 0 ? 0 : grid[0].length;
    Queue<int[]> q = new LinkedList<>();
    int[][] obstacle = new int[m][n];
    int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    q.offer(new int[]{0,0,0});
    for(int i=0 ; i<m ; i++){
      Arrays.fill(obstacle[i], Integer.MAX_VALUE);
    }

    while(!q.isEmpty()){

      int count = q.size();
      for(int i=0 ; i<count ; i++){

        int[] temp = q.poll();
        if(temp[0] == m-1 && temp[1] == n-1) return res;

        for(int[] dir : direction){

          int x = dir[0] + temp[0];
          int y = dir[1] + temp[1];
          if(x < 0 || x >= m || y < 0 || y >= n) continue;

          int obs = temp[2] + grid[x][y];
          if(obs > k || obs >= obstacle[x][y]) continue;
          obstacle[x][y] = obs;
          q.offer(new int[]{x,y,obs});
        }
      }

      res++;
    }
    return -1;
  }

  public static void main(String[] args) {
    tryyy tr = new tryyy(); 
    int[][] grid = {{0,0,0},
                    {1,1,0},
                    {0,0,0},
                    {0,1,1},
                    {0,0,0}};
    int k = 1;
    int ans = tr.shortestPath(grid,k);
    System.out.println(ans);            
  }
}