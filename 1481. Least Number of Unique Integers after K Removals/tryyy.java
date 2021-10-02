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

public class tryyy{

// //////////////////////////Mine///////////////////////////
//   public int findLeastNumOfUniqueInts(int[] arr, int k) {
//     Map<Integer, Integer> map = new HashMap<>();
//     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
//     int total = 0;

//     for(int num : arr){
//       if(!map.containsKey(num)){
//         total++;
//         map.put(num,0);
//       }
//       map.put(num,map.get(num)+1);
//     }
//     pq.addAll(map.keySet());

//     while(!pq.isEmpty()){
//       int num = pq.poll();
//       int temp = map.get(num);
//       int reduce = Math.min(temp,k);
//       temp -= reduce;
//       k -= reduce;
//       map.put(num,temp);
//       if(temp == 0) total--;
//       if(k == 0) break;
//     }
//     return total;
//   }

//////////////////////////Others better///////////////////////////
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int total = 0;
    int[] v = new int[arr.length+1];

    for(int num : arr){
      if(!map.containsKey(num)){
        total++;
        map.put(num,0);
      }
      map.put(num,map.get(num)+1);
    }

    for(int value : map.values()){
      v[value]++;
    }

    for(int i=1; i<v.length; i++){
      if(v[i] == 0) continue;
      int temp = Math.min(i*v[i], k);

      // k is smaller
      if(temp < i*v[i]){
        total -= k/i;
        break;
      }
      // k is bigger
      else{
        total -= v[i];
        k -= temp;
      }
    }
    return total;
  }

  public static void main(String[] args){
      tryyy tr=new tryyy(); 
      int[] arr = {4,3,1,1,3,3,2};
      int k = 3;
      int ans=tr.findLeastNumOfUniqueInts(arr, k);
      System.out.println(ans);           
  }
}