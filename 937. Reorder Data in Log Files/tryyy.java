import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
//import java.util.Entry;
//import java.util.*;



public class tryyy
{
///////////////////較好/////////////////
///////////////////Time Complexity: O(AlogA), where A is the total content of logs///////////
///////////////////Space Complexity: O(A), where A is the total content of logs//////////////
    // public String[] reorderLogFiles(String[] logs) 
    // {
    //     Arrays.sort(logs, (log1, log2) -> 
    //     {
    //         String[] split1 = log1.split(" ", 2);
    //         String[] split2 = log2.split(" ", 2);
    //         boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
    //         boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
    //         if (!isDigit1 && !isDigit2) 
    //         {
    //             int cmp = split1[1].compareTo(split2[1]);
    //             if (cmp != 0) 
    //                 return cmp;
    //             return split1[0].compareTo(split2[0]);
    //         }
    //         return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
    //     });
    //     return logs;
    // }


///////////////////較好/////////////////
///////////////////自己寫一遍/////////////////20190102
    // public String[] reorderLogFiles(String[] logs){
    //  Arrays.sort(logs,(a,b)->
    //  {
    //    String[] temA=a.split(" ",2);
    //    String[] temB=b.split(" ",2);
    //    String aa=temA[1];
    //    String bb=temB[1];
    //    if(Character.isLetter(aa.charAt(0)) && Character.isLetter(bb.charAt(0)) ){
    //      int com = aa.compareTo(bb);
    //      if(com==0){
    //        return temA[0].compareTo(temB[0]);
    //      }
    //      return com;
    //    }
    //    return Character.isLetter(aa.charAt(0)) ? -1 : (Character.isLetter(bb.charAt(0))?1:0);

    //  });
    //  return logs;
    // }

  ///////////////////自己寫一遍/////////////////20211205
  public String[] reorderLogFiles(String[] logs) {
      Arrays.sort(logs, (a,b) -> {
          String[] s1 = a.split(" ",2);
          String[] s2 = b.split(" ",2);
          boolean s1IsLetter = Character.isLetter(s1[1].charAt(0));
          boolean s2IsLetter = Character.isLetter(s2[1].charAt(0));
          if(s1IsLetter && s2IsLetter){
              return s1[1].compareTo(s2[1]) == 0 ? s1[0].compareTo(s2[0]) : s1[1].compareTo(s2[1]);
          }
          else if(!s1IsLetter && s2IsLetter) return 1;
          else if(s1IsLetter && !s2IsLetter) return -1;
          else return 0;
      });
      return logs;
  }


    public static void main(String[] args){
       tryyy tr=new tryyy();
       String[] logs={"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
       //Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
       String[] ans=tr.reorderLogFiles(logs);
       for(int i=0;i<ans.length;i++){
        System.out.println(ans[i]);
       }
    }
}


