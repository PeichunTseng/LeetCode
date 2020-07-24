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

public class tryyy{
///////////////////////////////Mine////////////////////////////
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res= new ArrayList<>();
        int ending=graph.length-1;
        if(graph[0].length==0)
            return res;
        for(int s:graph[0]){
            List<Integer> list=new ArrayList<>();
            list.add(0);
            list.add(s);
            dfs(list,s,res,graph,ending);
        }
        return res;
    }

    public void dfs(List<Integer> list, int next, List<List<Integer>> res, int[][] graph, int ending){
        if(graph[next].length==0){
            if(next==ending)
                res.add(new ArrayList<>(list));
            return;
        }
        for(int s:graph[next]){
            list.add(s);
            dfs(list,s,res,graph,ending);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[][] graph={{1,2}, {3}, {3}, {}};
        List<List<Integer>> res=tr.allPathsSourceTarget(graph);
        for(List<Integer> l:res)
            System.out.println(l);           
    }
}