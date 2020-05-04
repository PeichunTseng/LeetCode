import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Deque;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Collections;


public class tryyy
{
//////////////////////////////Other///////////////////////////////
  public int slidingPuzzle(int[][] board){
    String goal = "123450";
    String start="";
    int res=0;
    int index=0;
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[i].length;j++){
        start+=String.valueOf(board[i][j]);
        if(board[i][j]==0)
          index=3*i+j;
      }
    }
    Map<String,Integer> map = new HashMap<>();
    map.put(start,index);
    Queue<String> step = new LinkedList<>();
    step.offer(start);
    int[][] direction={{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
    while(!step.isEmpty()){
      int count=step.size();
      for(int i=0;i<count;i++){
        String temp = step.poll();
        int indexOfZero=map.get(temp);
        if(temp.equals(goal))
          return res;
        for(int dir:direction[indexOfZero]){
          String s=swap(temp,indexOfZero,dir);
          if(map.containsKey(s))
            continue;
          step.offer(s);
          map.put(s,dir);
        }
      }
      res++;
    }
    return -1;
      
  }

  public String swap(String s, int x, int y){
    String res="";
    for(int i=0;i<s.length();i++){
      if(i==x)
        res+=s.charAt(y);
      else if(i==y)
        res+=s.charAt(x);
      else
        res+=s.charAt(i);
    }
    return res;
  }

  public static void main(String[] args){
      tryyy tr=new tryyy(); 
      //int[][] board = {{4,1,2},{5,0,3}};
      int[][] board = {{1,2,3},{5,4,0}};
      int ans = tr.slidingPuzzle(board);
      System.out.println (ans);  
  }
}


