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
    public int numFriendRequests(int[] ages) {
        int res=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int a:ages)
            map.put(a,map.getOrDefault(a,0)+1);

        for(int keyA:map.keySet()){
            for(int keyB:map.keySet()){
                if(check(keyA,keyB))
                    if(keyA==keyB)
                        res+=map.get(keyA)*(map.get(keyB)-1);
                    else
                        res+=map.get(keyA)*map.get(keyB);
            }
        }
        return res;

    }

    public boolean check(int a,int b){
        if(a<=0.5*b+7 || a>b || (a>100 && b<100))
            return false;
        return true;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] ages={20,30,100,110,120};
        int ans=tr.numFriendRequests(ages);
        System.out.println(ans);         
    }
}