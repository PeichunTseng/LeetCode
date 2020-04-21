import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
//import java.util.Entry;
//import java.util.*;



public class tryyy
{
    
    // public int[] productExceptSelf(int[] nums) 
    // {
    //     int[] res=new int[nums.length];
    //     for(int i=0;i<res.length;i++)
    //     {
    //         res[i]=1;
    //     }
    //     for(int i=0;i<res.length;i++)
    //     {
    //         //int[] tem= nums;
    //         for(int j=0;j<res.length;j++)
    //         {
            
    //         if(j==i)
    //              res[i] *=1;
    //         else
    //             res[i] *=nums[j];
    //         }
    //     }
        
    //     return res;
        
    // }

    
//////////////////////不用除法的///////////////////////////
    // public int[] productExceptSelf(int[] nums){
    //     int[] ans = new int[nums.length];
    //     ans[0]=1;
    //     for(int i=1;i<ans.length;i++){
    //         ans[i]=ans[i-1]*nums[i-1];
    //     }

    //     int R=1;
    //     for(int i=ans.length-1;i>=0;i--){
    //         ans[i]=R*ans[i];
    //         R=R*nums[i];
    //     }
    //     return ans;
    // }


    public int[] productExceptSelf(int[] nums) 
    {
       int[] output = new int[nums.length];
        int product = 1, zero = 0;
        for (int i = 0; i < nums.length; i++) 
        {
            if (nums[i] == 0) 
                zero++;
            else 
                product *= nums[i];
        }

        if (zero == 0) 
        {
            for (int i = 0; i < nums.length; i++) 
            {
                output[i] = product / nums[i];
            }
        } 
        else if (zero == 1) 
        {
            for (int i = 0; i < nums.length; i++) 
            {
                if (nums[i] == 0) 
                {
                    output[i] = product;
                    break;
                }
            }
        }
        return output;
        
    }



    public static void main(String[] args) 
    {
       tryyy tr=new tryyy();
       int[] a={1,2,3,4};
       int[] b=tr.productExceptSelf(a);
       for (int i = 0; i < b.length; i++) 
          System.out.println(b[i]);
             

    }



}


