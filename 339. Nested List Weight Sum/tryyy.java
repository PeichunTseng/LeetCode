import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
/////////////////////Mine////////////////////////
    public int depthSum(List<NestedInteger> nestedList) {
        int res=0;
        int d=1;
        for(NestedInteger ni:nestedList){
            if(ni.isInteger())
                res+=ni.getInteger()*d;
            else
                res+=helper(ni,d+1);
        }
        return res;
    }
    
    private int helper(NestedInteger nestedList, int weight){
        int res=0;
        for(NestedInteger ni:nestedList.getList()){
            if(ni.isInteger())
                res+=ni.getInteger()*weight;
            else
                res+=helper(ni,weight+1);
        }
        return res;
    }
}