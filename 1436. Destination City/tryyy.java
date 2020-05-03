import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Collections;


public class tryyy
{
//////////////////////////////Mine///////////////////////////////
    // public String destCity(List<List<String>> paths) {
    //     Set<String> set1 = new HashSet<>();
    //     Set<String> set2 = new HashSet<>();
    //     for(List<String> l : paths){
    //         set1.add(l.get(0));
    //         set2.add(l.get(1));
    //     }
    //     for(String s:set2)
    //         if(!set1.contains(s))
    //             return s;
    //     return "";
    // }

//////////////////////////////Mine improve///////////////////////////////
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for(List<String> l : paths){
            set.add(l.get(0));
        }
        for(List<String> l : paths)
            if(!set.contains(l.get(1)))
                return l.get(1);
        return "";
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        List<List<String>> paths= new ArrayList<>();
        String[][] arr={{"London","New York"},{"New York","Lima"},{"Lima","Sao Paulo"}};
        for(String[] city:arr){
            paths.add(Arrays.asList(city));
        }
        String ans = tr.destCity(paths);
        System.out.println(ans);      
    }
}


