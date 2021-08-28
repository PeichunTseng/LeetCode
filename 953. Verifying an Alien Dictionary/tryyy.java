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
  
  public boolean isAlienSorted(String[] words, String order){
    Map<Character,Integer> map = new HashMap<>();
    // initiate character order
    for(int i=0;i<order.length();i++){
      map.put(order.charAt(i),i);
    }

    for(int i=0;i<words.length-1;i++){
      if(!help(words[i],words[i+1],map))
        return false;
    }
    return true;
  }

  public boolean help(String w1, String w2, Map<Character,Integer> map){
    int l1 = 0;
    int l2 = 0;
    int len1 = w1.length();
    int len2 = w2.length();
    while(l1<len1 && l2<len2){
      char ch1 = w1.charAt(l1);
      char ch2 = w2.charAt(l2);
      if(map.get(ch1)>map.get(ch2))
        return false;
      if(map.get(ch1)<map.get(ch2))
        return true;
      l1++;
      l2++;
    }
    if(l1!=len1) return false;
    return true;
  }
  
  public static void main(String[] args) {     
    tryyy tr= new tryyy();
    // String[] words={"word","world","row"};
    // String order = "worldabcefghijkmnpqstuvxyz";
    String[] words={"apple","app"};
    String order = "abcdefghijklmnopqrstuvwxyz";
    System.out.println(tr.isAlienSorted(words,order));
  }

}