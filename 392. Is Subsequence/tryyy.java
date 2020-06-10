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
/////////////////////////Mine/////////////////////// 
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j))
                i++;
            j++;
        }
        return i==s.length();
    }


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        String s="abc";
        String t="ahbgdc";
        boolean ans=tr.isSubsequence(s,t);
        System.out.println(ans);         
    }
}