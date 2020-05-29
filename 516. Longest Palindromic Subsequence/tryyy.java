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
    public int longestPalindromeSubseq(String s){
        int[][] dp = new int[s.length()][s.length()];
        for(int r=0;r<s.length();r++){
            dp[r][r]=1;
            for(int l=r-1;l>=0;l--){
                if(s.charAt(l)==s.charAt(r))
                    dp[l][r]=dp[l+1][r-1]+2;
                else
                    dp[l][r]=Math.max(dp[l+1][r],dp[l][r-1]);
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       String s="bbbab";
       int ans=tr.longestPalindromeSubseq(s);
       System.out.println(ans);           
    }
}