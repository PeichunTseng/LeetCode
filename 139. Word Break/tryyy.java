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

////////////////////////Others//////////////////////////////
  // public boolean wordBreak(String s, List<String> wordDict) {
  //     if(s.length() == 0) return true;
  //     Set<String> set = new HashSet<>();
  //     for(String ss : wordDict) set.add(ss);
  //     boolean[] arr = new boolean[s.length()+1];
      
  //     for(int i = 0; i < s.length(); i++){
  //         for(int j = 0; j <= i; j++){
  //             if(j!=0 && !arr[j]) continue;
  //             String temp = s.substring(j,i+1);
  //             if(set.contains(temp)) arr[i+1]=true;
  //         }
  //     }
      
  //     return arr[arr.length-1];
  // }

////////////////////////Others better//////////////////////////////
  public boolean wordBreak(String s, List<String> wordDict) {

          boolean[] wordbreak = new boolean[s.length()];
          Set<String> wordSet = new HashSet<>();
          
          int maxLength = 0;
          int minLength = Integer.MAX_VALUE;
          
          for(String word : wordDict)
          {
              minLength = Math.min(minLength, word.length());
              maxLength = Math.max(maxLength, word.length());
              wordSet.add(word);
          }
          
          int start = 0;
          
          for(int end = 0; end < s.length(); end++)
          {
              
              start = Math.max(0, end - maxLength);
              
              while(wordbreak[end] == false && end + 1 - start >= minLength)
              {
                  
                  if((start == 0 || wordbreak[start - 1]) && wordSet.contains(s.substring(start, end + 1)))
                  {
                      wordbreak[end] = true;
                  }
                  start++;
              }        
          }
          
          return wordbreak[s.length() - 1];
  }
          


    public static void main(String[] args) {
      tryyy tr=new tryyy();
      String s="applepenapple";
      List<String> list = new ArrayList<>(Arrays.asList("apple", "pen"));
      boolean ans = tr.wordBreak(s, list);
      System.out.println(ans);
    }
}