import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class tryyy
{
//////////////////////////BFS////////////////////////////////
//time complexity of O(V + E)
//V is the number of vertices 
//E is the number of edges in the graph.
    public int[] findOrder(int numCourses, int[][] prerequisites){
      Map<Integer,List<Integer>> map = new HashMap<>();
      int[] degree =  new int[numCourses];
      for(int[] arr : prerequisites){
        List<Integer> list = map.getOrDefault(arr[1],new ArrayList<>());
        list.add(arr[0]);
        degree[arr[0]]++;
        map.put(arr[1],list);
      }

      Queue<Integer> q = new LinkedList<>();
      for(int i=0;i<degree.length;i++){
        if(degree[i]==0)
          q.offer(i);
      }

      int[] res = new int[numCourses];
      int ind=0;
      while(!q.isEmpty()){
        int count = q.size();
        for(int i=0;i<count;i++){
          int temp = q.poll();
          res[ind++]=temp;
          if(map.containsKey(temp)){
            List<Integer> list = map.get(temp);
            for(int next:list){
              degree[next]--;
              if(degree[next]==0)
                q.offer(next);
            }
          }
        }
      }
      return ind==numCourses ? res : new int[]{};
    }

//////////////////////////DFS////////////////////////////////
    // static int White=1;
    // static int Gray=2;
    // static int Black=3;
    // Map<Integer,Integer> color = new HashMap<>();
    // Map<Integer,List<Integer>> adj = new HashMap<>();
    // boolean cycle=false;
    // public int[] findOrder(int numCourses, int[][] prerequisites){
    //     List<Integer> res= new ArrayList<>();
    //     for(int i=0;i<numCourses;i++){
    //         color.put(i,White);
    //     }
    //     for(int i=0;i<prerequisites.length;i++){
    //         adj.putIfAbsent(prerequisites[i][1],new ArrayList<>());
    //         List<Integer> list = adj.get(prerequisites[i][1]);
    //         list.add(prerequisites[i][0]);
    //     }
    //     for(int i=0;i<numCourses;i++){
    //         if(color.get(i)==White)
    //             dfs(i,res);
    //     }

    //     if(cycle)
    //         return new int[]{};

    //     int[] ans = new int[numCourses];
    //     for(int i=0;i<numCourses;i++){
    //         ans[i]=res.get(numCourses-1-i);
    //     }
    //     return ans;

    // }

    // public void dfs(int node, List<Integer> res){
    //     if(cycle)
    //         return;
    //     color.put(node,Gray);
    //     for(int a:adj.getOrDefault(node,new ArrayList<>())){
    //         if(color.get(a)==White)
    //             dfs(a,res);
    //         else if(color.get(a)== Gray){
    //             cycle=true;
    //             return;
    //         }
    //     }
    //     color.put(node,Black);
    //     res.add(node);
    // }

    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       int[][] prerequisites={{2,1},{3,1},{4,2},{4,3}};// 1 3 2 4 0
       int[] ans=tr.findOrder(5,prerequisites);
       for(int a:ans)
           System.out.println(a);           
    }
}
