import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class tryyy
{
/////////////////////Mine////////////////////
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                int l=j-1;
                int r=i-j;
                dp[i]+=dp[l]*dp[r];
            }
        }
        return dp[n];
    } 

    public static void main(String[] args){
       tryyy tr=new tryyy();
       int a=tr.numTrees(3);
       System.out.println(a);
    }
}


