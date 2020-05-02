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
//////////////////////////////Mine ///////////////////////////////
    // public int[][] intervalIntersection(int[][] A, int[][] B) {
    //     if(A.length==0||B.length==0)
    //         return new int[][]{};
    //     List<int[]> list = new ArrayList<>();
    //     List<int[]> res = new ArrayList<>();
    //     for(int[] a:A)
    //         list.add(a);
    //     for(int[] b:B)
    //         list.add(b);
    //     Collections.sort(list,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
    //     int end=list.get(0)[1];
    //     for(int i=1;i<list.size();i++){
    //         if(list.get(i)[0]<=end){
    //             int[] tem= new int[2];
    //             tem[0]=list.get(i)[0];
    //             if(list.get(i)[1]<=end){
    //                 tem[1]=list.get(i)[1];
    //             }
    //             else{
    //                 tem[1]=end;
    //                 end=list.get(i)[1];
    //             }
    //             res.add(tem);
    //         }
    //         else
    //             end=list.get(i)[1];
    //     }
    //     int[][] ans=new int[res.size()][2];
    //     for(int i=0;i<ans.length;i++){
    //         ans[i]=res.get(i);
    //     }
    //     return ans;
    // }
//////////////////////////////Others better ///////////////////////////////
    public int[][] intervalIntersection(int[][] A, int[][] B){
        if(A.length==0||B.length==0)
            return new int[][]{};
        List<int[]> res = new ArrayList<>();
        int i=0, j=0;
        int start=0, end=0;
        while(i<A.length && j<B.length){
            start=Math.max(A[i][0],B[j][0]);
            end=Math.min(A[i][1],B[j][1]);
            if(start<=end){
                int[] tem={start,end};
                res.add(tem);
            }
            if(end==A[i][1])
                i++;
            if(end==B[j][1])
                j++;
        }
        return res.toArray(new int[res.size()][2]);
    }


    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       int[][] A = {{0,2},{5,10},{13,23},{24,25}};
       int[][] B = {{1,5},{8,12},{15,24},{25,26}};
       int[][] ans=tr.intervalIntersection(A,B);
       for(int[] arr:ans){
        System.out.print(arr[0]);
        System.out.print(",");  
        System.out.print(arr[1]);  
        System.out.println();   
       }
                
    }

}


