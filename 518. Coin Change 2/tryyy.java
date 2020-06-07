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
    // int res=0;
    // public int change(int amount, int[] coins) {
    //     helper(0,amount,coins,0);
    //     return res;
    // }
    
    // public void helper(int current, int amount, int[] coins, int index){
    //     if(current>=amount){
    //         if(current==amount)
    //             res++;
    //         return;
    //     }
    //     for(int i=index;i<coins.length;i++){
    //         helper(current+coins[i],amount,coins,i);
    //     }
        
    // }

/////////////////////////Others Better DP///////////////////////
    public int change(int amount, int[] coins) {
        int[] res=new int[amount+1];
        res[0]=1;
        for(int a:coins){
            for(int i=0;i<res.length;i++){
                if(i>=a)
                    res[i]=res[i]+res[i-a];
            }
        }
        return res[amount];
    }




    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int amount=5;
        int[] coins={1,2,5};
        int ans=tr.change(amount,coins);
        System.out.println(ans);         
    }
}