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
    public boolean canCross(int[] stones) {
        int goal = stones[stones.length-1];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<stones.length;i++){
            set.add(stones[i]);
            if(i>=3 && stones[i]>2*stones[i-1])
                return false;
        }
        return help(1,goal,1,set);
    }
    
    public boolean help(int s, int t, int step, Set<Integer> set){
        if(s==t)
            return true;
        if(!set.contains(s) || step==0)
            return false;
        return help(s+step+1,t,step+1,set) || help(s+step,t,step,set) || help(s+step-1,t,step-1,set);
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int [] stones = {0,1,3,5,6,8,12,17};
       boolean ans = tr.canCross(stones);
       System.out.println(ans);           
    }
}