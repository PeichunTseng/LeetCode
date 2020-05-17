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
//////////////////Mine Time Limit Exceeded//////////////////
    // public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies){
    //      Map<List<String>,Integer> map = new HashMap<>();
    //      List<Integer> res = new ArrayList<>();
    //      for(int i=0;i<favoriteCompanies.size();i++){
    //          map.put(favoriteCompanies.get(i),i);
    //      }
    //      Collections.sort(favoriteCompanies,(a,b)->b.size()-a.size());
    //      System.out.println(favoriteCompanies);
    //      Set<List<String>> set = new HashSet<>();
    //      set.add(favoriteCompanies.get(0));
    //      res.add(map.get(favoriteCompanies.get(0)));
         
    //      boolean flag=false;
    //      for(int i=1;i<favoriteCompanies.size();i++){
    //          flag=false;
    //          List<String> temp = favoriteCompanies.get(i);
    //          int count=temp.size();
    //          for(List<String> l:set){
    //               count=temp.size();
    //              for(String s:temp){
    //                 if(l.contains(s)){
    //                     count--;
    //                 }
    //              }
    //              if(count==0)
    //                  break;
    //          }
            
    //         if(count!=0)
    //             res.add(map.get(favoriteCompanies.get(i)));
    //         set.add(favoriteCompanies.get(i));
    //      }
    //      Collections.sort(res);
    //      return res;
    //  }


////////////////////////Others ////////////////////////
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies){
        int len =favoriteCompanies.size();
        List<Set<String>> list= new ArrayList<>();
        for(List<String> l:favoriteCompanies){
            Set<String> set = new HashSet<>();
            for(String s:l)
                set.add(s);
            list.add(set);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<len;i++){
            boolean flag=false;
            for(int j=0;j<len;j++){
                if(i==j)
                    continue;
                Set<String> l1=list.get(i);
                Set<String> l2=list.get(j);
                // Default flag=false --> l2 is subarray of l1
                flag=false;
                for(String s:l1){
                    // If there is a different element between l1 and l2 --> flag=true --> It mean they are different subarray 
                    if(!l2.contains(s)){
                        flag=true;
                        break;
                    }
                }
                if(!flag)
                    break;
            }
            if(flag)
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy();
        List<List<String>> favoriteCompanies = new ArrayList<>();
        String[][] arr={{"leetcode","google","facebook"},{"google","microsoft"},{"google","facebook"},{"google"},{"amazon"}};
        for(String[] s:arr){
            favoriteCompanies.add(new ArrayList<>(Arrays.asList(s)));
        }
        List<Integer> ans = tr.peopleIndexes(favoriteCompanies);
        System.out.println(ans);
    }
}