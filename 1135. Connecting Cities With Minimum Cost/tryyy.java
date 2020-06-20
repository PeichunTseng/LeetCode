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
////////////////////////Others//////////////////////////////////
    public int minimumCost(int N, int[][] connections) {
        int res=0;
        Arrays.sort(connections,(a,b)->(a[2]-b[2]));
        int[] parent=new int[N+1];
        for(int i=0;i<parent.length;i++)
            parent[i]=i;
        for(int[] edge:connections){
            int x=edge[0];
            int y=edge[1];
            if(find(parent,x) != find(parent,y)){
                res+=edge[2];
                N--;
                union(parent,x,y);
            }
        }
        return N==1?res:-1;
    }

    private int find(int[] p, int ind){
        if(p[ind]==ind)
            return ind;
        p[ind]=find(p,p[ind]);
        return p[ind];
    }

    private void union(int[] p, int x, int y){
        int px=find(p,x);
        int py=find(p,y);
        p[px]=py;
    }

    // {2,3,1}
    // parent={0,1,2,3}
    // parent={0,1,3,3}

    // {1,2,5}
    // parent={0,1,3,3}
    // parent={0,3,3,3}

    // {1,3,6}
    // parent={0,3,3,3}
    // parent={0,3,3,3}

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int N=3;
       int[][] connections={{1,2,5},{1,3,6},{2,3,1}};
       int ans=tr.minimumCost(N,connections);
       System.out.println(ans);   
    }
}