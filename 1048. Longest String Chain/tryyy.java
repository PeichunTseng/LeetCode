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

public class tryyy
{
////////////////////mine/////////////////////
    // public int longestStrChain(String[] words) {
    //   Map<String,Integer> map = new HashMap<>();
    //   Arrays.sort(words,(a,b)->a.length()-b.length());
    //   int max=1;

    //   for(String s:words){
    //     map.putIfAbsent(s,1);
    //     if(s.length()>1){
    //       int val=1;
    //       for(int i=0;i<s.length();i++){
    //         String temp=s.substring(0,i)+s.substring(i+1);
    //         if(map.containsKey(temp)){
    //           int cur=map.get(temp)+1;
    //           val=map.getOrDefault(s,1);
    //           val=Math.max(val,cur);
    //           map.put(s,val);
    //           max=Math.max(max,val);
    //         }
    //       }
    //     }
    //   }
    //   return max; 
    // }


////////////////////improve/////////////////////
    public int longestStrChain(String[] words) {
      Map<String,Integer> map = new HashMap<>();
      Arrays.sort(words,(a,b)->a.length()-b.length());
      int max=1;

      for(String s:words){
        map.putIfAbsent(s,1);
        if(s.length()>1){
          int val=1;
          for(int i=0;i<s.length();i++){
            String temp=s.substring(0,i)+s.substring(i+1);
            val=Math.max(val,map.getOrDefault(temp,0)+1);
          }
          map.put(s,val);
          max=Math.max(max,val);
        }
      }
      return max; 
    }

    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       String[] words={"bda","a","bca","b","ba","bdca"};
       int ans=tr.longestStrChain(words);
       System.out.println(ans);            
    }

}


