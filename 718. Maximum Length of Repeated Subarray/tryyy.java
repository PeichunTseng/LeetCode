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
///////////////////////Mine Brute Force/////////////////////////
    // public int findLength(int[] A, int[] B) {
        
    //     Map<Integer,List<Integer>> map = new HashMap<>();
    //     int res=0;
        
    //     for(int i=0;i<A.length;i++){
    //         List<Integer> list = map.getOrDefault(A[i], new ArrayList<>());
    //         list.add(i);
    //         map.put(A[i],list);
    //     }
        
    //    // System.out.print(map);
    //     for(int i=0;i<B.length;i++){
    //         if(map.containsKey(B[i])){
    //             List<Integer> list = map.get(B[i]);
    //             int temp=0;
    //             for(int s:list){
    //                 temp=0;
    //                 int index=i;
    //                 for(int j=s;j<A.length;j++){
    //                     if(index<B.length && A[j]==B[index]){
    //                         temp++;
    //                         index++;
    //                     }
    //                     else
    //                         break;
    //                 }
    //                 res=Math.max(res,temp);
    //             }
    //         }
    //     }
    //     return res;
        
    // }


///////////////////////Others better/////////////////////////
    public int findLength(int[] A, int[] B) {
        int res=0;
        int[][] dp=new int[A.length+1][B.length+1];
        for(int i=A.length-1;i>=0;i--){
            for(int j=B.length-1;j>=0;j--){
                if(A[i]==B[j]){
                    dp[i][j]=dp[i+1][j+1]+1;
                    res=Math.max(res,dp[i][j]);
                }
            }
        }
        return res;
    }

    //A: [1,2,3,2,1]
    //B: [3,2,1,4,7]
    // dp:
    //   0 1 2 3 4 5
    // 0     1
    // 1   1
    // 2 3
    // 3   2
    // 4     1
    // 5  


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        //1,1,1,0,0,0,0,0,1,0,1,1,0,0,0,1,1,1,1,1,0,1,1,1,0,0,1,1,0,1,1,1,0,1,1,1,1,0,0,0,1,0,0,1,1,0,1,0,1,0,1,1
        int[] A={0,0,0,0,0,1,1,1,0,1,0,1,1,0,0,0,1,0,0,1,1,0,1,0,1,1,1,0,0,1,0,1,1,0,1,0,1,1,1,1,1,1,1,0,0,0,0,0,1,0,1,1,0,0,0,1,1,1,1,1,0,1,1,1,0,0,1,1,0,1,1,1,0,1,1,1,1,0,0,0,1,0,0,1,1,0,1,0,1,0,1,1,1,1,0,1,0,0,0,1}; 
        int[] B={1,0,1,1,0,1,1,1,0,0,0,0,0,1,0,1,1,0,0,0,1,1,1,1,1,0,1,1,1,0,0,1,1,0,1,1,1,0,1,1,1,1,0,0,0,1,0,0,1,1,0,1,0,1,0,1,1,0,1,1,0,1,0,0,0,1,0,1,0,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,0,0,0,1,1,1,1,1,1,1,1,0};
        int ans=tr.findLength(A,B);
        System.out.println(ans);        
    }
}