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
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
    // 0: Haven't been colored yet.
    // 1: Blue.
    // -1: Red.
/////////////////////////////Mine /////////////////////////////
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int len = dislikes.length;
        if(len==0)
            return true;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int[] color=new int[N+1];
        for(int i=0;i<len;i++){
            map.putIfAbsent(dislikes[i][0],new HashSet<>());
            map.putIfAbsent(dislikes[i][1],new HashSet<>());
            map.get(dislikes[i][0]).add(dislikes[i][1]);
            map.get(dislikes[i][1]).add(dislikes[i][0]);
        }
 
        for(int i=1;i<=N;i++){
            int col=color[i];
            if(col!=0)
                continue;
            if(!dfs(dislikes,map,color,i,1))
                return false;
        }
        return true;
    }

    public boolean dfs(int[][] dislikes, Map<Integer,Set<Integer>> map, int[] color, int ind, int col){
        if(color[ind]!=0){
            if(color[ind]!=col)
                return false;
            else 
                return true;
        }
        color[ind]=col;
        if(map.containsKey(ind))
            for(int a:map.get(ind)){
                if(!dfs(dislikes,map,color,a,-col))
                    return false;
            }
        return true;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int N = 4;
        int[][] dislikes = {{1,2},{1,3},{2,4}};
        boolean ans=tr.possibleBipartition(N,dislikes);
        System.out.println(ans);           
    }
}