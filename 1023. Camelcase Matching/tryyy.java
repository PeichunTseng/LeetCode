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
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res= new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            res.add(check(pattern,queries[i]));
        }
        return res;
    }
    
    public boolean check(String p, String s){
        int sInd=0;
        int pInd=0;
        int pUpper=0;
        int sUpper=0;
        while(sInd<s.length()){
            if(Character.isUpperCase(s.charAt(sInd)))
                sUpper++;
            if(pInd<p.length() && p.charAt(pInd)==s.charAt(sInd)){
                if(Character.isUpperCase(p.charAt(pInd)))
                    pUpper++;
                pInd++;
            }
            sInd++;
        }
        return pInd==p.length() ? pUpper==sUpper :false;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       String[] queries={"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
       String pattern="FB";
       List<Boolean> ans=tr.camelMatch(queries,pattern);
       System.out.println(ans);           
    }
}