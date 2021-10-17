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
  int current;
  int total;
  Map<Integer,String> map;
  public tryyy(int n) {
      total = n;
      current = 1;  
      map = new HashMap<>();  
  }
  
  public List<String> insert(int idKey, String value) {
      List<String> res = new ArrayList<>();
      map.put(idKey, value);

      while(current <= total){
        if(!map.containsKey(current)) break;
        res.add(map.get(current));
        current++;
      }
      return res;
  }

  public static void main(String[] args) {
     tryyy tr=new tryyy(5);
     System.out.println(tr.insert(3, "ccccc"));
     System.out.println(tr.insert(1, "aaaaa"));
     System.out.println(tr.insert(2, "bbbbb"));
     System.out.println(tr.insert(5, "eeeee"));
     System.out.println(tr.insert(4, "ddddd"));
  }
}


