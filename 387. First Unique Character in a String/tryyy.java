import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
//import java.util.Entry;
//import java.util.*;



public class tryyy
{
////////////////////Mine/////////////////////
  // public int firstUniqChar(String s){
  //     Map<Character,Integer> map = new HashMap<>();
  //     for(char ch:s.toCharArray()){
  //         map.put(ch,map.getOrDefault(ch,0)+1);
  //     }
  //     for(int i=0;i<s.length();i++){
  //         if(map.get(s.charAt(i))==1)
  //             return i;
  //     }
  //     return -1;
  // }

/////////////////////Others better//////////////////////
  public int firstUniqChar(String s){
      int[] arr = new int[26];
      for(char c:s.toCharArray())
          arr[c-'a']++;
      for(int i=0;i<s.length();i++)
          if(arr[s.charAt(i)-'a']==1)
              return i;
      return -1;
  }

  public static void main(String[] args) {
    tryyy tr=new tryyy();  
    String s="leetcode";
    int ans=tr.firstUniqChar(s); 
    System.out.println(ans);
  }

}