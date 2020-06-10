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
    // public int[] loudAndRich(int[][] richer, int[] quiet) {
    //     int[] res=new int[quiet.length];
    //     Arrays.fill(res,-1);
    //     Map<Integer,List<Integer>> map  =new HashMap<>();
    //     for(int[] arr:richer){
    //         map.putIfAbsent(arr[1],new ArrayList<>());
    //         map.get(arr[1]).add(arr[0]);
    //     }
        
    //     for(int i=0;i<res.length;i++){
    //         if(res[i]==-1){
    //             Set<Integer> set = new HashSet<>();
    //             set.add(i);
    //             helper(i,map,res, set);
    //             if(res[i]==-1){
    //                 int temp=Integer.MAX_VALUE;
    //                 int ans=0;
    //                 for(int a:set){
    //                     if(quiet[a]<temp){
    //                         temp=quiet[a];
    //                         ans=a;
    //                     }
    //                 }
    //                 res[i]=ans;
    //             }
    //         }   
    //     }
    //     return res;
    // }
    
    // public void helper(int index, Map<Integer,List<Integer>> map,int[] res, Set<Integer> set){
    //     if(!map.containsKey(index)){
    //         res[index]=index;
    //         return;
    //     }
    //     for(int next:map.get(index)){
    //         if(!set.contains(next)){
    //             set.add(next);
    //             helper(next,map,res,set);
    //         }
    //     }
    // }

/////////////////////////Mine Improve/////////////////////// 
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] res=new int[quiet.length];
        for(int i=0;i<quiet.length;i++)
            res[i]=i;
        Map<Integer,List<Integer>> map  =new HashMap<>();
        for(int[] arr:richer){
            map.putIfAbsent(arr[1],new ArrayList<>());
            map.get(arr[1]).add(arr[0]);
            res[arr[1]]=-1;
        }
        
        for(int i=0;i<res.length;i++){
            if(res[i]==-1){
                Set<Integer> set = new HashSet<>();
                res[i]=helper(i,map,res,set,quiet);
                
            }   
        }
        return res;
    }
    
    public int helper(int index, Map<Integer,List<Integer>> map,int[] res, Set<Integer> set, int[] quiet){
        if(res[index]!=-1)
            return res[index];
        set.add(index);
        for(int next:map.get(index)){
            set.add(helper(next,map,res,new HashSet<>(),quiet));
        }
        int temp=Integer.MAX_VALUE;
        int ans=0;
        for(int a:set){
            if(quiet[a]<temp){
                temp=quiet[a];
                ans=a;
            }
        }
        res[index]=ans;
        return ans;
    }
/////////////////////////Others Better/////////////////////// 
    // HashMap<Integer, List<Integer>> richer2 = new HashMap<>();
    // int res[];
    // public int[] loudAndRich(int[][] richer, int[] quiet) {
    //     int n = quiet.length;
    //     for (int i = 0; i < n; ++i) 
    //         richer2.put(i, new ArrayList<Integer>());
    //     for (int[] v : richer) 
    //         richer2.get(v[1]).add(v[0]);
        
    //     res = new int[n]; 
    //     Arrays.fill(res, -1);
    //     for (int i = 0; i < n; i++) 
    //         dfs(i, quiet);
    //     return res;
    // }

    // public int dfs(int i, int[] quiet) {
    //     if (res[i] >= 0) 
    //         return res[i];
    //     res[i] = i;
    //     for (int j : richer2.get(i)) 
    //         if (quiet[res[i]] > quiet[dfs(j, quiet)]) 
    //             res[i] = res[j];
    //     return res[i];
    // }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[][] richer={{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet={3,2,5,4,6,1,7,0};
        int[] ans=tr.loudAndRich(richer,quiet);
        for(int a:ans)
            System.out.print(a+" ");         
    }
}