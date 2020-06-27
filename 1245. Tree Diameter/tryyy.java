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
////////////////////Mine Time Limited///////////////////////
    // public int treeDiameter(int[][] edges) {
    //     int res=0;
    //     List<Set<Integer>> list =new ArrayList<>();
    //     for(int i=0;i<=edges.length;i++)
    //         list.add(new HashSet<>());

    //     for(int[] arr:edges){
    //         list.get(arr[0]).add(arr[1]);
    //         list.get(arr[1]).add(arr[0]);
    //     }

    //     Set<Integer> edge=new HashSet<>();
    //     for(int i=0;i<=edges.length;i++)
    //         if(list.get(i).size()==1)
    //             edge.add(i);
    //     for(int start:edge){
    //         res=Math.max(res,helper(start,list,start,edge));
    //     }
    //     return res;
    // }

    // public int helper(int point, List<Set<Integer>> list, int lastOne, Set<Integer> edge){
    //     int res=0;
    //     if(edge.contains(point)&& point!=lastOne)
    //       return res;
    //     for(int next:list.get(point)){
    //         if(next==lastOne)
    //           continue;
    //         res=Math.max(res,helper(next,list,point,edge)+1);
    //     }
    //     return res;
    // }

////////////////////Others Improve///////////////////////
    int res=0;
    public int treeDiameter(int[][] edges) {
        List<Set<Integer>> list =new ArrayList<>();
        for(int i=0;i<=edges.length;i++)
            list.add(new HashSet<>());

        for(int[] arr:edges){
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }

        helper(0,list,0);
        return res;
    }

    public int helper(int point, List<Set<Integer>> list, int lastOne){
        int max=0;
        int sec=0;

        for(int next:list.get(point)){
            if(next==lastOne)
              continue;
            int depth=helper(next,list,point);
            if(depth>max){
                sec=max;
                max=depth;
            }
            else if(depth>sec)
              sec=depth;
        }
        res=Math.max(res,max+sec);

        return max+1;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[][] edges={{0,1},{1,2},{2,3},{1,4},{4,5}};
       int ans=tr.treeDiameter(edges);
       System.out.println(ans);           
    }
}