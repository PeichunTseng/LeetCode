import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math; 
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.PriorityQueue; 
import java.util.Queue; 
import java.util.LinkedList; 


public class tryyy{
//////////////////////////Mine////////////////////////
    public int balancedString(String s) {
        int len=s.length();
        len=len/4;
        Map<Character,Integer> map = new HashMap<>();
        char[] arr={'Q', 'W', 'E' , 'R'};
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);  
        }
        for(char key:arr){
            if(!map.containsKey(key))
                continue;
            if(map.get(key)>len){
                map.put(key,map.get(key)-len);
            }
            else
                map.remove(key);
        }
        
        int res=Integer.MAX_VALUE;
        int l=0;
        int size=map.keySet().size();
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1); 
                if(map.get(ch)==0)
                    count++;
            }
            if(count==size)
                res=Math.min(res,i-l+1);
            while(count==size||(l<s.length() &&!map.containsKey(s.charAt(l))) || (l<s.length() &&map.get(s.charAt(l))<0)){
                if(l>=s.length())
                    break;
                char temp=s.charAt(l);
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1); 
                    if(map.get(temp)>0)
                        count--;
                }
                l++;
            }
        }
        return res<=0?0:res;
    }

//////////////////////////Others Better////////////////////////
    public int balancedString(String s){
        int len=s.length();
        len=len/4;
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'A']++;
        }

        int l=0;
        int res=s.length();
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'A']--;
            while(l<s.length() && arr['Q'-'A']<=len && arr['W'-'A']<=len && arr['E'-'A']<=len && arr['R'-'A']<=len){
                res=Math.min(res,i-l+1);
                arr[s.charAt(l)-'A']++;
                l++;
            }
        }
        return res;
    }
    public static void main(String[] args) {     
        tryyy tr=new tryyy();
        String s="WQWRQQQW";
        int ans=tr.balancedString(s);
        System.out.println(ans);
    }
}


