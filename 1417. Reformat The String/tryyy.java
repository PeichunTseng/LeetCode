import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
public class tryyy
{
  ///////////////////////////////自己寫///////////////////////////////
    public String reformat(String s) {
        List<Character> num= new ArrayList<>();
        List<Character> let= new ArrayList<>();
        for(char ch:s.toCharArray()){
            if(Character.isLetter(ch))
                let.add(ch);
            else
                num.add(ch);
        }
        if(Math.abs(num.size()-let.size())>1)
            return "";
        StringBuilder sb = new StringBuilder();
        if(num.size()>let.size()){
            while(num.size()!=0){
                sb.append(num.remove(0));
                if(let.size()!=0)
                    sb.append(let.remove(0));
            }
        }
        else{
            while(let.size()!=0){
                sb.append(let.remove(0));
                if(num.size()!=0)
                    sb.append(num.remove(0));
            }
        }
        return sb.toString();
    }





    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       String s="covid2019";

       String ans =tr.reformat(s);
       System.out.println(ans);
               
    }

}


