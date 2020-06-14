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
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        class edge{
            int des;
            int weight;
            public edge(int d, int w){
                des=d;
                weight=w;
            }  
        }
        // Build graph
        List<Set<edge>> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new HashSet<>());
        for(int[] arr:flights){
            list.get(arr[0]).add(new edge(arr[1],arr[2]));
        }
        
        int res=Integer.MAX_VALUE;
        Queue<edge> q= new LinkedList<>();
        q.offer(new edge(src,0));
        while(K>=0 && !q.isEmpty()){
            int count=q.size();
            for(int i=0;i<count;i++){
                edge s=q.poll();
                Set<edge> set=list.get(s.des);
                for(edge e:set){
                    if(e.des==dst && s.weight+e.weight<res)
                        res=s.weight+e.weight;
                    else if(s.weight+e.weight>=res)
                        continue;
                    else if(list.get(e.des).size()>0)
                        q.offer(new edge(e.des,s.weight+e.weight));
                }
            }
            K--;
        }
        return res==Integer.MAX_VALUE ? -1 : res;
        
        
        
    }


/////////////////////////Others Dijkstra's algorithm/////////////////////// 
    // public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    //     Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
    //     for (int[] f : flights) {
    //         if (!prices.containsKey(f[0])) 
    //             prices.put(f[0], new HashMap<>());
    //         prices.get(f[0]).put(f[1], f[2]);
    //     }
    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
    //     pq.add(new int[] {0, src, k + 1});
    //     while (!pq.isEmpty()) {
    //         int[] top = pq.poll();
    //         int price = top[0];
    //         int city = top[1];
    //         int stops = top[2];
    //         if (city == dst) return price;
    //         if (stops > 0) {
    //             Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
    //             for (int a : adj.keySet()) {
    //                 pq.add(new int[] {price + adj.get(a), a, stops - 1});
    //             }
    //         }
    //     }
    //     return -1;
    // }
    

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int n=3; 
        int[][] flights={{0,1,100},{1,2,100},{0,2,500}}; 
        int src=0; 
        int dst=2; 
        int K=1;
        int ans=tr.findCheapestPrice(n, flights, src, dst, K);
        System.out.println(ans);         
    }
}