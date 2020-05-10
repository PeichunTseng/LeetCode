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
//////////////////////////////Others////////////////////////
  // public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
  //       List<String> path = new ArrayList<>();
  //       List<List<String>> result = new ArrayList<List<String>>();
  //       HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
  //       HashSet<String> dict = new HashSet<>(wordList);
  //       buildGraph(beginWord, endWord, graph, dict);
  //       // for(String s:graph.keySet()){
  //       //   System.out.println(s);
  //       //   List<String> ll = graph.get(s);
  //       //   System.out.println(ll);
  //       // }
  //       dfs(beginWord, endWord, graph, path, result);
  //       return result;
  // }
    
  // private void buildGraph(String beginWord, String endWord, HashMap<String, List<String>> graph, HashSet<String> dict) {
  //     HashSet<String> visited = new HashSet<>();
  //     HashSet<String> toVisit = new HashSet<>();
  //     Queue<String> queue = new LinkedList<>();
  //     queue.offer(beginWord);
  //     toVisit.add(beginWord);
  //     boolean foundEnd = false;
      
  //     while(!queue.isEmpty()) {
  //         visited.addAll(toVisit);
  //         toVisit.clear();
  //         int count = queue.size();
          
  //         for (int i = 0; i < count; i++) {
  //             String word = queue.poll();
  //             List<String> children = getNextLevel(word, dict);
  //             for (String child : children) {
  //                 if (child.equals(endWord)) foundEnd = true;
  //                 if (!visited.contains(child)) {
  //                     if (!graph.containsKey(word)) {
  //                         graph.put(word, new ArrayList<String>());
  //                     }
  //                     graph.get(word).add(child);
  //                 }
  //                 if (!visited.contains(child) && !toVisit.contains(child)) {
  //                     queue.offer(child);
  //                     toVisit.add(child);
  //                 }
  //             }
  //         }
          
  //         if (foundEnd) break;
  //     }
  // }
  
  // private List<String> getNextLevel(String word, HashSet<String> dict) {
  //     List<String> result = new ArrayList<>();
  //     char[] chs = word.toCharArray();
      
  //     for (int i = 0; i < chs.length; i++) {
  //         for (char c = 'a'; c <= 'z'; c++) {
  //             if (chs[i] == c) continue;
  //             char t = chs[i];
  //             chs[i] = c;
  //             String target = String.valueOf(chs);
  //             if (dict.contains(target)) result.add(target);
  //             chs[i] = t;
  //         }
  //     }
      
  //     return result;
  // }
  
  // private void dfs(String curWord, String endWord, HashMap<String, List<String>> graph, List<String> path, List<List<String>> result) {
  //     path.add(curWord);
      
  //     if (curWord.equals(endWord)) result.add(new ArrayList<String>(path));
  //     else if (graph.containsKey(curWord)) {
  //         for (String nextWord : graph.get(curWord)) {
  //             dfs(nextWord, endWord, graph, path, result);
  //         }
  //     }

  //     path.remove(path.size()-1);
  // }


//////////////////////////////Mine////////////////////////
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
      List<List<String>> res = new ArrayList<List<String>>();
      Set<String> set = new HashSet<>(wordList);
      Map<String, List<String>> map = new HashMap<>();
      buildGraph(beginWord, set, map);
      // for(String s:map.keySet()){
      //     System.out.println(s);
      //     List<String> ll = map.get(s);
      //     System.out.println(ll);
      // }
      dfs(beginWord,endWord,map,res,new ArrayList<>());
      return res;
  }

  private void buildGraph(String s, Set<String> set, Map<String, List<String>> map){
      Queue<String> q = new LinkedList<>();
      Set<String> visited = new HashSet<>();
      q.offer(s);
      visited.add(s);
      while(!q.isEmpty()){
          int count = q.size();
          Set<String> sameLevel = new HashSet<>();
          for(int j=0;j<count;j++){
              String temp = q.poll();
              char[] arr = temp.toCharArray();
              for(int i=0;i<arr.length;i++){
                  char ch = arr[i];
                  for(char c='a';c<='z';c++){
                      if(c==ch)
                        continue;
                      arr[i]=c;
                      // same level's next step can also be the others's next step
                      if(sameLevel.contains(String.valueOf(arr))){
                          List<String> list = map.getOrDefault(temp,new ArrayList<>());
                          list.add(String.valueOf(arr));
                          map.put(temp,list);
                      }
                      else if(set.contains(String.valueOf(arr)) && !visited.contains(String.valueOf(arr))){
                          sameLevel.add(String.valueOf(arr));
                          visited.add(String.valueOf(arr));
                          List<String> list = map.getOrDefault(temp,new ArrayList<>());
                          list.add(String.valueOf(arr));
                          map.put(temp,list);
                          q.offer(String.valueOf(arr));
                      }
                  }
                  arr[i]=ch;
              }
          }    
      }
  }

  public void dfs(String beginWord, String endWord, Map<String, List<String>> map, List<List<String>> res, List<String> list){
      list.add(beginWord);
      if(beginWord.equals(endWord)){
          List<String> end = new ArrayList<>(list);
          res.add(end);
          return;
        }
      if(!map.containsKey(beginWord))
          return;
      for(String next:map.get(beginWord)){
          dfs(next,endWord,map,res,list);
          list.remove(list.size()-1);
        }
  }

  public static void main(String[] args){
    tryyy tr=new tryyy();

    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = new ArrayList<>();
    String[] s={"hot","dot","dog","lot","log","cog"};
    for(String ss:s)
      wordList.add(ss);

    // String beginWord = "a";
    // String endWord = "c";
    // List<String> wordList = new ArrayList<>();
    // String[] s={"a","b","c"};
    // for(String ss:s)
    //   wordList.add(ss);


    List<List<String>> ans=tr.findLadders(beginWord,endWord,wordList);
    for(List<String> l:ans)
      System.out.println(l);
  }
}


