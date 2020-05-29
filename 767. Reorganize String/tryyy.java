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
////////////////////////////Mine//////////////////////////////
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        for(char ch:s.toCharArray())
            arr[ch-'a']++;
        int pre=-1;
        for(int i=0;i<s.length();i++){
            char ch=mostChar(arr,pre);
            if(ch-'a'==pre)
                return "";
            sb.append(ch);
            pre=ch-'a';
        }
        return sb.toString();
    }

    private char mostChar(int[] arr, int pre){
        int temp=0;
        char res=(char)(pre+'a');
        for(int i=0;i<26;i++){
            if(i==pre)
                continue;
            if(arr[i]>temp){
                temp=arr[i];
                res=(char)('a'+i);
            }
        }
        arr[res-'a']--;
        return res;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       String s="aaabc";
       String ans=tr.reorganizeString(s);
       System.out.println(ans);           
    }
}