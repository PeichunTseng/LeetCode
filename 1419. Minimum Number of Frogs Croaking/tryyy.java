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
    // public int minNumberOfFrogs(String croakOfFrogs) {
    //     int ans=0;
    //     Map<Character,List<Integer>> map = new HashMap<>();
    //     for(int i=0;i<croakOfFrogs.length();i++){
    //         char tem=croakOfFrogs.charAt(i);
    //         map.putIfAbsent(tem,new ArrayList<>());
    //         List<Integer> list = map.get(tem);
    //         list.add(i);
    //         map.put(tem,list);
    //     }
    //     int total=map.get('c').size();
    //     for(char c:map.keySet())
    //         if(map.get(c).size()!=total)
    //             return -1;
    //     char[] arr = {'r','o','a','k'};
    //     for(int i=0;i<total;i++){
    //         int tem=map.get('c').get(i);
    //         for(char ch:arr){
    //             int next=map.get(ch).get(i);
    //             if(next<tem)
    //                 return -1;
    //             tem=next;
    //         }
    //     }
    //     List<Integer> k = map.get('k');
    //     List<Integer> c = map.get('c');
    //     while(c.size()!=0){
    //         int tem=k.remove(0);
    //         while(c.size()!=0&&c.get(0)<tem){
    //             ans++;
    //             c.remove(0);
    //         }   
    //         if(c.size()!=0)
    //           c.remove(0);
    //     }
    //     return ans;
    // }
  ///////////////////////////////別人寫  較好///////////////////////////////
    public int minNumberOfFrogs(String croakOfFrogs){
        char[] s = croakOfFrogs.toCharArray();
        String C = "croak";
        int[] f = new int[6];
        for(char c : s){
            int ind = C.indexOf(c);
            if(ind > 0){
                if(f[ind] == 0)return -1;
                f[ind]--;
                f[ind+1]++;
            }
            else{
                if(f[5] > 0)
                    f[5]--;
                f[1]++;
            }
        }

        for(int i = 1;i < 5;i++){
            if(f[i] > 0)return -1;
        }
        return f[5];
    }





    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       String croakOfFrogs = "crcoakroak";//2
       //String croakOfFrogs = "aoocrrackk"; //-1

       int ans =tr.minNumberOfFrogs(croakOfFrogs);
       System.out.println(ans);
               
    }

}


