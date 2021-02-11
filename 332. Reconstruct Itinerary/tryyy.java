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

////////////////////Mine 20210211///////////////////////
    public List<String> findItinerary(List<List<String>> tickets) {
        int total = tickets.size()+1;
        Map<String,List<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            List<String> list = map.getOrDefault(ticket.get(0),new ArrayList<>());
            list.add(ticket.get(1));
            map.put(ticket.get(0),list);
        }
        for(String key:map.keySet()){
            Collections.sort(map.get(key));
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        help("JFK",map,res,total);
        return res;
    }
    
    public void help(String start, Map<String,List<String>> map, List<String> res, int total){
        if(!map.containsKey(start) || map.get(start).size()==0){
            return;
        }
        List<String> list = map.get(start);
        int time = list.size();
        for(int i=0;i<time;i++){
            String next=list.remove(0);
            res.add(next);
            help(next,map,res,total);
            if(res.size()==total)
                return;
            list.add(next);
            res.remove(res.size()-1);
        }
    }

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