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
//////////////////////////Mine Time Limit////////////////////////
    // public int findSubstringInWraproundString(String p) {
    //     int res=0;
    //     Set<String> set= new HashSet<>();
    //     for(int i=0;i<p.length();i++){
    //         for(int j=i;j<p.length();j++){
    //             if(j==i)
    //                 set.add(p.substring(i,i+1));
    //             else{
    //                 String temp=p.substring(i,j+1);
    //                 if(check(temp.charAt(temp.length()-2),temp.charAt(temp.length()-1)))
    //                     set.add(temp);
    //                 else
    //                     break;
    //             }
    //         }
    //     }
    //     return set.size();
    // }
    
    // public boolean check(char first, char sec){
    //     if(first=='z')
    //         return sec=='a';
    //     return sec-first==1;
    // }
//////////////////////////Others Better////////////////////////
    public int findSubstringInWraproundString(String p){
        int[] arr=new int[26];
        int max=1;
        int res=0;
        for(int i=0;i<p.length();i++){
            if(i>0 && check(p.charAt(i-1),p.charAt(i))){
                max++;
            }
            else
                max=1;
            arr[p.charAt(i)-'a']=Math.max(max,arr[p.charAt(i)-'a']);
        }
        for(int a:arr)
            res+=a;
        return res;
    }
    
    public boolean check(char first, char sec){
        if(first=='z')
            return sec=='a';
        return sec-first==1;
    }

    public static void main(String[] args) {     
        tryyy tr=new tryyy();
        String p="zab";
        int ans=tr.findSubstringInWraproundString(p);
        System.out.println(ans);
    }
}


