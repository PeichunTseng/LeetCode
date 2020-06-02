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

public class tryyy
{
///////////////////////Mine Time Limit////////////////////////
    // int min=Integer.MAX_VALUE;
    // public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    //     Map<Integer,List<Integer>> map = new HashMap<>();
    //     List<Integer> res= new ArrayList<>();
    //     if(edges.length==0){
    //         res.add(0);
    //         return res;
    //     }
    //     int[] record=new int[n];
    //     Arrays.fill(record,Integer.MAX_VALUE);

    //     for(int[] arr:edges){
    //         map.putIfAbsent(arr[0],new ArrayList<>());
    //         map.putIfAbsent(arr[1],new ArrayList<>());
    //         map.get(arr[0]).add(arr[1]);
    //         map.get(arr[1]).add(arr[0]);
    //     }

    //     for(int i=0;i<n;i++){
    //         if(map.get(i).size()<=1)
    //             continue;
    //         Set<Integer> set = new HashSet<>();
    //         record[i]=helper(i,map,set,0,Integer.MIN_VALUE);
    //         min=Math.min(record[i],min);
    //     }

    //     for(int i=0;i<record.length;i++){
    //         if(record[i]==min)
    //             res.add(i);
    //     }

    //     return res;
    // }
    
    // private int helper(int s, Map<Integer,List<Integer>> map, Set<Integer> set,int depth, int currentMin){
    //     set.add(s);
    //     List<Integer> l = map.get(s);
    //     for(int next:l){
    //         if(set.contains(next)){
    //             currentMin = Math.max(depth,currentMin);
    //             continue;
    //         }
    //         currentMin= Math.max(helper(next,map,set,depth+1,currentMin),currentMin);
    //         if(currentMin>min)
    //             return currentMin;
    //         set.remove(next);
    //     }
    //     return currentMin;
    // }

///////////////////////Others Better////////////////////////
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<Integer> res= new ArrayList<>();
        if(edges.length==0){
            res.add(0);
            return res;
        }

        for(int[] arr:edges){
            map.putIfAbsent(arr[0],new ArrayList<>());
            map.putIfAbsent(arr[1],new ArrayList<>());
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(map.get(i).size()==1)
                leaves.add(i);
        }

        while(n>2){
            n=n-leaves.size();
            List<Integer> nextLeaves = new ArrayList<>();
            for(int a:leaves){
                int temp=map.get(a).get(0);
                map.get(temp).remove(Integer.valueOf(a));
                if(map.get(temp).size()==1)
                    nextLeaves.add(temp);
            }
            leaves=nextLeaves;
        }
        return leaves;
    }
    
 
    public static void main(String[] args){
        tryyy tr=new tryyy();
        // int[][] edges={{0,3},{1,3},{2,3},{4,3},{5,4}};
        // int n=6;
        int[][] edges={{1,0},{0,2},{0,3},{3,4},{4,5}};
        int n=6;
        List<Integer> ans=tr.findMinHeightTrees(n,edges);
        System.out.println(ans);
    }
}