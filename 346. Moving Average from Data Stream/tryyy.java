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
    int size;
    List<Integer> list;
    double sum;
    public tryyy(int size) {
        this.size=size;
        list= new ArrayList<>();
        sum=0.0;
    }
    
    public double next(int val) {
        if(list.size()<size){
            list.add(val);
            sum+=val;
            return sum/list.size();
        }
        sum-=list.remove(0);
        sum+=val;
        list.add(val);
        return sum/size;
    }

    public static void main(String[] args) {     
        tryyy tr=new tryyy(3);
        System.out.println(tr.next(1));
        System.out.println(tr.next(10));
        System.out.println(tr.next(3));
        System.out.println(tr.next(5));
    }
}


