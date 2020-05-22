import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
//import java.util.Entry;
import java.util.*;


public class tryyy
{

////////////////////////Mine////////////////////////////////
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();  
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->(map.get(b)-map.get(a)));
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:map.keySet())
            pq.offer(ch);
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char ch=pq.poll();
            int count=map.get(ch);
            for(int i=0;i<count;i++)
                sb.append(ch);
        }
        return sb.toString();
    }

////////////////////////Others////////////////////////////////
    public String frequencySort(String s) {
        Map<Character,Integer> map= new HashMap<>();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());        
        pq.addAll(map.entrySet());///O(nlog(n))
        
        StringBuilder sb = new StringBuilder();  

        while(!pq.isEmpty()){
        	Map.Entry<Character, Integer> entry = pq.poll(); ///O(log(n))
        	char c = entry.getKey();
        	sb.append(String.join("",Collections.nCopies(entry.getValue(),String.valueOf(c)) ));

        }

        return sb.toString();  
    }


    public static void main(String[] args){
      tryyy tr=new tryyy();
      String s="tree";
      String ans=tr.frequencySort(s);
      System.out.println(ans);

    }
}