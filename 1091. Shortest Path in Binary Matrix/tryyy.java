import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
////////////////////////////Mine//////////////////////////////
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = row == 0 ? 0 : grid[0].length;
        if(grid[0][0] != 0) return -1;
        int res = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0]=1;

        while(!q.isEmpty()){
            int count = q.size();
            for(int i = 0; i < count; i++){
                int[] temp = q.poll();
                if(temp[0] == row-1 && temp[1] == col-1) return res;
                for(int[] dir : directions){
                    int x = dir[0] + temp[0];
                    int y = dir[1] + temp[1];
                    if(x >= 0 && x < row && y >=0 && y < col && grid[x][y] == 0){
                        grid[x][y] = 1;
                        q.offer(new int[]{x,y});
                    }
                }
            }
            res++;
        }
        return -1;
    }


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[][] grid = {{0,0,0},
                        {1,1,0},
                        {1,1,0}};
        int ans = tr.shortestPathBinaryMatrix(grid);
        System.out.println(ans);
    }
}