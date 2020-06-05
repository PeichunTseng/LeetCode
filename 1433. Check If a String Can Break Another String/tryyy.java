import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;
import java.util.Random;


public class tryyy
{
///////////////////////Mine////////////////////////
    // public boolean checkIfCanBreak(String s1, String s2) {
    //     int len=s1.length();
    //     int[] a = new int[len];
    //     int[] b = new int[len];
    //     for(int i=0;i<len;i++){
    //         a[i]=s1.charAt(i)-'a';
    //         b[i]=s2.charAt(i)-'a';
    //     }
    //     Arrays.sort(a);
    //     Arrays.sort(b);
    //     return help(a,b) || help(b,a);
    // }
    
    // public boolean help(int[] a, int[] b){
    //     for(int i=0;i<a.length;i++)
    //         if(a[i]<b[i])
    //             return false;
    //     return true;
    // }

///////////////////////Mine Better////////////////////////
    public boolean checkIfCanBreak(String s1, String s2) {
        int len=s1.length();
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i=0;i<len;i++){
            a[s1.charAt(i)-'a']++;
            b[s2.charAt(i)-'a']++;
        }
        
        return help(a.clone(),b.clone(),len) || help(b,a,len);
    }
      
    public boolean help(int[] a, int[] b, int count){
        int l=0;
        int r=0;
        while(count>0){
            while(a[l]==0)
                l++;
            while(b[r]==0)
                r++;
            if(l<r)
                return false;
            a[l]--;
            b[r]--;
            count--;
        }
        return true;
    }    

 
    public static void main(String[] args){
        tryyy tr=new tryyy();
        String s1="abe";
        String s2="acd";
        boolean ans=tr.checkIfCanBreak(s1,s2);
        System.out.println(ans);
    }
}