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
/////////////////////Others DFS//////////////////////
    public int removeStones(int[][] stones){
        if(stones==null || stones.length<=1)
            return 0;
        Set<String> visited = new HashSet<>();
        int res=0;
        for(int[] arr:stones){
            String temp=arr[0]+"-"+arr[1];
            if(!visited.contains(temp)){
                visited.add(temp);
                res++;
                helper(stones,arr[0],arr[1],visited);
            }
        }
        return stones.length-res;
    }

    public void helper(int[][] stones, int x, int y, Set<String> visited){
        for(int[] arr:stones){
            if(arr[0]==x || arr[1]==y){
                String temp=arr[0]+"-"+arr[1];
                if(!visited.contains(temp)){
                    visited.add(temp);
                    helper(stones,arr[0],arr[1],visited);
                }
            }
        }
    }



///////////////////// Others Union find //////////////////////
    // public int removeStones(int[][] stones){
    //     int res=0;
    //     int[] parent=new int[stones.length];
    //     for(int i=0;i<parent.length;i++){
    //         parent[i]=i;
    //     }
    //     for(int i=0;i<stones.length;i++){
    //         for(int j=i+1;j<stones.length;j++){
    //             if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1])
    //                 help(i,j,parent);
    //         }
    //     }

    //     for(int i=0;i<parent.length;i++){
    //         //System.out.println(parent[i]);
    //         if(i!=parent[i])
    //             res++;
    //     }
    //     return res;
    // }
    // // if two node that need to connect but have different parent node,
    // // we will merge it.
    // public void help(int i, int j, int[] p){
    //     int x=union(i,p);
    //     int y=union(j,p);
    //     if(x!=y)
    //         p[y]=x;

    // }
    // //union find of parent node
    // public int union(int x, int[]p){
    //     if(p[x]!=x)
    //         p[x]=union(p[x],p);
    //     return p[x];
    // }



    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       //int[][] stones={{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
       int[][] stones={{0,0},{0,1},{1,0},{2,2}};
       int ans=tr.removeStones(stones);
       System.out.println(ans);           
    }

}


