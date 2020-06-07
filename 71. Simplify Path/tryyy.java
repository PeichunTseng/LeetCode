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
/////////////////////////Mine///////////////////////
    public String simplifyPath(String path) {
        String res="";
        Stack<String> stack = new Stack<>();
        String[] arr=path.split("/");
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("") || arr[i].equals("."))
                continue;
            if(arr[i].equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(arr[i]);
        }
        if(stack.isEmpty())
            return "/";
        while(!stack.isEmpty()){
            res="/"+stack.pop()+res;
        }
        return res;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        String path="/a//b////c/d//././/..";
        String ans=tr.simplifyPath(path);
        System.out.println(ans);         
    }
}