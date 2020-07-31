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
/////////////////Mine/////////////////
    // public int climbStairs(int n) {
    //     if(n<=1)
    //         return 1;
    //     int[] arr=new int[n+1];
    //     arr[0]=1;
    //     for(int i=1;i<=n;i++){
    //        if(i-1>=0)
    //            arr[i]+=arr[i-1];
    //         if(i-2>=0)
    //             arr[i]+=arr[i-2];
    //     }
    //     return arr[n];
    // }

/////////////////Mine Improve/////////////////
    public int climbStairs(int n) {
        if(n<=1)
            return 1;
        int a=1;
        int b=1;
        for(int i=2;i<=n;i++){
            int temp=b;
            b=a+b;
            a=temp;
        }
        return b;
    }
            
    public static void main(String[] args){
        tryyy tr=new tryyy();
        long x=tr.climbStairs(35);
        System.out.println(x);
    }
}


