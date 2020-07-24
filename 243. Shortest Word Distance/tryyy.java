import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy{
///////////////////////////////Mine////////////////////////////
    public int shortestDistance(String[] words, String word1, String word2) {
        Set<String> set = new HashSet<>();
        set.add(word1);
        set.add(word2);
        int preIndex=-1;
        String preS="";
        int res=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            String temp=words[i];
            if(set.contains(temp)){
                if(preIndex!=-1 && !preS.equals(temp)){
                    res=Math.min(res,i-preIndex);
                }
                preS=temp;
                preIndex=i;
            }
        }
        return res;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        String[] words={"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";
        int res=tr.shortestDistance(words,word1,word2);
        System.out.println(res);           
    }
}