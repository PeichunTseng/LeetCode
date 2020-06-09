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
/////////////////////////Mine/////////////////////// 
    public boolean isPowerOfTwo(int n) {
        while(n>1){
            if(n%2!=0)
                return false;
            n=n/2;
        }
        return n==1?true:false;
    }


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int n=218;
        boolean ans=tr.isPowerOfTwo(n);
        System.out.println(ans);         
    }
}