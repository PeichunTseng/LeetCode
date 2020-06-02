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
import java.util.Random;


public class tryyy
{
///////////////////////Mine Memory Limit////////////////////////
    // List<Integer> list;
    // public tryyy(int[] w) {
    //     list= new ArrayList<>();
    //     for(int i=0;i<w.length;i++){
    //         for(int j=0;j<w[i];j++)
    //             list.add(i);
    //     }
    // }
    
    // public int pickIndex() {
    //     Random rand = new Random();
    //     return list.get(rand.nextInt(list.size()));
    // }

///////////////////////Others Better////////////////////////
    int[] arr;
    int total;
    public tryyy(int[] w) {
        for(int i=1;i<w.length;i++)
            w[i]=w[i]+w[i-1];
        arr=w;
        total=w[w.length-1];
    }
    
    public int pickIndex() {
       Random rand=new Random();
       int target=rand.nextInt(total)+1;
       int l=0;
       int r=arr.length-1;
       while(l<r){
            int mid=l+(r-l)/2;
            if(arr[mid]>target)
                r=mid;
            else if(arr[mid]<target)
                l=mid+1;
            else
                return mid;
       }
       return l;

    }
    
 
    public static void main(String[] args){
        int[] w={1,3};
        tryyy tr=new tryyy(w);
        System.out.println(tr.pickIndex());
        System.out.println(tr.pickIndex());
        System.out.println(tr.pickIndex());
        System.out.println(tr.pickIndex());
        System.out.println(tr.pickIndex());
    }
}