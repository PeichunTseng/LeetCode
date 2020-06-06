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
    public void wallsAndGates(int[][] rooms){
        int INF=2147483647;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        int row=rooms.length;
        int col= row==0 ? 0 : rooms[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rooms[i][j]==0)
                    q.offer(new int[]{i,j});
            }
        }
        int step=1;
        while(!q.isEmpty()){
            int count=q.size();
            for(int i=0;i<count;i++){
                int[] temp=q.poll();
                for(int[] dir:directions){
                    int x=temp[0]+dir[0];
                    int y=temp[1]+dir[1];
                    if(x>=0 && x<row && y>=0 && y<col && rooms[x][y]==INF){
                        rooms[x][y]=step;
                        q.offer(new int[]{x,y});
                    }
                }
            }
            step++;
        }
    }





    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int x=5;
        int y=5;
        int INF=2147483647;
        int[][] rooms={{INF, -1, 0, INF},
                      {INF, INF, INF, -1},
                      {INF, -1, INF, -1},
                      {0, -1, INF, INF}};
        tr.wallsAndGates(rooms);
        for(int[] arr:rooms){
            System.out.print(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);  
            System.out.println();  
        }         
    }
}