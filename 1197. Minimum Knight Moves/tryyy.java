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
    // public int minKnightMoves(int x, int y) {
    //     int[][] directions={{1,2},{1,-2},{-1,2},{-1,-2},{2,-1},{2,1},{-2,-1},{-2,1}};
    //     int res=0;
    //     Queue<int[]> q = new LinkedList<>();
    //     Map<Integer,Set<Integer>> map = new HashMap<>();
    //     map.putIfAbsent(0,new HashSet<>());
    //     map.get(0).add(0);
    //     q.offer(new int[]{0,0});
    //     while(!q.isEmpty()){
    //         int count=q.size();
    //         for(int i=0;i<count;i++){
    //             int[] temp=q.poll();
                
    //             if(temp[0]==x && temp[1]==y)
    //                 return res;
    //             for(int[] dir:directions){
    //                 int newX=temp[0]+dir[0];
    //                 int newY=temp[1]+dir[1];
    //                 if(map.containsKey(newX) && map.get(newX).contains(newY))
    //                     continue;
    //                 else{
    //                     q.offer(new int[]{newX,newY});
    //                     map.putIfAbsent(newX,new HashSet<>());
    //                     map.get(newX).add(newY);
    //                 }
    //             }
    //         }
    //         res++;
    //     }
    //     return res;
    // }

/////////////////////////Mine Improve///////////////////////
    public int minKnightMoves(int x, int y) {
        int[][] directions={{1,2},{1,-2},{-1,2},{-1,-2},{2,-1},{2,1},{-2,-1},{-2,1}};
        x=Math.abs(x);
        y=Math.abs(y);
        int res=0;
        Queue<int[]> q = new LinkedList<>();
        Map<Integer,Set<Integer>> map = new HashMap<>();
        map.putIfAbsent(0,new HashSet<>());
        map.get(0).add(0);
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int count=q.size();
            for(int i=0;i<count;i++){
                int[] temp=q.poll();
                
                if(temp[0]==x && temp[1]==y)
                    return res;
                for(int[] dir:directions){
                    int newX=temp[0]+dir[0];
                    int newY=temp[1]+dir[1];
                    if(map.containsKey(newX) && map.get(newX).contains(newY) || newX<-1 || newY<-1)
                        continue;
                    else{
                        q.offer(new int[]{newX,newY});
                        map.putIfAbsent(newX,new HashSet<>());
                        map.get(newX).add(newY);
                    }
                }
            }
            res++;
        }
        return res;
    }



    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int x=5;
       int y=5;
       int ans=tr.minKnightMoves(x,y);
       System.out.println(ans);           
    }
}