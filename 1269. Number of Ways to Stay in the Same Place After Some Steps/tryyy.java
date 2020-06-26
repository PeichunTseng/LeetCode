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
////////////////////////Others//////////////////////////////////
    public int numWays(int steps, int arrLen) {
        int MOD = (int)Math.pow(10, 9) + 7;
        if (steps == 0) 
            return 0;
        int position=Math.min(arrLen,steps/2+1);
        int[][] dp= new int[steps+1][position];
        dp[0][0]=1;
        for(int i=1;i<=steps;i++){//the ith step
            for(int j=0;j<=Math.min(position-1,i);j++){// the position j
                dp[i][j]+=dp[i-1][j];
                if(j>0)
                    dp[i][j]=(dp[i][j]+dp[i-1][j-1])%MOD;
                if(j<position-1)
                    dp[i][j]=(dp[i][j]+dp[i-1][j+1])%MOD;
                
            }
        }
        return dp[steps][0];
    }
  //     j
  //     0 1
  // i 0 1 0
  //   1 1 1
  //   2 2 2
  
    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int steps=2; 
       int arrLen=4;
       int ans=tr.numWays(steps,arrLen);
       System.out.println(ans);
    }
}