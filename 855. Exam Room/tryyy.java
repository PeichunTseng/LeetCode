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
////////////////////////Mine//////////////////////////////////
    List<Integer> list;
    int total;
    
    public tryyy(int N) {
        list=new ArrayList<>();
        total=N;
    }
    
    public int seat() {
        if(list.size()==0){
            list.add(0);
            return 0;
        }
        int len=list.size();
        int dis=0;
        for(int i=0;i<len;i++){
            if(i==0)
                dis=Math.max(dis,list.get(i));
            if(i==len-1)
                dis=Math.max(dis,total-list.get(i)-1);
            else{
                dis=Math.max(dis,(list.get(i+1)-list.get(i))/2);
            }
        }
        
        int res=0;
        for(int i=0;i<len;i++){
            if(i==0)
                if(dis==list.get(i)){
                    list.add(0,0);
                    return 0;
                }
            if(i==len-1 && dis==total-list.get(i)-1){
                list.add(total-1);
                return total-1;
            }
            else{
                if(dis==(list.get(i+1)-list.get(i))/2){
                    list.add(i+1,(list.get(i+1)+list.get(i))/2);
                    return list.get(i+1);
                }
            }
        }
        return res;
    }
    
    public void leave(int p) {
        list.remove(Integer.valueOf(p));
    }
    


    public static void main(String[] args){
       tryyy tr=new tryyy(10); 
       System.out.println(tr.seat());
       System.out.println(tr.seat());
       System.out.println(tr.seat());
       System.out.println(tr.seat());
       tr.leave(4);
       System.out.println(tr.seat());
    }
}