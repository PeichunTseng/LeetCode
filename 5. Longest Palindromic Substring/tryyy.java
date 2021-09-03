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

public class tryyy {
///////////////////Brute Force (n^3)////////////////////
  //   public String longestPalindrome(String s){
  //   String ans="";
  //   for(int i=0;i<s.length();i++){
  //       for(int j=0;j<=i;j++){
  //           int start=j;
  //           int e=i;
  //           while(s.charAt(start)==s.charAt(e))
  //           {
  //               if(start==e || e-start==1){
  //                   if(i-j+1>ans.length())
  //                       ans=s.substring(j,i+1);
  //                   break;
  //               }
  //               start++;
  //               e--;

  //           }
  //       }
  //   }
  //   return ans;
  // }
///////////////////Brute Force (n^3)比上面的好  //// if在while外可以先排除一些結果////////////////////

    // public String longestPalindrome(String s) {
    //      String res = "";
    //     int start, end;
    //     for(int i = 0; i<s.length(); i++)
    //     {
    //         for(int j = 0; j<=i; j++)
    //         {
    //             start = j; end = i;
    //             if((i-j+1)>res.length())
    //             {
    //                while(s.charAt(start)==s.charAt(end))
    //                {
    //                     if(start == end || (end-start)==1)
    //                     {
    //                         res = s.substring(j, i+1);
    //                         break;
    //                     }
    //                     start ++; end --;
    //                 }
    //             }
    //         }  
    //     }
    //     return res;
        
    // }

//////////////////最快的方法 DP  O(n^3)/////////////////////////////////////
   //  public static String longestPalindrome(String s){
   //  if(s.length()==0)
   //      return "";
   //  int n=s.length();
   //  boolean[][] dp = new boolean[n][n];
   //  int len=0;
   //  int start=0;
   //  int end=0;
   //  for(int i=0;i<n;i++){
   //      for(int j=0;j<=i;j++)
   //          dp[i][j]=true;
   //  }

   //  for(int i=n-2;i>=0;i--){
   //      for(int j=i+1;j<n;j++){
   //          if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
   //              dp[i][j]=true;
   //              if(j-i+1>len)
   //              {
   //                  start=i;
   //                  end=j;
   //                  len=j-i+1;
   //              }
   //          }
   //      }
   //  }
   //  return s.substring(start,end+1);

   // }

//////////////////較好 2 pointer O(n^2)/////////////////////////////////////
    int head = 0;
    int tail = 0;
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        
        for(int i=0;i<len;i++){
            help(s,i,i);
            help(s,i,i+1);
        }
        
        return s.substring(head,tail+1);
    }
    
    public void help(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        
        if(r-l-1 > tail-head+1){
            head = l+1;
            tail = r-1;
        }
    }
 
    public static void main(String[] args) {
       tryyy tr = new tryyy();
       String s= "waabcbaaz";
       String a=tr.longestPalindrome(s);
       System.out.println(a);

    }
}