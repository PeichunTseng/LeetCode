import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy{
//////////////////////////////Mine////////////////////////////////////////////
    // int res=0;
    // public int countArrangement(int n) {
    //     int[][] arr = new int[n+1][n+1];
    //     build(arr, n);
    //     for(int i=1;i<=n;i++){
    //         List<Integer> list = new ArrayList<Integer>();
    //         list.add(i);
    //         help(arr,list,2);
    //     }
    //     return res;
    // }
    
    // public void help(int[][] arr, List<Integer> list, int ind){
    //     if(ind==arr.length){
    //         res++;
    //         return;
    //     }
    //     for(int i=1;i<arr.length;i++){
    //         if(list.contains(i))
    //             continue;
    //         if(arr[ind][i]==1){
    //             list.add(i);
    //             help(arr,list,ind+1);
    //             list.remove(list.size()-1);
    //         }
    //     }
    // }
    
    // public void build(int[][] arr, int n){
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=n;j++){
    //             if(j<=i && i%j==0)
    //                 arr[i][j]=1;
    //             else if(j>i && j%i==0)
    //                 arr[i][j]=1;
    //         }
    //     }
    // }
//////////////////////////////Improve////////////////////////////////////////////
    int res=0;
    public int countArrangement(int n) {
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=1;
            help(arr,2);
            arr[i]=0;
        }
        return res;
    }
    
    public void help(int[] arr, int ind){
        if(ind==arr.length){
            res++;
            return;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i] == 1)
                continue;
            if(ind % i == 0 || i % ind == 0){
                arr[i]=1;
                help(arr,ind+1);
                arr[i]=0;
            }
        }
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int n = 2;
       int ans = tr.countArrangement(n);
       System.out.println(ans);
    }
}