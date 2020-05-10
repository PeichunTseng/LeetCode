import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math; 
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.PriorityQueue; 
import java.util.Queue; 
import java.util.LinkedList; 

public class tryyy
{
////////////////////Mine///////////////////////
  // public int findJudge(int N, int[][] trust){
  //     if(N==1)
  //         return 1;
  //     Map<Integer,Set<Integer>> map = new HashMap<>();
  //     Set<Integer> firseElement= new HashSet<>();
  //     int judge=-1;
  //     for(int[] arr:trust){
  //         firseElement.add(arr[0]);
  //         map.putIfAbsent(arr[1],new HashSet<>());
  //         map.get(arr[1]).add(arr[0]);
  //         if(map.get(arr[1]).size()==N-1)
  //             judge=arr[1];
  //     }
  //     if(firseElement.contains(judge))
  //         judge=-1;
  //     return judge;
      
  // }

////////////////////Others better///////////////////////
  public int findJudge(int N, int[][] trust) {
      int[] rec = new int[N+1];
      for(int[] arr: trust){
          rec[arr[0]]--;
          rec[arr[1]]++;
      }
      for(int i = 1; i <= N; ++i){
          if (rec[i] == N - 1) 
              return i;
      }
      return -1;
  }


  public static void main(String[] args){
    tryyy tr=new tryyy();
    int N=4;
    int[][] trust={{1,3},{1,4},{2,3},{2,4},{4,3}};
    int ans=tr.findJudge(N,trust);
    System.out.println(ans);
  }
}


