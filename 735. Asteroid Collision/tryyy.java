import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy {

//////////////////////Mine/////////////////////
  public int[] asteroidCollision(int[] asteroids) {

    int ind = 0;
    Stack<Integer> stack = new Stack<>();

    while(ind != asteroids.length){
      int curr = asteroids[ind];
      if(stack.isEmpty() || curr>0 || stack.peek()<0){
        stack.push(curr);
      }
      else{
        while(!stack.isEmpty() && stack.peek()>0 && -curr > stack.peek()){
          stack.pop();
        }
        if(!stack.isEmpty() && stack.peek()>0){
          if(-curr == stack.peek()) stack.pop();
        }
        else{
          stack.push(curr);
        }
      }
      ind++;
    }

    int[] res = new int[stack.size()];
    int index = res.length-1;
    while(!stack.isEmpty()){
      res[index--] = stack.pop();
    }

    return res;
  }

  public static void main(String[] args) {
    tryyy tr = new tryyy(); 
    int[] asteroids = {10,2,-5};
    int[] ans = tr.asteroidCollision(asteroids);
    for(int a : ans)
      System.out.println(a);            
  }
}