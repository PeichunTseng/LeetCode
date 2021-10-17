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
import java.util.Stack;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.Collections;

public class tryyy{
  ///////////////////Mine/////////////////
  Map<Integer,List<String>> from;
  Map<String, int[]> time;
  public tryyy() {
     from = new HashMap<>();
     time = new HashMap<>();   
  }
  
  public void checkIn(int id, String stationName, int t) {
      from.put(id, Arrays.asList(stationName, String.valueOf(t)));
  }
  
  public void checkOut(int id, String stationName, int t) {
      String fromStation = from.get(id).get(0);
      int fromTime = Integer.valueOf(from.get(id).get(1));
      String key = fromStation + " " + stationName;
      int[] temp = time.getOrDefault(key, new int[2]);
      temp[0] += t - fromTime;
      temp[1] ++;
      time.put(key, temp);
  }
  
  public double getAverageTime(String startStation, String endStation) {
      String key = startStation + " " + endStation;
      int[] temp = time.get(key);
      return (double)temp[0]/temp[1];
  }

  public static void main(String[] args) {
      tryyy tr=new tryyy();
      tr.checkIn(45, "Leyton", 3);
      tr.checkIn(32, "Paradise", 8);
      tr.checkIn(27, "Leyton", 10);
      tr.checkOut(45, "Waterloo", 15);
      tr.checkOut(27, "Waterloo", 20); 
      tr.checkOut(32, "Cambridge", 22);
      System.out.println(tr.getAverageTime("Paradise", "Cambridge"));
      System.out.println(tr.getAverageTime("Leyton", "Waterloo"));
  }
}


