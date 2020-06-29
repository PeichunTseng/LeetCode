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
////////////////////Others///////////////////////
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res=0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<manager.length;i++){
            map.putIfAbsent(manager[i],new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        res+=help(map,headID,informTime);
        return res;
    }

    public int help(Map<Integer,List<Integer>> map, int id, int[] informTime){
        if(!map.containsKey(id))
            return 0;
        int res=0;
        for(int a:map.get(id)){
            res=Math.max(res,help(map,a,informTime));
        }
        return res+informTime[id];
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int n=7; 
       int headID=6; 
       int[] manager={1,2,3,4,5,6,-1}; 
       int[] informTime={0,6,5,4,3,2,1};
       int ans=tr.numOfMinutes(n,headID,manager,informTime);
       System.out.println(ans);           
    }
}