import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
//////////////////////////Mine////////////////////////////////
    public String toGoatLatin(String S) {
        char[] vowel={'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> set= new HashSet<>();
        for(char ch:vowel)
          set.add(ch);
        String[] arr= S.split(" ");
        StringBuilder sb = new StringBuilder();
        String res="";
        sb.append("a");
        for(String s:arr){
          if(set.contains(s.charAt(0)))
            res+=s+"ma"+sb.toString()+" ";
          else
            res+=s.substring(1)+s.charAt(0)+"ma"+sb.toString()+" ";
          sb.append("a");
        }
        return res.substring(0,res.length()-1);
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       String S="The quick brown fox jumped over the lazy dog";
       String ans=tr.toGoatLatin(S);
       System.out.println(ans);           
    }
}