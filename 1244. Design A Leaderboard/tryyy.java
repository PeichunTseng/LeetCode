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

public class tryyy
{
////////////////////////////Mine//////////////////////////////
    Map<Integer,Integer> map;
    TreeMap<Integer,List<Integer>> allScore;
    public tryyy() {
        map = new HashMap<>();
        allScore = new TreeMap<>((a,b) -> b-a);     
    }
    
    public void addScore(int playerId, int score) {
        if(map.containsKey(playerId)) {
            score += map.get(playerId);
            reset(playerId);
        }
        map.put(playerId, score);
        List<Integer> list = allScore.getOrDefault(score, new ArrayList<>());
        list.add(playerId);
        allScore.put(score,list);
    }
    
    public int top(int K) {
        int res = 0;
        for(int key : allScore.keySet()){
            List<Integer> list = allScore.get(key);
            int num = Math.min(K, list.size());
            res += key*num;
            K -= num;
            if(K == 0) return res;
        }
        return res;
    }
    
    public void reset(int playerId) {
        int score = map.get(playerId);
        List<Integer> list = allScore.get(score);
        list.remove(Integer.valueOf(playerId));
        map.remove(playerId);
    }


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        tr.addScore(1,73);
        tr.addScore(2,56);
        tr.addScore(3,39);
        tr.addScore(4,51);
        tr.addScore(5,4);
        System.out.println(tr.top(1));
        tr.reset(1);
        tr.reset(2);
        tr.addScore(2,51);
        System.out.println(tr.top(3));
    }
}