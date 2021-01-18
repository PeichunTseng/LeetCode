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
import java.util.PriorityQueue;

public class tryyy
{
///////////////////////Mine/////////////////////
    // public int[] advantageCount(int[] A, int[] B) {
    //     int[] res = new int[A.length];
    //     List<Integer> list = new ArrayList<>();
    //     for(int a: A){
    //         list.add(a);
    //     }
    //     Collections.sort(list);
    //     for(int i=0;i<B.length;i++){
    //         res[i] = help(list,B[i]);
    //     }
    //     return res;
    // }
    
    // public int help(List<Integer> list, int b){
    //     int l=0;
    //     int r=list.size()-1;

    //     while(l<r){
    //         int mid=(r+l)/2;
    //         if(list.get(mid)<=b){
    //             l=mid+1;
    //         }
    //         else{
    //             if(mid>0 && list.get(mid-1)<=b)
    //                 return list.remove(mid);
    //             else{
    //                 r=mid-1;
    //             }
    //         }
    //     }
    //     if(list.get(l)<=b)
    //         return list.remove(0);
    //     return list.remove(l);
    // }
///////////////////////Others Better/////////////////////
    public int[] advantageCount(int[] A, int[] B) {
        int[] res = new int[A.length];
        Arrays.sort(A);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<B.length;i++){
          pq.offer(new int[]{i, B[i]});
        }
        int r = A.length-1;
        int l = 0;
        while(!pq.isEmpty()){
          int[] temp = pq.poll();
          int ind = temp[0];
          int val = temp[1];
          res[ind] = A[r]>val ? A[r--] : A[l++];
        }
        return res;
    }

    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       int[] A = {12,24,8,32}; 
       int[] B = {13,25,32,11};

       int[] ans=tr.advantageCount(A,B);
       for(int a:ans)
        System.out.println(a); 
    }
}
