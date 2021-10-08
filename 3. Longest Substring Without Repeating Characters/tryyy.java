import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy{ 
///////////////////////////Mine/////////////////////////////
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++){
            char temp = arr[i];
            if(map.containsKey(temp) && map.get(temp) >= left){
                res = Math.max(res,i - left);
                left = map.get(temp)+1;
            }
            map.put(temp,i); 
            if(i == arr.length-1) res = Math.max(res,i - left + 1);
        }
        return res;
    }
    


    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       String s= "pwwkew";
       int ans =tr.lengthOfLongestSubstring(s);
       System.out.println(ans);
    }
}