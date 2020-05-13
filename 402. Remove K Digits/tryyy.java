import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Stack;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy
{
//////////////////////Others//////////////////////
  public String removeKdigits(String num, int k) {
      int len=num.length();
      Stack<Character> s = new Stack<>();
      if(k==len)
          return "0";
        
      int index=0;
      while(index<len){
        while(!s.isEmpty() && k>0 && s.peek()>num.charAt(index)){
          s.pop();
          k--;
        }
        s.push(num.charAt(index));
        index++;
      }

      while(k>0){
        s.pop();
        k--;
      }

      StringBuilder sb = new StringBuilder();
      while(!s.isEmpty())
        sb.append(s.pop());

      String res=sb.reverse().toString();
      while(res.length()>1 && res.charAt(0)=='0')
            res=res.substring(1);

      return res;
  }


  public static void main(String[] args){
     tryyy tr=new tryyy();
     String num="1432219";
     int k=3;
     String ans=tr.removeKdigits(num,k);
     System.out.println(ans);   
  }
}


