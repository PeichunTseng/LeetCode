import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class tryyy
{

///////////////////mine////////////////////////
  public int maxScore(String s) {
        int zero=0;
        int one=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')
                zero++;
            else
                one++;
        }
        int total=one;
        
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0')
                total++;
            else{
                total--;
            }
            res=Math.max(res,total);
        }
        return res;
        
    }


  public static void main(String[] args) 
  {
    tryyy tr=new tryyy();
    String s="0100110";
    int ans=tr.maxScore(s);
    System.out.println(ans);
  }

}