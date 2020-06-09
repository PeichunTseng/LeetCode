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
/////////////////////////Others/////////////////////// 
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        char lastSign='+';
        int num=0;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i)))
                num=10*num+s.charAt(i)-'0';
            if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/' || i==s.length()-1){
                if(lastSign=='+')
                    stack.push(num);

                else if(lastSign=='-')
                    stack.push(-num);

                else if(lastSign=='*')
                    stack.push(stack.pop()*num);

                else if(lastSign=='/')
                    stack.push(stack.pop()/num);
                num=0;
                lastSign=s.charAt(i);
            }
        }
        int res=0;
        while(!stack.isEmpty())
            res+=stack.pop();

        return res;
    }


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        String s="14/3*2"; //8
        int ans=tr.calculate(s);
        System.out.println(ans);         
    }
}