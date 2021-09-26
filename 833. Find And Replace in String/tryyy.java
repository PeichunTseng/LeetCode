import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy {

//////////////////////Mine/////////////////////
  public String findReplaceString(String s, int[] indices, String[] sources, String[] targets){
    StringBuilder sb = new StringBuilder();
    int ind = 0;
    Map<Integer,List<String>> map = new HashMap<>();
    for(int i=0;i<indices.length;i++){
        List<String> list = new ArrayList<>();
        list.add(sources[i]);
        list.add(targets[i]);
        map.put(indices[i],list);
    }

    for(int i=0;i<s.length();i++){
        if(map.containsKey(i)){
            List<String> list = map.get(i);
            String sou = list.get(0);
            if(s.startsWith(sou,i)){
                sb.append(list.get(1));
                i += sou.length()-1;
            }
            else{
                sb.append(s.charAt(i));
            }
            ind++;
        }
        else{
            sb.append(s.charAt(i));
        }
    }

    return sb.toString();
  }      

  public static void main(String[] args) {
    tryyy tr = new tryyy(); 
    String s = "abcd";
    int[] indices = {0,2};
    String[] sources = {"ab", "ec"};
    String[] targets = {"eee", "ffff"};
    String ans = tr.findReplaceString(s, indices, sources, targets);
    System.out.println(ans);            
  }
}