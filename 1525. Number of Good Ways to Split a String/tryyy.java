import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy {

//////////////////////Mine/////////////////////
  public int numSplits(String s){

    int res = 0;
    int left = 0;
    Map<Character,Integer> map = new HashMap<>();
    Set<Character> set = new HashSet<>();

    for(char c : s.toCharArray()){
      int sum = map.getOrDefault(c,0);
      map.put(c,sum+1);
    }

    int total = map.size();
    for(int i=0 ; i<s.length()-1 ; i++){
      char temp = s.charAt(i);
      int count = map.get(temp);
      if(!set.contains(temp)){
        left++;
        set.add(temp);
      }
      map.put(temp,count-1);
      if(map.get(temp) == 0) total--;
      if(left == total) res++;

    }
    return res;

  } 

  public static void main(String[] args) {
    tryyy tr = new tryyy(); 
    String s = "aacaba";
    int ans = tr.numSplits(s);
    System.out.println(ans);            
  }
}