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


public class tryyy{
//////////////////////////Mine////////////////////////
    public int hammingDistance(int x, int y) {
        int res=0;
        while(x!=y){
            if(x%2!=y%2)
                res++;
            x>>=1;
            y>>=1;
        }
        return res;
    }

    public static void main(String[] args) {     
        tryyy tr=new tryyy();
        int x=1;
        int y=4;
        int ans=tr.hammingDistance(x,y);
        System.out.println(ans);
    }
}


