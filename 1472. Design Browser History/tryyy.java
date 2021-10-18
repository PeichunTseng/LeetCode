import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy{
////////////////////////////Mine//////////////////////////////
    private String home;
    private List<String> history;
    private int index;
    private int size;
    public tryyy(String homepage) {
        home = homepage;
        history = new ArrayList<>();
        index = 0;
        size = 1;
        history.add(homepage);
    }
    
    public void visit(String url) {
        if(index == history.size()-1){
            history.add(url);
            index++;
            size++;
        }
        else{
            history.set(++index,url);
            size = index+1;
        }
    }
    
    public String back(int steps) {
        int backPage = index - steps;
        index = Math.max(0, backPage);
        return history.get(index);
    }
    
    public String forward(int steps) {
        int forwardPage = index + steps;
        index = Math.min(size-1, forwardPage);
        return history.get(index);
    }


    public static void main(String[] args){
        tryyy tr = new tryyy("leetcode.com"); 
        tr.visit("google.com");
        tr.visit("facebook.com");
        tr.visit("youtube.com");
        System.out.println(tr.back(1));
        System.out.println(tr.back(1));
        System.out.println(tr.forward(1));
        tr.visit("linkedin.com");
        System.out.println(tr.forward(2));
        System.out.println(tr.back(2));
        System.out.println(tr.back(7));
    }
}