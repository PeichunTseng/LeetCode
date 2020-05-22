import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math; 
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.PriorityQueue; 
import java.util.Random;

public class tryyy
{
//////////////////Others//////////////////
    // public int partitionDisjoint(int[] A) {
    //     int len=A.length;
    //     int[] left=new int[len];
    //     int[] right=new int[len];

    //     int temp=A[0];
    //     for (int i=0;i<len;i++) {
    //         temp=Math.max(temp, A[i]);
    //         left[i]=temp;
    //     }

    //     temp=A[len-1];
    //     for (int i=len-1;i>= 0;i--) {
    //         temp=Math.min(temp, A[i]);
    //         right[i]=temp;
    //     }

    //     for (int i=1;i<len; i++)
    //         if (left[i-1]<=right[i])
    //             return i;

    //     throw null;
    // }

//////////////////Others Improve//////////////////
    public int partitionDisjoint(int[] A) {
        int partitionIdx = 1;
        int currMax = A[0];
        int prevMax = A[0];
        for(int i = 1; i < A.length; i++) {
            if(A[i] < prevMax) {
                partitionIdx = i + 1;
                prevMax = currMax;
            } 
            else {
                currMax = Math.max(currMax, A[i]);
            }
        }
        return partitionIdx;
    }

 
    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[] A={5,0,3,8,6};
        int ans=tr.partitionDisjoint(A);
        System.out.println(ans);
    }
}