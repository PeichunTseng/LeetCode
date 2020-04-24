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

//binary tree//


public class tryyy
{
//////////////////////////mine Error////////////////////////////////
    // public int[] findOrder(int numCourses, int[][] prerequisites) {
    //     if(prerequisites.length==0 && numCourses==0)
    //         return new int[]{};
    //     int[] ans = new int [numCourses];
    //     if(prerequisites.length==0){
    //         for(int i=0;i<numCourses;i++)
    //             ans[i]=i;
    //         return ans;
    //     }
    //     int size=0;
    //     Set<Integer> first = new HashSet<>();
    //     Set<Integer> sec = new HashSet<>();
    //     List<Integer> head = new ArrayList<>();
    //     List<Integer> content = new ArrayList<>();
    //     Map<Integer,List<Integer>> map = new HashMap<>();
    //     boolean cycle=false;
    //     for(int[] arr:prerequisites){
    //         first.add(arr[1]);
    //         sec.add(arr[0]);
    //         map.putIfAbsent(arr[1],new ArrayList<>());
    //         List<Integer> list = map.get(arr[1]);
    //         list.add(arr[0]);
    //     }
    //     for(int a:first){
    //         if(!sec.contains(a))
    //             head.add(a);
    //     }
    //     //System.out.println(head);
    //     boolean[] checked = new boolean[numCourses];
    //     boolean[] path = new boolean[numCourses];
    //     int ansHead=0;
    //     for(int i=0;i<numCourses;i++){
    //         Stack<Integer> res = new Stack<Integer>();
    //         checked = new boolean[numCourses];
    //         cycle=isCyclic(i,map,checked,path,res);
    //         if(cycle)
    //             return new int[]{};
    //         else{
    //             if(head.contains(i) && res.size()>size){
    //                 content = new ArrayList<>();
    //                 ansHead=i;
    //                 int ind=0;
    //                 size=res.size();
    //                 while(!res.isEmpty()){
    //                     int tem =res.pop();
    //                     content.add(tem);    
    //                     ans[ind]=tem;
    //                     ind++;
    //                 }
                    
    //             }
    //         }
    //     }
    //     for(int i=0;i<numCourses;i++){
    //         if(!content.contains(i)){
    //             ans[size]=i;
    //             size++;
    //         }
    //     }
    //     return ans;
    // }

    // public boolean isCyclic(int course, Map<Integer,List<Integer>> map, boolean[] c, boolean[] p,Stack<Integer> res){
    //     if(c[course])  
    //         return false;
    //     // this node has been checked, no cycle would be formed with this node.

    //     if(p[course])
    //         return true;
    //     // come across a previously visited node, i.e. detect the cycle

    //     if(!map.containsKey(course)){
    //         if(!res.contains(course))
    //             res.push(course);
    //         return false;
    //     }
        
    //     p[course]=true;
    //     boolean r=false;
    //     List<Integer> list=map.get(course);
    //     for(int a:list){
    //         r=isCyclic(a,map,c,p,res);
    //         if(r)
    //             return true;
    //         //res.push(a);
    //     }
    //     p[course]=false;
    //     // backtracking
    //     // after the visits of children, we come back to process the node itself
    //     // remove the node from the path

    //     c[course]=true;
    //     res.push(course);
    //     return false;
    // }


//////////////////////////Solution////////////////////////////////
    static int White=1;
    static int Gray=2;
    static int Black=3;
    Map<Integer,Integer> color = new HashMap<>();
    Map<Integer,List<Integer>> adj = new HashMap<>();
    boolean cycle=false;
    public int[] findOrder(int numCourses, int[][] prerequisites){
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            color.put(i,White);
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.putIfAbsent(prerequisites[i][1],new ArrayList<>());
            List<Integer> list = adj.get(prerequisites[i][1]);
            list.add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(color.get(i)==White)
                dfs(i,res);
        }

        if(cycle)
            return new int[]{};

        int[] ans = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            ans[i]=res.get(numCourses-1-i);
        }
        return ans;

    }

    public void dfs(int node, List<Integer> res){
        if(cycle)
            return;
        color.put(node,Gray);
        for(int a:adj.getOrDefault(node,new ArrayList<>())){
            if(color.get(a)==White)
                dfs(a,res);
            else if(color.get(a)== Gray){
                cycle=true;
                return;
            }
        }
        color.put(node,Black);
        res.add(node);
    }


    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       int[][] prerequisites={{2,1},{3,1},{4,2},{4,3}};// 1 3 2 4 0
       int[] ans=tr.findOrder(5,prerequisites);
       for(int a:ans)
           System.out.println(a);           
    }

}


