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
/////////////////////////Mine Time Limit///////////////////////
    // int res=Integer.MAX_VALUE;
    // public int coinChange(int[] coins, int amount){
    //     Arrays.sort(coins);
    //     List<Integer> list=new ArrayList<>();
    //     if(helper(coins,amount,list))
    //         res=Math.min(res,list.size());
    //     return res==Integer.MAX_VALUE ? -1 : res;

    // }

    // public boolean helper(int[] coins, int amount, List<Integer> list){
    //     if(amount<=0){
    //         if(amount==0)
    //             return true;
    //         return false;
    //     }

    //     for(int i=coins.length-1;i>=0;i--){
    //         list.add(coins[i]);
    //         if(helper(coins,amount-coins[i],list))
    //             res=Math.min(res,list.size());;
    //         list.remove(list.size()-1);
    //     }
    //     return false;
    // }

///////////////////////Mine Improve DP///////////////////////
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int[] res=new int[amount+1];
        Arrays.fill(res,amount+1);
        for(int a:coins){
            for(int i=0;i<res.length;i++){
                if(i>=a){
                    if(i==a)
                        res[i]=1;
                    else
                        res[i]=Math.min(res[i],res[i-a]+1);
                }
            }
        }
        return res[amount]==amount+1 ? -1 : res[amount];
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int amount=6249;
        int[] coins={186,419,83,408};//20
        int ans=tr.coinChange(coins,amount);
        System.out.println(ans);         
    }
}