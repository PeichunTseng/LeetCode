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
////////////////////////////Mine//////////////////////////////
    // public String removeDuplicates(String S) {
    //     Stack<Character> stack = new Stack<>();
    //     for(int i=0;i<S.length();i++){
    //         char ch=S.charAt(i);
    //         if(!stack.isEmpty() && stack.peek()==ch)
    //             stack.pop();
    //         else
    //             stack.push(ch);
    //     }
    //     String res = "";
    //     while(!stack.isEmpty())
    //         res=stack.pop()+res;
    //     return res;
    // }

////////////////////////////Others Better//////////////////////////////
    // public String removeDuplicates(String S) {
    //     Stack<Character> stack = new Stack<>();
    //     for(int i=0;i<S.length();i++){
    //         char ch=S.charAt(i);
    //         if(!stack.isEmpty() && stack.peek()==ch)
    //             while(!stack.isEmpty() && stack.peek() == ch)
    //                 stack.pop();
    //         else
    //             stack.push(ch);
    //     }

    //     StringBuilder sb = new StringBuilder();
    //     while(!stack.isEmpty())
    //         sb.append(stack.pop());
    //     return sb.reverse().toString();
    // }
    
////////////////////////////Others Best//////////////////////////////
    public String removeDuplicates(String s) {
        int ind=0;
        int len=s.length();
        char[] arr=s.toCharArray();
        for(int i=0;i<len;i++){
            arr[ind]=arr[i];
            if(ind>0 && arr[ind]==arr[ind-1])
                ind=ind-2;
            ind++;
        }
        return String.valueOf(arr).substring(0,ind);    
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       String S="abbaca";
       String ans=tr.removeDuplicates(S);
       System.out.println(ans);           
    }
}