import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;
import java.util.Random;


public class tryyy
{
///////////////////////Others DFS////////////////////////
///////check circle and build graph in the same time////////////
    public int[] findRedundantConnection(int[][] edges) {
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0;i<=edges.length;i++){
            list.add(new HashSet<>());
        }

        int[] res=new int[2];
        Set<Integer> visited= new HashSet<>();
        for(int[] arr:edges){
            if(dfs(arr[0], arr[1], 0, list))
                res=arr;
            else{
                list.get(arr[0]).add(arr[1]);
                list.get(arr[1]).add(arr[0]);
            }
        }
        
        return res;
    }
    
    public boolean dfs(int a, int b, int last, List<Set<Integer>> list){
        if(a==b)
            return true;

        for(int next:list.get(a)){
            if(next==last)
                continue;
            if(dfs(next,b,a,list))
                return true;
        }
        return false;
    }

 
    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[][] edges={{2,4},{2,3},{3,4},{1,4}};
        int[] ans=tr.findRedundantConnection(edges);
        for(int i:ans)
        System.out.println(i);
    }
}