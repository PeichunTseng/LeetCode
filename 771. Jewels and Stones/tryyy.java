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



public class tryyy
{

  // public int numJewelsInStones(String J, String S) {
  //   int total=0;
  //   for(int i=0;i<J.length();i++){
  //     for(int j=0;j<S.length();j++){
  //       if(J.charAt(i)==S.charAt(j))
  //         total++;
  //     }
  //   }
  //   return total;
  // }

  public int numJewelsInStones(String J, String S){
    Set<Character> set = new HashSet<>();
    int res=0;
    for(char ch:J.toCharArray())
        set.add(ch);
    for(char ch:S.toCharArray())
        if(set.contains(ch))
            res++;
    return res;
  }


  public static void main(String[] args) {
     tryyy tr=new tryyy();
     String J="aA";
     String S="aAAbbbb";
     int a =tr.numJewelsInStones(J,S);
     System.out.println(a);

  }
}


