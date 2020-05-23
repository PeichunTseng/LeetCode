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

//binary tree//
public class tryyy
{
///////////////////Mine//////////////////
    // public boolean isMonotonic(int[] A) {
    //     boolean increasing = true;
    //     for(int i=1;i<A.length;i++){
    //         if(A[i]<A[i-1]){
    //             increasing=false;
    //             break;
    //         }
    //     }
    //     if(increasing)
    //         return true;

    //     boolean decreasing = true;
    //     for(int i=1;i<A.length;i++){
    //         if(A[i]>A[i-1]){
    //             decreasing=false;
    //             break;
    //         }
    //     }
    //     return decreasing;
    // }

///////////////////Mine Improve//////////////////
    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for(int i=1;i<A.length;i++){
            if(increasing && A[i]<A[i-1])
                increasing=false;
            if(decreasing && A[i]>A[i-1])
                decreasing=false;
            if(!increasing&&!decreasing)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[] A={1,2,2,3};
       boolean ans=tr.isMonotonic(A);
       System.out.println(ans);           
    }
}