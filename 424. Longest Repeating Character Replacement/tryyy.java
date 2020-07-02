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
////////////////////////////Others//////////////////////////////
    public int characterReplacement(String s, int k) {
        int len=s.length();
        int start=0;
        int[] dp=new int[26];
        int res=0;
        int max=0;
        for(int i=0;i<len;i++){
          char ch=s.charAt(i);
          max=Math.max(max,++dp[ch-'A']);
          if(i-start+1>max+k){
            dp[s.charAt(start)-'A']--;
            start++;
          }
          res=Math.max(res,i-start+1);
        }
        return res;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       String s="AABABBA";
       int k=1;
       int ans=tr.characterReplacement(s,k);
       System.out.println(ans);           
    }
}