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
////////////////////Others///////////////////////
    public int numTilings(int n) {
        int[] dp = new int[n+1];
        int mod = (int)(Math.pow(10,9)+7);
        if(n < 3) return n;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i = 4; i <= n; i++){
            dp[i] = 2*dp[i-1]%mod + dp[i-3];
            dp[i] %= mod;
        }  
        return dp[n];
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int n = 3;
       int ans=tr.numTilings(n);
       System.out.println(ans);           
    }
}