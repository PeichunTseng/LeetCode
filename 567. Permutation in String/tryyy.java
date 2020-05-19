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
import java.util.Random;

public class tryyy
{
//////////////////Mine//////////////////
    // public boolean checkInclusion(String s1, String s2) {
    //     int[] rec=new int[26];
    //     for(int i=0;i<s1.length();i++)
    //         rec[s1.charAt(i)-'a']++;
    //     int count=0;
    //     int start=0;
    //     for(int i=0;i<s2.length();i++){
    //         int index=s2.charAt(i)-'a';
    //         rec[index]--;
    //         if(rec[index]>=0)
    //             count++;
    //         if(count==s1.length())
    //             return true;
    //         if(i-start>=s1.length()-1){
    //             if(rec[s2.charAt(start)-'a']>=0)
    //                 count--;
    //             rec[s2.charAt(start)-'a']++;
    //             start++;
    //         }
    //     }
    //     return false;
    // }


////////////////////////Others Better////////////////////////
    public boolean checkInclusion(String s1, String s2){
        int len=s1.length();
        int[] rec = new int[26];

        if(len>s2.length())
            return false;

        for(int i=0;i<len;i++){
            rec[s1.charAt(i)-'a']++;
            rec[s2.charAt(i)-'a']--;
        }

        if(allZero(rec))
            return true;

        for(int i=len;i<s2.length();i++){
            rec[s2.charAt(i-len)-'a']++;
            rec[s2.charAt(i)-'a']--;
            if(allZero(rec))
                return true;
        }
        return false;
    }

    private boolean allZero(int[] rec){
        for(int i=0;i<26;i++)
            if(rec[i]!=0)
                return false;
        return true;
    }


    public static void main(String[] args){
        tryyy tr=new tryyy();
        String s1="ab";
        String s2="eidbaooo";
        boolean ans=tr.checkInclusion(s1,s2);
        System.out.println(ans);
    }
}