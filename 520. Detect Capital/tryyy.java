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
///////////////////////Mine/////////////////////
    public boolean detectCapitalUse(String word) {
        if(word.length()==0)
            return true;
        if(word.charAt(0)-'a'<26 && word.charAt(0)-'a'>=0)
            return checkSmall(1,word);
        
        if(word.length()>1){
            if(word.charAt(1)-'a'<26 && word.charAt(1)-'a'>=0)
                return checkSmall(2,word);
            else
                return checkCapitals(2,word);
        }
        return true;
        
    }
    
    public boolean checkSmall(int ind, String w){
        for(int i=ind;i<w.length();i++){
            if(w.charAt(i)-'a'>=26 || w.charAt(i)-'a'<0)
                return false;
        }
        return true;
    }
    
    public boolean checkCapitals(int ind, String w){
        for(int i=ind;i<w.length();i++){
            if(w.charAt(i)-'A'>=26 || w.charAt(i)-'A'<0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       String word="FlaG";   
       boolean ans=tr.detectCapitalUse(word);
       System.out.println(ans);      
    }
}