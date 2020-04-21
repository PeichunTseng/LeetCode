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
    // public List<List<String>> displayTable(List<List<String>> orders) {
    //     List<String> list = new ArrayList<>();
    //     for(List<String> l:orders){
    //         if(!list.contains(l.get(2)))
    //             list.add(l.get(2));
            
    //     }
    //     Collections.sort(list);
        
    //     Map<String,Integer> m= new HashMap<>();
    //     for(int i=0;i<list.size();i++){
    //         m.put(list.get(i),i);
    //     }
        
    //     Map<String,List<Integer>> map = new HashMap<>();
    //     for(List<String> l:orders){
    //         if(!map.containsKey(l.get(1))){
    //             List<Integer> inner = new ArrayList<>();
    //             for(int i=0;i<list.size();i++)
    //                 inner.add(0);
    //             map.put(l.get(1),inner);
    //         }
    //         List<Integer> sec = map.get(l.get(1));
    //         int re=sec.get(m.get(l.get(2)))+1;
    //         int index=m.get(l.get(2));
    //         sec.remove(index);
    //         sec.add(m.get(l.get(2)), re); 
    //         map.put(l.get(1),sec);
                       
    //     }

    //     List<List<String>> ans = new ArrayList<>();
    //     for(String key:map.keySet()){
    //         List<String> aa = new ArrayList<>();
    //         aa.add(key);
    //         List<Integer> bb=map.get(key);
    //         for(int a:bb){
    //             aa.add(String.valueOf(a));
    //         }
    //         ans.add(aa);        
    //     }

    //     Collections.sort(ans,(a,b)->Integer.valueOf(a.get(0))-Integer.valueOf(b.get(0)));
    //     List<String> a1 = new ArrayList<>();
    //     a1.add("Table");
    //     for(String s:list)
    //         a1.add(s);
    //     ans.add(0,a1);
    //     return ans;
        
    // }

  ///////////////////////////////改良過///////////////////////////////
    public List<List<String>> displayTable(List<List<String>> orders){
      List<List<String>> ans = new ArrayList<>();
      Set<String> set = new TreeSet<>();
      List<String> firstRow = new ArrayList<>();
      firstRow.add("Table");

      for(List<String> l : orders){
        set.add(l.get(2));
      }
      for(String s:set)
        firstRow.add(s);

      Set<Integer> sss = new TreeSet<>();
      Map<String,Map<String,Integer>> map = new HashMap<>();
      for(List<String> l : orders){
        int num=Integer.valueOf(l.get(1));
        sss.add(num);
        map.putIfAbsent(l.get(1), new HashMap<>());
        Map<String,Integer> temp = map.get(l.get(1));
        temp.put(l.get(2),temp.getOrDefault(l.get(2),0)+1);
      }

      ans.add(firstRow);
      for(int s:sss){
        List<String> row = new ArrayList<>();
        row.add(String.valueOf(s));
        for(int i=1;i<firstRow.size();i++){
          Map<String,Integer> tem=map.get(String.valueOf(s));
          String a=firstRow.get(i);
          int count=(tem.get(a)==null?0:tem.get(a));
          row.add(String.valueOf(count));
        }
        ans.add(row);
      }
      return ans;

    }


    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       String[] o1={"David","3","Ceviche"};
       String[] o2={"Corina","10","Beef Burrito"};
       String[] o3={"David","3","Fried Chicken"};
       String[] o4={"Carla","5","Water"};
       String[] o5={"Carla","5","Ceviche"};
       String[] o6={"Rous","3","Ceviche"};
       // Output: [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],
       //          ["3"    ,"0"           ,"2"      ,"1"            ,"0"    ],
       //          ["5"    ,"0"           ,"1"      ,"0"            ,"1"    ],
       //          ["10"   ,"1"           ,"0"      ,"0"            ,"0"    ]] 

       List<List<String>> orders=new ArrayList<>();
       orders.add(Arrays.asList(o1));
       orders.add(Arrays.asList(o2));
       orders.add(Arrays.asList(o3));
       orders.add(Arrays.asList(o4));
       orders.add(Arrays.asList(o5));
       orders.add(Arrays.asList(o6));
       List<List<String>> ans=tr.displayTable(orders);

       for(List<String> l:ans)
          System.out.println(l);
               
    }

}


