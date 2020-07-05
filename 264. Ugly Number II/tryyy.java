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


public class tryyy{
//////////////////////////Others////////////////////////
    public int nthUglyNumber(int n) {
        int[] dp=new int[n];
        dp[0]=1;
        int index2=0,index3=0,index5=0;
        int num2=2,num3=3,num5=5;
        for(int i=1;i<n;i++){
            int min=Math.min(num2,Math.min(num3,num5));
            dp[i]=min;
            if(min==num2)
                num2=2*dp[++index2];
            if(min==num3)
                num3=3*dp[++index3];
            if(min==num5)
                num5=5*dp[++index5];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {     
        tryyy tr=new tryyy();
        int n=10;
        int ans=tr.nthUglyNumber(n);
        System.out.println(ans);
    }
}


