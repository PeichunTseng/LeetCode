import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
////////////////////////////Mine////////////////////////////
    // public int maxVowels(String s, int k) {
    //     char[] arr={'a','e','i','o','u'};
    //     Set<Character> set = new HashSet<>();
    //     for(char ch:arr)
    //         set.add(ch);
    //     int count=0;
    //     int res=0;
    //     char[] temp=s.toCharArray();
    //     for(int i=0;i<temp.length;i++){
    //         if(i<k){
    //             if(set.contains(temp[i]))
    //                 count++;
    //         }
    //         else{
    //             if(set.contains(temp[i-k]))
    //                 count--;
    //             if(set.contains(temp[i]))
    //                 count++;
    //         }
    //         res=Math.max(res,count);
    //         if(res==k)
    //             return res;
    //     }
    //     return res;    
    // }
////////////////////////////Mine Improve////////////////////////////
    public int maxVowels(String s, int k) {
        char[] arr={'a','e','i','o','u'};
        Set<Character> set = new HashSet<>();
        for(char ch:arr)
            set.add(ch);
        int count=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i)))
                count++;
            if(i>=k && set.contains(s.charAt(i-k))){
                count--;
            }
            res=Math.max(res,count);
            if(res==k)
                return res;
        }
        return res;
    }

    public static void main(String[] args){
      tryyy tr=new tryyy();
      String s="abciiidef";
      int k=3;
      int ans=tr.maxVowels(s,k);
      System.out.println(ans);        
    }
}