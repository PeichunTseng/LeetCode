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
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
////////////////////////////Mine//////////////////////////////
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->calculate(points[a])-calculate(points[b]));
        for(int i=0;i<points.length;i++){
            pq.offer(i);
        }
        int[][] res= new int[k][2];
        for(int i=0;i<k;i++){
            res[i]=points[pq.poll()];
        }
        return res;
    }
    
    public int calculate(int[] arr){
        return arr[0]*arr[0]+arr[1]*arr[1];
    }

    public static void main(String[] args){
        int [][]a={{3,3},{5,-1},{-2,4}};
        tryyy tr=new tryyy();
        int[][] ans=tr.kClosest(a,1);
        for(int[] arr : ans)
          System.out.println(Arrays.toString(arr));
    }
}