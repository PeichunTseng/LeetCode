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
///////////////////////Mine/////////////////////////
    public boolean winnerSquareGame(int n) {
        int limit=(int)Math.sqrt(n);
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        int curr=1;
        for(int i=1;i<dp.length;i++){
            if(i==curr*curr && curr<=limit){
                dp[i]=true;
                curr++;
            }
            else{
                int end=(int)Math.sqrt(i);
                for(int j=1;j<=end;j++){
                    if(!dp[i-j*j] || i==j*j){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int n=17;
        boolean ans=tr.winnerSquareGame(n);
        System.out.print(ans);        
    }
}