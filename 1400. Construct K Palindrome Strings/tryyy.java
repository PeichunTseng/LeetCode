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
/////////////////////////////Mine/////////////////////////////
    public boolean canConstruct(String s, int k) {
        int len=s.length();
        if(len<k)
            return false;
        int[] rec=new int[26];
        for(int i=0;i<len;i++)
            rec[s.charAt(i)-'a']++;
        int odd=0;
        for(int i=0;i<rec.length;i++){
            if(rec[i]==0)
                continue;
            if(rec[i]%2==1)
                odd++;
        }
        if(odd>k)
            return false;
        return true;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       String s="annabelle";
       int k=2;
       boolean ans=tr.canConstruct(s,k);
       System.out.println(ans);           
    }
}