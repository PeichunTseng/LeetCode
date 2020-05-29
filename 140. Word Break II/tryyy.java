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
////////////////////////////Mine Time Limit//////////////////////////////
    // public List<String> wordBreak(String s, List<String> wordDict){
    //     List<String> res= new ArrayList<>();
    //     StringBuilder sb = new StringBuilder();
    //     helper(s,wordDict,sb,res,0);
    //     return res;
    // }
    // public void helper(String s, List<String> wordDict, StringBuilder sb, List<String> res, int ind){
    //     if(ind==s.length()){
    //         res.add(sb.toString().trim());
    //         return;
    //     }
    //     String temp=s.substring(ind);     
    //     int len=sb.length();
    //     for(String str:wordDict){
    //         if(temp.startsWith(str)){
    //             sb.append(str+" ");
    //             helper(s,wordDict,sb,res,ind+str.length());
    //             sb.setLength(len);
    //         }
    //     }
    //     return;
    // }
////////////////////////////Others//////////////////////////////
    public List<String> wordBreak(String s, List<String> wordDict){
        Map<String,List<String>> map = new HashMap<>();
        return helper(s,wordDict,map);
    }
    public List<String> helper(String s, List<String> wordDict,  Map<String,List<String>> map){
        if(map.containsKey(s))
            return map.get(s);
        List<String> res = new ArrayList<>();
        for(String str:wordDict){
            if(s.startsWith(str)){
                String next=s.substring(str.length());
                if(next.length()==0)
                    res.add(str);
                else{
                    for(String ss:helper(next,wordDict,map))
                        res.add(str+" "+ss);
                }
            }
        }
        map.put(s,res);
        return res;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
       String[] arr={"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
       List<String> wordDict= new ArrayList<>();
       for(String str:arr)
        wordDict.add(str);
       List<String> ans=tr.wordBreak(s,wordDict);
       System.out.println(ans);           
    }
}