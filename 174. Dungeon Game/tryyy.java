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
    public int calculateMinimumHP(int[][] dungeon) {
        int row=dungeon.length;
        int col=row==0?0:dungeon[0].length;
        if(dungeon[row-1][col-1]<=0)
            dungeon[row-1][col-1]=-dungeon[row-1][col-1]+1;
        else
            dungeon[row-1][col-1]=0;
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(i==row-1 && j==col-1)
                    continue;
                int right= j+1<col ? dungeon[i][j+1] : Integer.MAX_VALUE;
                int down=  i+1<row ? dungeon[i+1][j] : Integer.MAX_VALUE;
                int min=Math.min(right,down);
                if(dungeon[i][j]>0){
                    if(dungeon[i][j]>=min)
                        dungeon[i][j]=0;
                    else
                        dungeon[i][j]=min-dungeon[i][j];
                }
                else{
                    if(min==0)
                        dungeon[i][j]=-dungeon[i][j]+1;
                    else
                        dungeon[i][j]=-dungeon[i][j]+min;
                }
            }
        }
        return dungeon[0][0]==0?1:dungeon[0][0];
        
    }
    
    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[][] dungeon={{-2,-3,3},
                        {-5,-10,1},
                        {10,30,-5}};
       int ans=tr.calculateMinimumHP(dungeons);
       System.out.println(ans);   
    }
}