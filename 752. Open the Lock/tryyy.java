import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;
import java.util.Random;


public class tryyy
{
///////////////////////Mine Time Limit////////////////////////
    // int min=Integer.MAX_VALUE;
    // public int openLock(String[] deadends, String target) {
    //     Set<String> set = new HashSet<>();
    //     Map<String, Integer> map= new HashMap<>();
    //     for(String s:deadends)
    //         set.add(s);
    //     List<String> list= new ArrayList<>();
    //     list.add("0000");
    //     dfs(set,target,0,map, list);
    //     return min==Integer.MAX_VALUE?-1:min;
    // }
    
    // public void dfs(Set<String> set, String target, int depth, Map<String, Integer> map, List<String> list){
    //     if(depth>=min)
    //         return;
    //     for(int i=0;i<list.size();i++){
    //         map.put(list.get(i),depth);
    //     }
    //     //System.out.println(list);

    //     List<String> nextRound= new ArrayList<>();
    //     while(list.size()!=0){
    //         String temp=list.remove(0);
    //         if(set.contains(temp))
    //             continue;
    //         if(target.equals(temp)){
    //             min=Math.min(min,depth);
    //             return;
    //         }
    //         for(int i=0;i<4;i++){
    //             for(int j=0;j<=1;j++){
    //                 String next=generate(temp,i,j);
    //                 //System.out.println(next);
    //                 if(map.containsKey(next))
    //                     continue;
    //                 nextRound.add(next);
    //             }
    //         }
    //     }
    //     if(nextRound.size()>0)
    //     dfs(set,target,depth+1,map,nextRound);
    // }
    
    // public String generate(String s, int ind, int rotate){
    //     char[] arr= s.toCharArray();
    //     int original=arr[ind]-'0';
    //     //System.out.println(original+1);
    //     if(rotate==1){
    //         if(original==9)
    //             arr[ind]='0';
    //         else
    //             arr[ind]=(char)(original+1+'0');  
    //     }
    //     else{
    //         if(original==0)
    //             arr[ind]='9';
    //         else
    //             arr[ind]=(char)(original-1+'0');
    //     }
    //     return String.valueOf(arr);
    // }



///////////////////////Modify Others/////////////////////////
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for(String s:deadends)
            set.add(s);
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        int count=0;
        while(!q.isEmpty()){
            int time=q.size();
            count++;
            for(int t=0;t<time;t++){
                String temp=q.poll();
                if(!set.contains(temp)){
                    set.add(temp);
                    for(int i=0;i<4;i++){
                        for(int j=0;j<=1;j++){
                            String next=generate(temp,i,j);
                            if(next.equals(target)){
                                return count;
                            }
                            if(!set.contains(next))
                                q.offer(next);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public String generate(String s, int ind, int rotate){
        char[] arr= s.toCharArray();
        int original=arr[ind]-'0';
        if(rotate==1){
            if(original==9)
                arr[ind]='0';
            else
                arr[ind]=(char)(original+1+'0');  
        }
        else{
            if(original==0)
                arr[ind]='9';
            else
                arr[ind]=(char)(original-1+'0');
        }
        return String.valueOf(arr);
    }

    
    public static void main(String[] args){
        tryyy tr=new tryyy();
        String[] deadends={"0201","0101","0102","1212","2002"};
        String target="0202";
        int ans=tr.openLock(deadends,target);
        System.out.print(ans);
    }
}