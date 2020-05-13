import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy
{
//////////////////////Others//////////////////////
  public List<List<String>> accountsMerge(List<List<String>> acts){
        Map<String,String> parents = new HashMap<>();
        Map<String,String> name = new HashMap<>();

        //Initialize parent for each element
        for(List<String> a:acts){
            for(int i=1;i<a.size();i++){
                parents.put(a.get(i),a.get(i));
                name.put(a.get(i),a.get(0));
            }
        }

        //update parent for each element 
        for(List<String> a:acts){
            String lead=findParents(a.get(1),parents);
            for(int i=2;i<a.size();i++){
                parents.put(findParents(a.get(i),parents),lead);
            }
        }

        //union
        Map<String,TreeSet<String>> union = new HashMap<>();
        for(List<String> a:acts){
            String key=findParents(a.get(1),parents);
            union.putIfAbsent(key,new TreeSet<>());
            for(int i=1;i<a.size();i++){
                String temp = a.get(i);
                union.get(key).add(temp);
            }
        }

        // conclude the result
        List<List<String>> res = new ArrayList<>();
        for(String key:union.keySet()){
            List<String> eachName = new ArrayList<>(union.get(key));
            eachName.add(0,name.get(key));
            res.add(eachName);
        }

        return res;
    }

    private String findParents(String s, Map<String,String> map){
        return map.get(s)==s ? s : findParents(map.get(s),map);
    }


    public static void main(String[] args){
       tryyy tr=new tryyy();
       List<List<String>> accounts = new ArrayList<>();
       // String[] a={"John", "johnsmith@mail.com", "john00@mail.com"};
       // String[] b={"John", "johnnybravo@mail.com"};
       // String[] c={"John", "johnsmith@mail.com", "johnnybravo@mail.com", "john_newyork@mail.com"};
       // String[] d={"Mary", "mary@mail.com"};
       String[] a={"John", "a", "b"};
       String[] b={"John", "c"};
       String[] c={"John", "d", "b", "z"};
       String[] d={"Mary", "mary@mail.com"};

       // parents
       // (a,a) (b,a)   -->   (a,d) (b,a)
       // (c,c)
       // (d,d) (a,d) (z,d)

       // unions
       // d   a,b
       // c   c
       // d   a,d,b,z

       accounts.add(new ArrayList<>(Arrays.asList(a)));
       accounts.add(new ArrayList<>(Arrays.asList(b)));
       accounts.add(new ArrayList<>(Arrays.asList(c)));
       accounts.add(new ArrayList<>(Arrays.asList(d)));
       List<List<String>> ans = tr.accountsMerge(accounts);
       for(List<String> l:ans)
         System.out.println(l);   
    }
}


