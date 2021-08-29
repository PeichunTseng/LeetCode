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

public class tryyy{

  public int minMeetingRooms(int[][] intervals) {
    int res = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Arrays.sort(intervals,(a,b)->a[0]-b[0]);
    for(int i=0;i<intervals.length;i++){
      if(!pq.isEmpty() && pq.peek()<=intervals[i][0]) pq.poll();
      else res++;
      pq.offer(intervals[i][1]);
    }
    return res;
  }



  public static void main(String[] args) {     
    tryyy tr= new tryyy();
    int [][] input={{0,30},
                    {5,10},
                    {15,20}};
    int [][] input1={{2,4},
                    {7,10}};                
    System.out.println(tr.minMeetingRooms(input));
    System.out.println(tr.minMeetingRooms(input1));
  }
}