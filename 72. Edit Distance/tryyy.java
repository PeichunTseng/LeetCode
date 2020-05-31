import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
////////////////////////////Others//////////////////////////////
    public int minDistance(String word1, String word2) {
        int row=word1.length();
        int col=word2.length();
        int[][] dp=new int[row+1][col+1];
        for(int i=0;i<=row;i++)
            dp[i][0]=i;
        for(int j=0;j<=col;j++)
            dp[0][j]=j;

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }
        return dp[row][col];
        
    }

    public static void main(String[] args){
        tryyy tr=new tryyy();
        String word1="horse";
        String word2="ros";
        int ans=tr.minDistance(word1,word2);
        System.out.println(ans);
    }
}