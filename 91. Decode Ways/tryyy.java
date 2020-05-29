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
////////////////////////////Mine Time limit//////////////////////////////
    // int res=0;
    // public int numDecodings(String s) {
    //    StringBuilder sb = new StringBuilder();
    //    Set<String> set = new HashSet<>();
    //    for(int i=1;i<=26;i++)
    //     set.add(String.valueOf(i));
    //    helper(s,0,set);
    //    return res;
    // }

    // public void helper(String s, int ind, Set<String> set){
    //     if(ind>=s.length()){
    //         if(ind==s.length())
    //             res++;
    //         return;
    //     }
    //     for(int i=ind;i<=ind+1;i++){
    //         if(i<s.length()){
    //             String temp=s.substring(ind,i+1);
    //             if(set.contains(temp)){
    //                 helper(s,i+1,set);
    //             }
    //         }
    //     }
    // }

////////////////////////////Mine Improve//////////////////////////////
    public int numDecodings(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Integer,Integer> map = new HashMap<>();
        // We can use if condition to check whether the substring start with "0" or not.
        Set<String> set = new HashSet<>();
        for(int i=1;i<=26;i++)
            set.add(String.valueOf(i));
       return helper(s,0,set,map);
    }

    public int helper(String s, int ind, Set<String> set, Map<Integer,Integer> map){
        int res=0;
        if(ind>=s.length()){
            if(ind==s.length())
                res++;
            return res;
        }

        for(int i=ind;i<=ind+1;i++){
            if(i<s.length()){
                String temp=s.substring(ind,i+1);
                if(set.contains(temp)){
                    if(map.containsKey(i+1)){
                        res+=map.get(i+1);
                        continue;
                    }
                    res+=helper(s,i+1,set,map);
                }
            }
        }
        map.put(ind,res);
        return res;
    }

////////////////////////////Others Best//////////////////////////////
// dp[0] means an empty string will have one way to decode, 
// dp[1] means the way to decode a string of size 1. 
// I then check one digit and two digit combination and save the results along the way. 
// In the end, dp[n] will be the end result.
    // public int numDecodings(String s) {
    //     if (s == null || s.length() == 0) {
    //         return 0;
    //     }
    //     int n = s.length();
    //     int[] dp = new int[n + 1];
    //     dp[0] = 1;
    //     dp[1] = s.charAt(0) != '0' ? 1 : 0;
    //     for (int i = 2; i <= n; i++) {
    //         int first = Integer.valueOf(s.substring(i - 1, i));
    //         int second = Integer.valueOf(s.substring(i - 2, i));
    //         if (first >= 1 && first <= 9) {
    //            dp[i] += dp[i-1];  
    //         }
    //         if (second >= 10 && second <= 26) {
    //             dp[i] += dp[i-2];
    //         }
    //     }
    //     return dp[n];
    // }

    // Explain
    // s="1226"
    // dp{1, 1, 2, 3, 5}
    // i=2// when the length is 2
    //     f=2, substring(1,2)
    //     s=12 substring(0,2)
    //     dp[2]+=dp[1]
    //     dp[2]+=dp[0]
    // i=3
    //     f=2, substring(2,3)
    //     s=22 substring(1,3)
    //     dp[3]+=dp[2]
    //     dp[3]+=dp[1]
    // i=4
    //     f=6, substring(3,4)
    //     s=26 substring(2,4)
    //     dp[4]+=dp[3]
    //     dp[4]+=dp[2]

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       //String s="1226"; //5
       String s="611";
       int ans=tr.numDecodings(s);
       System.out.println(ans);           
    }
}