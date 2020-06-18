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
    public boolean canReach(int[] arr, int start) {
        if(arr[start]==0)
            return true;
        int d=arr[start];
        arr[start]=-1;
        int len=arr.length;
        if(start+d<len){
            if(arr[start+d]!=-1 && canReach(arr,start+d))
                return true;
        }
        if(start-d>=0){
            if(arr[start-d]!=-1 && canReach(arr,start-d))
                return true;
        }
        return false;
    }


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] arr={4,2,3,0,3,1,2};
        int start=5;
        boolean ans=tr.canReach(arr,start);
        System.out.println(ans);           
    }
}