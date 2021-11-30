import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class tryyy{
/////////////////////////////Mine///////////////////////////////
  public int maximalNetworkRank(int n, int[][] roads) {
      Map<Integer, Set<Integer>> map = new HashMap<>();
      int res = 0;
      for(int[] road : roads){
          for(int i = 0; i <= 1; i++){
              int A = road[i];
              int B = road[Math.abs(i-1)];
              Set<Integer> set = map.getOrDefault(A, new HashSet<>());
              set.add(B);
              map.put(A,set);
          }
      }
      
      for(int i = 0; i < n ; i++){
          int first = !map.containsKey(i) ? 0 : map.get(i).size();
          for(int j = i+1; j < n; j++){
              int sec = !map.containsKey(j) ? 0 : map.get(j).size();
              int total = first + sec;
              if(map.containsKey(j) && map.get(j).contains(i)) total--;
              res = Math.max(res, total);
          }
      }
      
      return res;
  }

  public static void main(String[] args) {
    tryyy tr=new tryyy(); 
    int n = 8;
    int[][] roads = {{0, 1},
                      {1, 2},
                      {2, 3},
                      {2, 4},
                      {5, 6},
                      {5, 7}};
    int ans = tr.maximalNetworkRank(n, roads);
    System.out.println(ans);     
  }
}