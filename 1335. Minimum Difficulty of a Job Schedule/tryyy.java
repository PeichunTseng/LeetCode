import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class tryyy
{
    public int minDifficulty(int[] jobDifficulty, int d) {
        int N = jobDifficulty.length;   
        if(N<d) return -1;
        int[][] dp = new int [d][N];
        dp[0][0] = jobDifficulty[0];
        for(int i=1; i<N; i++){
            dp[0][i] = Math.max(dp[0][i-1],jobDifficulty[i]);
        }
        
        for(int day=1; day<d; day++){
            for(int len=day; len<N; len++){
                // currentMax start from the tail
                int currentMax = jobDifficulty[len];
                dp[day][len] = Integer.MAX_VALUE;
                for(int i=len; i>=day;i--){
                    // the max num from the tail(len) to i
                    currentMax = Math.max(currentMax,jobDifficulty[i]);
                    dp[day][len] = Math.min(dp[day][len], dp[day-1][i-1] + currentMax);
                    
                }
            }
        }
        return dp[d-1][N-1];
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[] jobDifficulty={11,111,22,222,33,333,44,444};
       int d=6;
       int ans=tr.minDifficulty(jobDifficulty,d);
       System.out.println(ans);           
    }
}


