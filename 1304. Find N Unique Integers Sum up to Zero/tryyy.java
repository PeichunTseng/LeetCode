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

public class tryyy{
//////////////////////////Mine////////////////////////////////
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int ind = 0;
     
        for(int i = -n/2; i <= n/2 ; i++){
            if(i == 0) continue;
            res[ind++] = i;
        }
        
        if(n%2 != 0) res[ind] = 0;
        return res;
    }

    public static void main(String[] args){
       tryyy tr = new tryyy(); 
       int n = 5;
       int[] ans = tr.sumZero(n);
       for(int a : ans)
        System.out.println(a);           
    }
}