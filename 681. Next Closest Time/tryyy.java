import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
//import java.util.Entry;
//import java.util.*;



public class tryyy
{
////////////Others //////////////////////
  public String nextClosestTime(String time){
    char[] res= time.toCharArray();
    TreeSet<Character> set = new TreeSet<>();
    for(char ch:res){
      if(Character.isDigit(ch))
        set.add(ch);
    }
    res[4]=transfer(set,res[4],'9');
    if(res[4]>time.charAt(4)) return String.valueOf(res);

    res[3]=transfer(set,res[3],'5');
    if(res[3]>time.charAt(3)) return String.valueOf(res);

    res[1]=transfer(set,res[1],res[0]=='2' ? '3' :'9' );
    if(res[1]>time.charAt(1)) return String.valueOf(res);

    res[0]=transfer(set,res[0],'2');
    return String.valueOf(res);
  }

  public char transfer(TreeSet<Character> set, char cur, char limit){
    Character ch=set.higher(cur);
    char res= (ch==null || ch>limit) ? set.first() : ch;
    return res;
  }

  public static void main(String[] args) {
    tryyy tr=new tryyy();
    String time="23:45";
    String ans=tr.nextClosestTime(time);
    System.out.println(ans);
  }

}


