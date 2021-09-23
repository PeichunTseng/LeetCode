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
  // public int numMatchingSubseq(String s, String[] words) {

  //   int res = 0;
  //   Map<Character,List<Integer>> map = new HashMap<>();
  //   char[] arr = s.toCharArray();

  //   for(int i=0; i<arr.length; i++){
  //     char ch = arr[i];
  //     List<Integer> list = map.getOrDefault(ch,new ArrayList<>());
  //     list.add(i);
  //     map.put(ch,list);
  //   }   

  //   for(String str : words){
  //     char[] array = str.toCharArray();
  //     int ind = -1;

  //     for(char ch : array){
  //       if(!map.containsKey(ch)) {
  //         ind = -1;
  //         break;
  //       }
  //       List<Integer> list = map.get(ch);
  //       for(int i=0;i<list.size();i++){
  //         if(list.get(i)>ind) {
  //           ind = list.get(i);
  //           break;
  //         }
  //         if(i==list.size()-1 && list.get(i)<=ind) ind = -1;
  //       }
  //       if(ind == -1) break;
  //     }

  //     if(ind != -1) res++;
  //   }
  //   return res; 
  // }
//////////////////////Others/////////////////////
  public int numMatchingSubseq(String s, String[] words) {

    int res = 0;
    Map<Character,List<String>> map = new HashMap<>();

    for(String str : words){
      List<String> list = map.getOrDefault(str.charAt(0),new ArrayList<>());
      list.add(str);
      map.put(str.charAt(0),list);
    }

    for(char ch : s.toCharArray()){
      if(!map.containsKey(ch)) continue;
      
      List<String> list = map.get(ch);
      map.put(ch,new ArrayList<>());
      for(String str : list){
        String temp = str.substring(1,str.length());
        if(temp.length()==0) res++;
        else{
          List<String> ll = map.getOrDefault(temp.charAt(0),new ArrayList<>());
          ll.add(temp);
          map.put(temp.charAt(0),ll);
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    tryyy tr = new tryyy(); 
    String s = "dsahjpjauf"; 
    String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
    int ans = tr.numMatchingSubseq(s,words);
    System.out.println(ans);            
  }
}