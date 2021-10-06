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
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy{
//////////////////////////Mine///////////////////////////
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      int room = rooms.size();
      boolean[] visited = new boolean[room];
      Queue<Integer> q = new LinkedList<>();

      visited[0] = true;
      List<Integer> first = rooms.get(0);
      for(int k : first){
        q.offer(k);
      }

      while(!q.isEmpty()){
        int count = q.size();
        for(int i = 0; i < count; i++){
          int nextKey = q.poll();
          visited[nextKey] = true;
          List<Integer> list = rooms.get(nextKey);
          for(int k : list){
            if(visited[k]) continue;
            q.offer(k);
          }
        }
      }


      for(int i = 1; i < visited.length; i++){
        if(!visited[i]) return false;
      }
      return true;
  }

  public static void main(String[] args){
      tryyy tr=new tryyy(); 
      List<List<Integer>> rooms = new ArrayList<>();
      List<Integer> l0 = Arrays.asList(1, 3);
      List<Integer> l1 = Arrays.asList(3, 0, 1);
      List<Integer> l2 = Arrays.asList(2);
      List<Integer> l3 = Arrays.asList(0);
      rooms.add(l0);
      rooms.add(l1);
      rooms.add(l2);
      rooms.add(l3);
      boolean ans = tr.canVisitAllRooms(rooms);
      System.out.println(ans);           
  }
}