import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class tryyy
{
  public int evalRPN(String[] tokens) {
      int a,b;
      Stack<Integer> stack = new Stack<Integer>();
      for (String s : tokens) {
        if(s.equals("+")) {
          stack.add(stack.pop()+stack.pop());
        }
        else if(s.equals("/")) {
          b = stack.pop();
          a = stack.pop();
          stack.add(a / b);
        }
        else if(s.equals("*")) {
          stack.add(stack.pop() * stack.pop());
        }
        else if(s.equals("-")) {
          b = stack.pop();
          a = stack.pop();
          stack.add(a - b);
        }
        else {
          stack.add(Integer.valueOf(s));
        }
      } 
      return stack.pop();
  }


  public static void main(String[] args) 
  {
    tryyy tr=new tryyy();
    String[] tokens = {"2", "1", "+", "3", "*"};
    //String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    int ans=tr.evalRPN(tokens);
    System.out.println(ans);
  }

}
