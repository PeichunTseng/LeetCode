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

public class tryyy{
//////////////////////////Mine////////////////////////////////
    // public int minDeletions(String s) {
    //     Map<Character, Integer> map = new HashMap<>();
    //     int maxNum = 0;
    //     int res = 0;
        
    //     for(char ch : s.toCharArray()){
    //         int count = map.getOrDefault(ch, 0);
    //         maxNum = Math.max(maxNum,count+1);
    //         map.put(ch, count+1);
    //     }
    //     int[] arr = new int[maxNum+1];
        
    //     for(char key : map.keySet()){
    //         arr[map.get(key)]++;
    //     }
    //     for(int i = arr.length-1; i >0; i--){
    //         int temp =arr[i];
    //         if(temp > 1){
    //             res += temp-1;
    //             arr[i-1] += temp-1;
    //         }

    //     }
    //     return res;
    // }

//////////////////////////Others////////////////////////////////
    public int minDeletions(String s) {
        int[] arr = new int[26];
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        
        for(int i = 25; i >= 0; i--){
            int count = arr[i];
            while(count!=0 && set.contains(count)){
                res++;
                count--;
            }
            set.add(count);
        }
        
        return res;
    }

    public static void main(String[] args){
       tryyy tr = new tryyy(); 
       String s = "aaabbbcc";
       int ans = tr.minDeletions(s);
       System.out.println(ans);           
    }
}