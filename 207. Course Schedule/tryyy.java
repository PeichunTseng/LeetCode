import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy
{
//////////////////////////others////////////////////////////////
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     Map<Integer,List<Integer>> map = new HashMap<>();
    //     for(int[] arr:prerequisites){
    //         map.putIfAbsent(arr[1],new ArrayList<>());
    //         map.get(arr[1]).add(arr[0]);
    //     }
    //     boolean[] visited= new boolean[numCourses];
    //     for(int i=0;i<numCourses;i++)
    //         if(cycle(map,i,visited,new boolean[numCourses]))
    //             return false;
    //     return true;
    // }

    // public boolean cycle(Map<Integer,List<Integer>> map, int course, boolean[] visited, boolean[] path){
    //     // this node has been checked, no cycle would be formed with this node.
    //     if(visited[course] || !map.containsKey(course))
    //         return false;

    //     // come across a previously visited node, i.e. detect the cycle
    //     if(path[course])
    //         return true;
        
    //     path[course]=true;
    //     for(int a:map.get(course)){
    //         if(cycle(map,a,visited,path))
    //            return true;
    //     }
    //     visited[course]=true;

    //     // backtracking
    //     path[course]=false;
    //     return false;
    // }

//////////////////////////Mine 20210502////////////////////////////////
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      Map<Integer,List<Integer>> map = new HashMap<>();
      for(int[] course:prerequisites){
        List<Integer> temp = map.getOrDefault(course[0],new ArrayList<>());
        temp.add(course[1]);
        map.put(course[0],temp);
      }
      int[] visited = new int[numCourses];
      for(int key:map.keySet()){
        if(cycle(key,map,new HashSet<>(),visited))
          return false;
      }
      return true;
    }

    public boolean cycle(int c, Map<Integer,List<Integer>> map, Set<Integer> set, int[] visited){
      if(set.contains(c))
        return true;
      if(!map.containsKey(c) || visited[c]==1)
        return false;

      set.add(c);
      visited[c]=1;
      List<Integer> list = map.get(c);
      for(int next:list){
        if(cycle(next,map,set,visited))
          return true;
        set.remove(next);
      }
      return false;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       //int[][] prerequisites={{1,0},{0,1}};
       int[][] prerequisites={{1,2},{0,1},{1,3},{1,4},{2,3}};
       boolean ans=tr.canFinish(5,prerequisites);
       System.out.println(ans);           
    }

}