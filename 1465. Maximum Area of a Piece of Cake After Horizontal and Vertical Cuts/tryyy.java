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
/////////////////////Mine  Memory Limit Exceeded////////////////////////
    // public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    //     Set<Integer> row = new HashSet<>();
    //     Set<Integer> col = new HashSet<>();
    //     for(int a:horizontalCuts)
    //         row.add(a);
    //     for(int a:verticalCuts)
    //         col.add(a);

    //     int[][] dp=new int[h][w];
    //     dp[0][0]=1;
    //     for(int i=1;i<h;i++){
    //         dp[i][0]=row.contains(i)?1:dp[i-1][0]+1;
    //     }
    //     for(int i=1;i<w;i++){
    //         dp[0][i]=col.contains(i)?1:dp[0][i-1]+1;
    //     }

    //     int res=0;
    //     int max=Integer.MIN_VALUE;
    //     for(int i=1;i<h;i++){
    //         for(int j=1;j<w;j++){
    //             if(row.contains(i) && col.contains(j))
    //                 dp[i][j]=1;
    //             else if(row.contains(i) && !col.contains(j))
    //                 dp[i][j]=dp[i][j-1]+1;
    //             else if(!row.contains(i) && col.contains(j))
    //                 dp[i][j]=dp[i-1][j]+1;
    //             else
    //                 dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+1;
    //             res=Math.max(res,dp[i][j]);
    //         }
    //     }
    //     return res;
    // }

// /////////////////////Mine  Improve  Still Memory Limit Exceeded////////////////////////
//     public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
//         Set<Integer> row = new HashSet<>();
//         Set<Integer> col = new HashSet<>();
//         for(int a:horizontalCuts)
//             row.add(a);
//         for(int a:verticalCuts)
//             col.add(a);
//         col.add(0);

//         int[] dp=new int[w];
//         dp[0]=1;
//         // initailize for row 0
//         for(int i=1;i<w;i++){
//             dp[i]=col.contains(i)?1:dp[i-1]+1;
//         }

//         int res=0;
//         int max=Integer.MIN_VALUE;

//         for(int i=1;i<h;i++){
//             int last=0;
//             for(int j=0;j<w;j++){
//                 int temp=dp[j];
//                 if(row.contains(i) && col.contains(j))
//                     dp[j]=1;
//                 else if(row.contains(i) && !col.contains(j))
//                     dp[j]=dp[j-1]+1;
//                 else if(!row.contains(i) && col.contains(j))
//                     dp[j]=dp[j]+1;
//                 else
//                     dp[j]=dp[j]+dp[j-1]-last+1;

//                 last=temp;
//                 res=Math.max(res,dp[j]);
//             }
//         }
//         return res;
//     }

/////////////////////Others Better////////////////////////
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxRowGap=0;
        int maxColGap=0;
        for(int i=0;i<=horizontalCuts.length;i++){
            if(i==0)
                maxRowGap=Math.max(maxRowGap,horizontalCuts[i]);
            else if(i==horizontalCuts.length)
                maxRowGap=Math.max(maxRowGap,h-horizontalCuts[i-1]);
            else
                maxRowGap=Math.max(maxRowGap,horizontalCuts[i]-horizontalCuts[i-1]);
        }

        for(int i=0;i<=verticalCuts.length;i++){
            if(i==0)
                maxColGap=Math.max(maxColGap,verticalCuts[i]);
            else if(i==verticalCuts.length)
                maxColGap=Math.max(maxColGap,w-verticalCuts[i-1]);
            else
                maxColGap=Math.max(maxColGap,verticalCuts[i]-verticalCuts[i-1]);
        }

        return (int)( (long)maxRowGap*(long)maxColGap % 1000000007);
    }
    

    public static void main(String[] args){
        tryyy tr=new tryyy();
        int h=5;
        int w=4;
        int[] horizontalCuts={3,1};
        int[] verticalCuts={1};
        int ans=tr.maxArea(h,w,horizontalCuts,verticalCuts);
        System.out.println(ans);
    }
}