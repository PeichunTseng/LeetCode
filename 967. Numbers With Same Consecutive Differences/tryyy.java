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
import java.util.Collections;

public class tryyy
{
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] arr=new int[n];

        for(int i=1;i<10;i++){
             arr[0]=i;
             help(arr,list,1,k);
        }
        
        int[] res= new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }
        return res;
    }
    
    public void help(int[] arr, List<Integer> list, int ind, int k){
        if(ind == arr.length){
            list.add(build(arr));
            return;
        }
        if(arr[ind-1]+k < 10){
            arr[ind]=arr[ind-1]+k;
            help(arr,list,ind+1,k);
        }
        if(k!=0 && arr[ind-1]-k >= 0){
            arr[ind]=arr[ind-1]-k;
            help(arr,list,ind+1,k);
        }
    }
    
    public int build(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int a:arr){
            sb.append(a);
        }
        return Integer.valueOf(sb.toString());
    }  

    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       int n=3; 
       int k=7;

       int[] ans=tr.numsSameConsecDiff(n,k);
       for(int a:ans)
        System.out.println(a); 
    }
}