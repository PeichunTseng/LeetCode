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
/////////////////////////////Others/////////////////////////////
    public int numSquares(int n) {
        int[] dp= new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int j=1;
            while(j*j<=i){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
                j++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int n=13;
       int ans=tr.numSquares(n);
       System.out.println(ans);           
    }
}