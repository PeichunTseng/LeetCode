import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
////////////////////////////Mine//////////////////////////////
    public int longestSubstring(String s, int k) {
        int[] arr = new int[26];
        Set<Character> set = new HashSet<>();
        int res = 0;
        
        for(int i = 0; i<s.length(); i++){
            char temp = s.charAt(i);
            arr[temp - 'a']++;
            if(arr[temp - 'a'] >= k) set.add(temp);
        }
        
        
        for(int ch = 1; ch <= 26; ch++){
            int left = 0;
            int numChar = 0;
            int fulfillment = 0;
            Map<Character,Integer> map = new HashMap<>();

            for(int i = 0; i < s.length(); i++){
                char temp = s.charAt(i);

                while(numChar>ch){
                    char pre = s.charAt(left);
                    int total = map.get(pre);
                    if(total == k) fulfillment--;
                    if(total == 1) numChar--;
                    map.put(pre,total-1);
                    left++;
                }
                
                if(!set.contains(temp)){
                    while(left <= i){
                        char pre = s.charAt(left);
                        int total = map.getOrDefault(pre,0);
                        if(total == k) fulfillment--;
                        if(total == 1) numChar--;
                        map.put(pre,total-1);
                        left++;
                    }
                    continue;
                }

                
                int count = map.getOrDefault(temp,0);
                if(count == 0) numChar++;
                if(count == k-1) fulfillment++;
                map.put(temp,count+1);
                if(numChar == fulfillment) res = Math.max(res, i-left+1);
            }        
        }
        return res;
    }
     

    public static void main(String[] args){
        tryyy tr = new tryyy(); 
        //String s = "bbaaacbd";
        String s = "baaabcd";
        int k = 3;
        int ans = tr.longestSubstring(s,k);
        System.out.println(ans);
    }
}