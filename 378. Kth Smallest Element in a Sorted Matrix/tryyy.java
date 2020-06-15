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
//////////////////////////Mine////////////////////////////////
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pq.offer(matrix[i][j]);
                if(pq.size()>k)
                    pq.poll();
            }
        }
        return pq.poll();
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[][] matrix={{1,5,9},
                       {10,11,13},
                       {12,13,15}};
       int k=8;
       int ans=tr.kthSmallest(matrix,k);
       System.out.println(ans);           
    }
}