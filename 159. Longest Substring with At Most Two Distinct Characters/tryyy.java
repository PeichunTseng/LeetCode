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
/////////////////////////////Mine//////////////////////////////
    // public int lengthOfLongestSubstringTwoDistinct(String s) {
    //     Map<Character,Integer> map = new HashMap<>();
    //     int res=0;
    //     int start=0;
    //     for(int i=0;i<s.length();i++){
    //         char temp= s.charAt(i);
    //         map.put(temp,i);
    //         if(map.size()>2){
    //             PriorityQueue<Character> q = new PriorityQueue<>((a,b)->(map.get(a)-map.get(b)));
    //             for(char key:map.keySet())
    //                 q.offer(key);
    //             res=Math.max(res,i-start);
    //             start=map.get(q.peek())+1;
    //             map.remove(q.peek());
    //         }
    //     }
    //     return Math.max(res,s.length()-start); 
    // }

/////////////////////////////Mine Better SlideWindow//////////////////////////////
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int count=0;
        int res=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int temp=map.getOrDefault(ch,0);
            if(temp==0)
                count++;
            map.put(ch,temp+1);
            while(count>2){
                int num=map.get(s.charAt(left))-1;
                if(num==0)
                    count--;
                map.put(s.charAt(left),num);
                left++;
            }
            res=Math.max(res,i-left+1);
        }
        return res;
    }

/////////////////////////////Other Best//////////////////////////////
    // public int lengthOfLongestSubstringTwoDistinct(String s) {
    //     int n = s.length();
        
    //     int[] freq = new int[256];
    //     int uniq = 0;
    //     int res = 0;
    //     for (int i = 0, j = 0; j < n; j++) {
    //         freq[s.charAt(j)]++;
    //         if (freq[s.charAt(j)] == 1) {
    //             uniq++;
    //         }
            
    //         while (uniq > 2) {
    //             char ci = s.charAt(i++);
    //             freq[ci]--;
    //             if (freq[ci] == 0) {
    //                 uniq--;
    //             }
    //         }
    //         res = Math.max(res, j - i + 1);
    //     }
    //     return res;
    // }

    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       String s="abaccc";//4
       int ans=tr.lengthOfLongestSubstringTwoDistinct(s);
       System.out.println(ans);           
    }

}