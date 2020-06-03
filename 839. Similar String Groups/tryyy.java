import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;
import java.util.Random;


public class tryyy
{
///////////////////////Others DFS////////////////////////
    public int numSimilarGroups(String[] A) {
        int res=0;
        for(int i=0;i<A.length;i++)
            if(!A[i].equals("#")){
                String temp=A[i];
                A[i]="#";
                res++;
                dfs(temp,A);
            }
        return res;
    }

    public void dfs(String s, String[] A){
        for(int i=0;i<A.length;i++){
            if(!A[i].equals("#") && similar(s,A[i])){
                String temp=A[i];
                A[i]="#";
                dfs(temp,A);
            }
        }
    }

    public boolean similar(String a, String b){
        int count=0;
        for(int i=0;i<a.length();i++)
            if(a.charAt(i)!=b.charAt(i))
                count++;

        return count==2 || count==0;
    }

///////////////////////Others Union Find////////////////////////
    // public int numSimilarGroups(String[] a) {
    //     int n = a.length;
    //     int[] parent = new int[n];
    //     for (int i = 0; i < n; i++) 
    //         parent[i] = i;
         
    //     for (int i = 0; i < n - 1; i++) {
    //         for (int j = i + 1; j < n; j++) {
    //             if (isSimilarString(a[i], a[j])) {
    //                 int p1 = find(parent, i);
    //                 int p2 = find(parent, j);
    //                 if (p1 != p2) {
    //                     parent[p1] = p2;
    //                 }
    //             }
    //         }
    //     }
    //     int res = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (parent[i] == i) res++;
    //     }
    //     return res;
    // }

    // private boolean isSimilarString(String s1, String s2) {
    //     int diff = 0;
    //     for (int i = 0; i < s1.length(); i++) {
    //         if (s1.charAt(i) != s2.charAt(i)) 
    //             diff++;
    //     }
    //     return (diff == 2 || diff == 0);
    // }

    // private int find(int[] a, int x) {
    //     if (a[x] != x) {
    //         a[x] = find(a, a[x]);
    //     }
    //     return a[x];
    // }

 
    public static void main(String[] args){
        tryyy tr=new tryyy();
        String[] A={"tars","rats","arts","star"};
        int ans=tr.numSimilarGroups(A);
        System.out.println(ans);
    }
}