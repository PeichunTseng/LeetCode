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
//////////////////////////Others////////////////////////
    // public List<List<Integer>> getFactors(int n) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     helper(res,new ArrayList<>(),2,n);
    //     return res;
    // }
    
    // public void helper(List<List<Integer>> res, List<Integer> list, int start, int num){
    //     if(num<=1){
    //         if(list.size()>1)
    //             res.add(new ArrayList<Integer>(list));
    //         return;
    //     }
    //     for(int i=start;i<=num;i++){
    //         if(num%i==0){
    //             list.add(i);
    //             helper(res,list,i,num/i);
    //             list.remove(list.size()-1);
    //         }
    //     }
    // }

//////////////////////////Others Improve////////////////////////
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),2,n);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int start, int num){
        List<Integer> temp=new ArrayList<>(list);
        if(temp.size()>0){
            temp.add(num);
            res.add(temp);
        }
            
        int bound=(int)Math.sqrt(num);
        for(int i=start;i<=bound;i++){
            if(num%i==0){
                list.add(i);
                helper(res,list,i,num/i);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {     
        tryyy tr=new tryyy();
        int n=12;
        List<List<Integer>> ans=tr.getFactors(n);
        for(List<Integer> l:ans)
            System.out.println(l);
    }
}


