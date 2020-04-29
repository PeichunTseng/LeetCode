import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class tryyy
{
/////////////////Others//////////////////////
  public String decodeString(String s){
    int ind=0;
    Stack<Integer> num= new Stack<>();
    Stack<String> stack= new Stack<>();
    String res="";
    while(ind<s.length()){
      if(Character.isDigit(s.charAt(ind))){
        StringBuilder sb =new StringBuilder();
        while(Character.isDigit(s.charAt(ind))){
          sb.append(s.charAt(ind++));
        }
        num.push(Integer.valueOf(sb.toString()));
      } 
      else if(s.charAt(ind)=='['){
        stack.push(res);
        res="";
        ind++;
      }
      else if(s.charAt(ind)==']'){
        String pre=stack.pop();
        int count=num.pop();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count;i++){
          sb.append(res);
        }
        res=pre+sb.toString();
        ind++;
      }
      else
        res+=s.charAt(ind++);
    } 
    return res;
  }


  public static void main(String[] args){
    tryyy tr=new tryyy();
    String s="3[a]2[bc]";
    //String s="3[a]3[d2[bc]]"; //aaadbcbcdbcbcdbcbc
    System.out.println(tr.decodeString(s));   
  }
}


