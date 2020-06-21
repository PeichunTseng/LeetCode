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
import java.util.Queue; 
import java.util.LinkedList; 

public class tryyy
{

////////////////////////Mine Runtime Error//////////////////////////////////
    // public double myPow(double x, int n) {
    //     if(n==0)
    //         return 1.0;
    //     if(n>0)
    //         return x*myPow(x,n-1);
    //     else
    //         return 1/(x*myPow(x,-n-1));
    // }

////////////////////////Mine Improve//////////////////////////////////    
    public double myPow(double x, int n) {
        if(n==0)
            return 1.0;
        if(n<0)
            return 1/(x*myPow(x,-n-1));
        if(n%2==0)
            return myPow(x*x,n/2);
        else
            return x*myPow(x*x,(n-1)/2); 
    }
    
    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       double x=2.1;
       int n=3;
       double ans =tr.myPow(x,n);
       System.out.println(ans);
    }
}