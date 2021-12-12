import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class tryyy{
/////////////////////////////Mine Time Limit///////////////////////////////
  // public int uniqueLetterString(String s){

  //   int res = 0;
  //   int len = 1;
  //   for(int i = 1; i <= s.length(); i++){
  //     for(int j = 0; j+i <= s.length(); j++){
  //       res += countUniqueChars(s.substring(j,i+j));
  //     }
  //   }
  //   return res;
  // }

  // public int countUniqueChars(String s){

  //   Set<Character> set = new HashSet<>();
  //   Set<Character> alreadyCount = new HashSet<>();
  //   int res = 0;

  //   for(int i = 0; i < s.length(); i++){
  //     char temp = s.charAt(i);
  //     if(set.contains(temp)) {
  //         if(alreadyCount.contains(temp)) continue;
  //         alreadyCount.add(temp);
  //         res--;
  //     }
  //     else {
  //       set.add(temp);
  //       res++;
  //     }
  //   }
  //   return res;
  // }

/////////////////////////////Others Improve///////////////////////////////

  public int uniqueLetterString(String s) {
    int[] lastPosition = new int[26];
    int[] contribution = new int[26];
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      int curChar = s.charAt(i) - 'A';
      int totalNumOfSubstringsEndingHere = i + 1;
      contribution[curChar] = totalNumOfSubstringsEndingHere - lastPosition[curChar];

      int cur = 0;
      for (int j = 0; j < 26; j++) {
        cur += contribution[j];
      }

      res += cur;

      lastPosition[curChar] = i + 1;
    }
    return res;
  }


  public static void main(String[] args) {
    tryyy tr=new tryyy(); 
    String s = "ABCB";
    int ans = tr.uniqueLetterString(s);
    System.out.println(ans);     
  }
}