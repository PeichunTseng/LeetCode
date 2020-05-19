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
    public String minWindow(String s, String t) {
        String res="";
        //character and it's frequency in t
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        // To store the index in s which is included in t
        List<Integer> indice= new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                indice.add(i);
            }
        }

        int TargetLen=t.length();
        int count=0;
        int leftIndex=0;
        // i is the right boundry
        for(int i=0;i<indice.size();i++){

            int indexS=indice.get(i);
            char ch=s.charAt(indexS);
            int amount=map.get(ch);
            if(amount>0)
                count++;
            map.put(ch,amount-1);
            // if find the substring that include all character in t, move the left boundry
            while(count==TargetLen && leftIndex<=i){
                int leftIndexS=indice.get(leftIndex);
                // if the length of substring is shorter than current answer, update it.
                if(res.length()==0 || indexS-leftIndexS+1<res.length())
                    res=s.substring(leftIndexS,indexS+1);

                char temp=s.charAt(leftIndexS);
                int tempAmount=map.get(temp);
                if(tempAmount==0)
                    count--;
                map.put(temp,tempAmount+1);
                leftIndex++;
            }
        }
        return res;  
    }
 
    public static void main(String[] args){
        tryyy tr=new tryyy();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans=tr.minWindow(s,t);
        System.out.println(ans);
    }
}