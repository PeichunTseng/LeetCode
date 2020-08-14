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
///////////////////////Others/////////////////////
    Queue<String> q;
    public tryyy(String characters, int combinationLength) {
        q=new LinkedList<>();
        helper(characters,0,"",combinationLength);
    }
    
    public void helper(String s, int ind, String temp, int remains){
        if(remains==0){
            q.offer(temp);
            return;
        }
        for(int i=ind;i<s.length();i++){
            helper(s,i+1,temp+s.charAt(i),remains-1);
        }
    }
    
    public String next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }


    public static void main(String[] args) {
        String characters="abc"; 
        int combinationLength=2;
        tryyy iterator=new tryyy(characters, combinationLength); 
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext()); 
        System.out.println(iterator.next()); 
        System.out.println(iterator.hasNext()); 
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}