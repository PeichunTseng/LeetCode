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
///////////////////////Others/////////////////////
    public int maxProfit(int[] prices) {
        if(prices.length<=1)
            return 0;
        int[] s0=new int[2];// rest
        int[] s1=new int[2];// after buy
        int[] s2=new int[2];// after sell
        s0[0]=0;
        s1[0]=-prices[0];
        s2[0]=Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
            int pre=(i-1)%2;
            int index=i%2;
            s0[index]=Math.max(s0[pre],s2[pre]);
            s1[index]=Math.max(s0[pre]-prices[i],s1[pre]);
            s2[index]=s1[pre]+prices[i];
        }
        int finalIndex=(prices.length-1)%2;
        return Math.max(s0[finalIndex],s2[finalIndex]);
        
    }

    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       int[] prices={1,2,3,0,2};    
       int ans=tr.maxProfit(prices);
       System.out.println(ans1);      
    }
}