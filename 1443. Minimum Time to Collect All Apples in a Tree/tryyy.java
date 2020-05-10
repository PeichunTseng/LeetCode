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
////////////////////Mine time limit///////////////////////
  // public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
  //     List<Integer> apple= new ArrayList<>();
  //     List<int[]> e= new ArrayList<>();

  //     for(int[] arr:edges)
  //         e.add(arr);

  //     for(int i=0;i<hasApple.size();i++)
  //         if(hasApple.get(i))
  //             apple.add(i);

  //     if(apple.size()==0)
  //         return 0;

  //     Set<Integer> visited = new HashSet<>();
  //     for(int i=0;i<apple.size();i++){
  //         dfs(apple.get(i), e, visited);
  //     }
  //     // for(int a:visited)
  //     //     System.out.println(a);
  //     return 2*visited.size();
      
  // }
  
  // public void dfs(int s, List<int[]> e, Set<Integer> visited){
  //     if(s==0 || visited.contains(s))
  //         return;
  //     for(int[] arr:e){
  //         if(arr[1]==s){
  //             visited.add(arr[1]);
  //             e.remove(arr);
  //             dfs(arr[0],e,visited);
  //             break;
  //         }
  //     }
  // }
////////////////////Others///////////////////////
  public int minTime(int n, int[][] edges, List<Boolean> hasApple){
      Map<Integer,List<Integer>> map = new HashMap<>();
      bulidGrapth(edges,map);
      return helper(0,map,hasApple);
  }

  public void bulidGrapth(int[][] edges, Map<Integer,List<Integer>> map){
      for(int[] arr: edges){
        map.putIfAbsent(arr[0],new ArrayList<>());
        map.get(arr[0]).add(arr[1]);
      }
  }

  public int helper(int start, Map<Integer,List<Integer>> map, List<Boolean> hasApple){
      int res=0;
      if(map.containsKey(start)){
          for(int child:map.get(start)){
            res+=helper(child,map,hasApple);
          }
      }
      if(start==0)
        return res;
      else if(hasApple.get(start) || res>0)
        res+=2;
      return res;
  }


  public static void main(String[] args){
    tryyy tr=new tryyy();
    int n=7; 
    int[][] edges={{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
    //boolean[] apple={false,false,true,false,true,true,false};
    boolean[] apple={false,false,true,false,false,true,false};
    List<Boolean> hasApple = new ArrayList<>();
    for(boolean b:apple)
        hasApple.add(b);
    int ans=tr.minTime(n,edges,hasApple);
    System.out.println(ans);
  }
}


