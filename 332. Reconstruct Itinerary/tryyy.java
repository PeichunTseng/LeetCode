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
////////////////////Others///////////////////////
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String,PriorityQueue<String>> map = new HashMap<>();
        for(List<String> l:tickets){
            map.putIfAbsent(l.get(0),new PriorityQueue<>());
            map.get(l.get(0)).offer(l.get(1));
        }
        Stack<String> stack=new Stack<>();
        stack.push("JFK");
        while(!stack.isEmpty()){
            while(map.containsKey(stack.peek())&&map.get(stack.peek()).size()!=0){
                stack.push(map.get(stack.peek()).poll());
            }
            res.add(0,stack.pop());
        }
        return res;
    }
    // JFK   KUL NRT
    // NRT   JFK   

    // stack JFK NRT JFK  //KUL 
    // route JFK KUL
    //Ans [JFK, NRT, JFK, KUL]

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       String[][] arr={{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
       List<List<String>> tickets=new ArrayList<>();
       for(String[] a:arr)
            tickets.add(Arrays.asList(a));
       List<String> ans=tr.findItinerary(tickets);
       System.out.println(ans);           
    }
}