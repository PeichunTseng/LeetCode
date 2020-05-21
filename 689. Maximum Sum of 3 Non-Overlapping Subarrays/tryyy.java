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
import java.util.Random;

public class tryyy
{
//////////////////Others//////////////////

    //1,2,1,2,6,7,5,1
    public int[] maxSumOfThreeSubarrays(int[] nums, int k){
        int len=nums.length;
        int[] sum=new int[len+1];
        int[] res=new int[3];
        //0 1 3 4 6 12 19 24 25
        for(int i=1;i<sum.length;i++){
            sum[i]=sum[i-1]+nums[i-1];
        }

        // store left index for each subarray that length is k and has maxiun value from left side
        int[] left=new int[len];
        // sum of the first subarray which length equal k 
        int temp=sum[k]-sum[0];
        for(int i=k;i<len;i++){
            if(sum[i+1]-sum[i+1-k]>temp){
                left[i]=i+1-k;
                temp=sum[i+1]-sum[i+1-k];
            }
            else
                left[i]=left[i-1];
        }
        
        // store left index for each subarray that length is k and has maxiun value from right side
        int[] right=new int[len];
        // sum of the first subarray which length equal k //  25-19=6
        temp=sum[len]-sum[len-k];
        right[len-k]=len-k;
        for(int i=len-k-1;i>=0;i--){
            if(sum[i+k]-sum[i]>=temp){
                right[i]=i;
                temp=sum[i+k]-sum[i];
            }
            else
                right[i]=right[i+1];
        }

        int max=Integer.MIN_VALUE;
        // test all of middle subarray, i means the start index in middle subarray
        for(int i=k;i<=len-2*k;i++){
            int l=left[i-1];
            int r=right[i+k];
            int calculate= sum[l+k]-sum[l] + sum[i+k]-sum[i] + sum[r+k]-sum[r];
            if(calculate>max){
                max=calculate;
                res[0]=l;
                res[1]=i;
                res[2]=r;
            }
        }
        return res;
    }
 
    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[] nums={1,2,1,2,6,7,5,1};
        int k=2;
        int[] ans=tr.maxSumOfThreeSubarrays(nums,k);
        for(int a:ans)
            System.out.println(a);
    }
}