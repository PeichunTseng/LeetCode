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

public class tryyy {

 ////////////////////////Time Complexity:O(NK)/////////////////
 ////////////////////////Space Complexity:O(NK)/////////////////
  public List<List<String>> groupAnagrams(String[] strs){
    List<List<String>> res = new ArrayList<>();
    Map<String,List<String>> map = new HashMap<>();
    for(String s : strs){
      String temp = help(s);
      List<String> list = map.getOrDefault(temp, new ArrayList<>());
      list.add(s);
      map.put(temp,list);
    }

    for(List<String> l : map.values()) res.add(l);
    return res;
  }

  public String help(String s){
    int[] arr = new int[26];
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < s.length(); i++){
      int ind = s.charAt(i) - 'a';
      arr[ind]++;
    }

    for(int i = 0; i < 26; i++){
      sb.append(arr[i]);
      sb.append("-");
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    tryyy tr=new tryyy();
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> ans = tr.groupAnagrams(strs);
    System.out.println(ans);
  }
}