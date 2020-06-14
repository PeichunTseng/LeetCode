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
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        helper(s,0,0, new StringBuilder());
        return res;
    }
    
    public void helper(String s,int ind, int digit, StringBuilder sb){
        if(s.length()-ind>(4-digit)*3)
            return;
        if(digit==4){
            if(ind==s.length()){
                res.add(sb.toString().substring(0,s.length()+3));
            }
            return;     
        }
        for(int i=ind;i<ind+3;i++){
            if(i<s.length()){
                String temp=s.substring(ind,i+1);
                int len=sb.length();
                if(check(temp)){
                    sb.append(temp+'.');
                    helper(s,ind+temp.length(), digit+1,sb);
                    sb.setLength(len);
                }
            }
        }
    }
    
    public boolean check(String input){
        if(input.startsWith("0") && (!input.equals("0")))
            return false;
        int tem=Integer.valueOf(input);
        if(tem>=0 && tem<=255)
            return true;
        return false;
    }
    

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        String s="25525511135";
        List<String> ans=tr.restoreIpAddresses(s);
        System.out.println(ans);         
    }
}