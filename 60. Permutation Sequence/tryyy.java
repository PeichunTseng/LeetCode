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
////////////////////////Mine//////////////////////////////////
    public String getPermutation(int n, int k) {
        List<String> list =new ArrayList<>();
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<n;i++)
            list.add(String.valueOf(i+1));
        k--;
        int divisor= cal(n)==0 ? 1 : cal(n);
        while(list.size()!=0){
            divisor=divisor/n;
            int temp=k/divisor;
            k=k%divisor;
            sb.append(list.remove(temp));
            n--;
        }
        return sb.toString();
    }

    public int cal(int a){
        int res=1;
        while(a!=1){
            res=res*a;
            a--;
        }
        return res;
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int n=4;
       int k=9;
       String ans=tr.getPermutation(n,k);
       System.out.println(ans);   
    }
}