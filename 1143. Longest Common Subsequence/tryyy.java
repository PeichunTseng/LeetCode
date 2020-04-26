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
import java.util.Queue; 
import java.util.LinkedList; 

public class tryyy
{
  public int longestCommonSubsequence(String text1, String text2){
    int len1=text1.length();
    int len2=text2.length();
    int[][] dp= new int[len1+1][len2+1];
    for(int i=0;i<len1;i++){
      for(int j=0;j<len2;j++){
        if(text1.charAt(i)==text2.charAt(j))
          dp[i+1][j+1]=dp[i][j]+1;
        else
          dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
      }
    }
    return dp[len1][len2];
  }

  public static void main(String[] args) {     
    tryyy tr= new tryyy();
    String text1="abcde";
    String text2="ace";            
    System.out.println(tr.longestCommonSubsequence(text1,text2));
  }
}


