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
//////////////////Mine//////////////////
    // Map<Integer,Integer> map;
    // List<Integer> list;
    // public tryyy() {
    //     map = new HashMap<>();
    //     list = new ArrayList<>();
    // }
    
    // public int next(int price) {
    //     int last=list.size()-1;
    //     int res=1;
    //     while(last>=0 && list.get(last)<=price){
    //         int amount = map.get(last);
    //         res+=amount;
    //         last=last-amount;
    //     }
    //     list.add(price);
    //     map.put(list.size()-1,res);
    //     return res; 
    // }

//////////////////Others Better//////////////////

    Stack<int[]> stack;
    public tryyy() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int res=1;
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            res+=stack.pop()[1];
        }
        stack.push(new int[]{price,res});
        return res; 
    }
 
    public static void main(String[] args){
        tryyy tr=new tryyy();
        System.out.println(tr.next(100));
        System.out.println(tr.next(80));
        System.out.println(tr.next(60));
        System.out.println(tr.next(70));
        System.out.println(tr.next(60));
        System.out.println(tr.next(75));
        System.out.println(tr.next(85));
    }
}