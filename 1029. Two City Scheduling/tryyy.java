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
import java.util.Random;


public class tryyy
{
///////////////////////Others////////////////////////
    // public int twoCitySchedCost(int[][] costs) {
    //     int len=costs.length/2;
    //     int[][] dp= new int[len+1][len+1];
    //     for(int i=1;i<=len;i++){
    //         dp[i][0]=dp[i-1][0]+costs[i-1][0];
    //         dp[0][i]=dp[0][i-1]+costs[i-1][1];
    //     }

    //     for(int i=1;i<=len;i++){
    //         for(int j=1;j<=len;j++){
    //             dp[i][j]=Math.min(dp[i-1][j]+costs[i+j-1][0],dp[i][j-1]+costs[i+j-1][1]);
    //         }
    //     }
    //     return dp[len][len];
    // }

    // dp[]  the element in dp is index in costs array
    //    0   1    2
    // 0      1    11

    // 1  0   10   110
    //        01   011 

    // 2  00  010  0110 
    //        001  0101




///////////////////////Others Better////////////////////////
    /*
        greedy的思想，这里是根据到AB城市的距离来进行排序，如果到B的距离远远大于A，那么得到的差值越小
        排序就越在前面，越应该选择到A点而不是去B
    */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(a,b)->(a[0]-a[1])-(b[0]-b[1]));
        int len=costs.length;
        int res=0;
        for(int i=0;i<len;i++){
            if(i<len/2)
                res+=costs[i][0];
            else
                res+=costs[i][1];
        }
        return res;
    }
 
    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[][] costs={{10,20},{20,30},{40,50},{50,100}};//140
        int ans=tr.twoCitySchedCost(costs);
        System.out.println(ans);
    }
}