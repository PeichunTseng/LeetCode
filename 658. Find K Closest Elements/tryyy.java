import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
////////////////////////////Mine//////////////////////////////
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int[] copy=arr.clone();
        int start=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            copy[i]=Math.abs(arr[i]-x);
            if(i>0)
                copy[i]+=copy[i-1];
        }

        for(int i=0;i<=arr.length-k;i++){
            int temp=0;
            if(i==0)
                temp=copy[i+k-1];
            else
                temp=copy[i+k-1]-copy[i-1];
            if(temp<min){
                start=i;
                min=temp;
            }
        }
        for(int i=start;i<start+k;i++)
            res.add(arr[i]);
        return res;

    }

    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[] arr={0,2,2,3,4,6,7,8,9,9};
        int k=4;
        int x=5;
        List<Integer> ans=tr.findClosestElements(arr,k,x);
        System.out.println(ans);
    }
}