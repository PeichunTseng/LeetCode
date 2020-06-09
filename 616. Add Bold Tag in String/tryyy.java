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
    public String addBoldTag(String s, String[] dict) {
        StringBuilder sb = new StringBuilder();
        int start=0;
        int end=-2;
        for(int i=0;i<s.length();i++){
            for(String dic:dict){
                if(s.startsWith(dic,i)){
                    end=Math.max(end,i+dic.length()-1);
                }
            }
            if(i>end){
                if(i==end+1)
                    sb.append("<b>"+s.substring(start,end+1)+"</b>");
                sb.append(s.charAt(i));
                start=i+1;
            }
            
        }
        if(end>=s.length()-1)
            sb.append("<b>"+s.substring(start,end+1)+"</b>");
        return sb.toString();
    }


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        String s="zaaabbcc";
        String[] dict={"aaa","aab","bc"};  //"z<b>aaabbc</b>c"
        String ans=tr.addBoldTag(s,dict);
        System.out.println(ans);         
    }
}