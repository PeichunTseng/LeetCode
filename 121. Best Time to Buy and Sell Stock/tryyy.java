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



public class tryyy
{
//////////////////Time complexity : O(n^2)//////////////////
//////////////////Space complexity : O(1)//////////////////
  // public int maxProfit(int[] prices) 
  // {
  //   int max=0;
  //   for(int i=0;i<prices.length;i++)
  //   {
  //     int buy=prices[i];
  //     int sell=0;
  //     for(int j=i+1;j<prices.length;j++)
  //     {
  //       sell=Math.max(sell,prices[j]);
  //     }

  //     max=Math.max(max,sell-buy);

  //   }
  //   return max;
          
  // }

//////////////////Time complexity : O(n)//////////////////
//////////////////Space complexity : O(1)//////////////////
    public int maxProfit(int prices[]) {
      int min= Integer.MAX_VALUE;
      int maxprofit=0;
      for(int i=0;i<prices.length;i++){
        if(prices[i]<min)
          min=prices[i];
        else if(prices[i]-min>maxprofit)
          maxprofit=prices[i]-min;
      }
      return maxprofit;
    }

//////////////////Mine 2021903//////////////////
    public int maxProfit(int[] prices) {
        int res = 0;
        int buy = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            buy = Math.min(buy,prices[i]);
            if(prices[i]-buy > 0){
                res = Math.max(res,prices[i]-buy);
            }
        }
        return res;
    }

    public static void main(String[] args) {
       int[] s ={7,1,5,3,6,4};
       tryyy tr = new tryyy();
       System.out.println(tr.maxProfit(s));
 
    }
}