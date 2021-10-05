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
//////////////////////////Others///////////////////////////
  // public int[] findOriginalArray(int[] changed) {
  //   int len = changed.length;
  //   if(len % 2 != 0) return new int[0];
  //   int[] res = new int[len / 2];
  //   int ind = 0;
  //   TreeMap<Integer, Integer> map = new TreeMap<>();

  //   for(int element : changed){
  //     map.put(element, map.getOrDefault(element, 0) + 1);
  //   }

  //   for(int key : map.keySet()){
  //     if(map.get(key) == 0) continue;
  //     if(!map.containsKey(2 * key) || map.get(2 * key) < map.get(key)) return new int[0];
  //     for(int i = 0; i < map.get(key); i++){
  //       map.put(2 * key, map.get(2 * key) - 1);
  //       res[ind++] = key;
  //     }
  //   }
  //   return res;
  // }

//////////////////////////Others better///////////////////////////
  public int[] findOriginalArray(int[] changed) {
    if(changed.length%2!=0) return new int[0];
    int len = changed.length/2;
    int[] res = new int[len];
    int[] freq = new int[100001];
    int idx=0;

    for(int element : changed)
      freq[element]++;
    
    for(int i=0; i<freq.length; i++){
        while(freq[i] > 0 && i*2 < 100001 && freq[i*2]>0){
            freq[i]--;
            freq[i*2]--;
            res[idx++] = i;
        }
        if(freq[i]!=0) return new int[0];
    }
    return res;
  }

  public static void main(String[] args){
      tryyy tr=new tryyy(); 
      int[] changed = {1,3,4,2,6,8};
      int[] ans=tr.findOriginalArray(changed);
      for(int a : ans)
        System.out.println(a);           
  }
}