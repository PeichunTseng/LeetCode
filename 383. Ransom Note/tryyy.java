import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Collections;


public class tryyy
{
//////////////////////////////Mine///////////////////////////////
    // public boolean canConstruct(String ransomNote, String magazine) {
    //     if(ransomNote.length()==0)
    //       return true;
    //     char[] ran=ransomNote.toCharArray();
    //     char[] mag=magazine.toCharArray();
    //     Arrays.sort(ran);
    //     Arrays.sort(mag);
    //     int start=0;
    //     for(int i=0;i<mag.length;i++){
    //       if(mag[i]==ran[start]){
    //         start++;
    //       }
    //       if(start==ran.length)
    //         return true;
    //     }
    //     return false;
    // }
//////////////////////////////Others improve///////////////////////////////
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr=new int[26];
        for(char ch:magazine.toCharArray()){
          arr[ch-'a']++;
        }
        for(char ch:ransomNote.toCharArray()){
          if(--arr[ch-'a']<0)
            return false;
        }
        return true;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       String ransomNote ="bcjefgecda";
       String magazine ="hfebdiicigfjahdddiahdajhaidbdgjihdbhgfbbccfdfggdcacccaebh";
       boolean ans = tr.canConstruct(ransomNote,magazine);//true
       System.out.println(ans);      
    }

}


