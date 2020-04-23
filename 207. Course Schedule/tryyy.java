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

//binary tree//


public class tryyy
{
//////////////////////////others////////////////////////////////
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0)
            return true;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] arr:prerequisites){
            map.putIfAbsent(arr[1],new ArrayList<>());
            List<Integer> list = map.get(arr[1]);
            list.add(arr[0]);
        }

        boolean[] checked = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(isCyclic(i,map,checked,path))
                return false;
        }
        return true;
    }

    public boolean isCyclic(int course, Map<Integer,List<Integer>> map, boolean[] c, boolean[] p){
        if(c[course])  
            return false;
        // this node has been checked, no cycle would be formed with this node.

        if(p[course])
            return true;
        // come across a previously visited node, i.e. detect the cycle

        if(!map.containsKey(course))
            return false;
        p[course]=true;
        boolean res=false;
        List<Integer> list=map.get(course);
        for(int a:list){
            res=isCyclic(a,map,c,p);
            if(res)
                return true;
        }
        p[course]=false;
        // backtracking
        // after the visits of children, we come back to process the node itself
        // remove the node from the path

        c[course]=true;
        return false;
    }

    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       //int[][] prerequisites={{1,0},{0,1}};
       int[][] prerequisites={{1,2},{0,1},{1,3},{1,4},{2,3}};
       boolean ans=tr.canFinish(5,prerequisites);
       System.out.println(ans);           
    }

}


