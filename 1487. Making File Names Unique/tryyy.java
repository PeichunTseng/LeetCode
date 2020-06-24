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
import java.util.Queue; 
import java.util.LinkedList; 

public class tryyy
{

////////////////////////Others//////////////////////////////////
    public String[] getFolderNames(String[] names) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<names.length;i++){
            String temp=names[i];
            if(map.containsKey(temp)){
                int val=map.get(temp);
                StringBuilder sb = new StringBuilder(temp);
                sb.append('(');
                sb.append(val);
                sb.append(')');
                while(map.containsKey(sb.toString())){
                    val++;
                    sb = new StringBuilder(temp);
                    sb.append('(');
                    sb.append(val);
                    sb.append(')');   
                }
                map.put(temp,val+1);
                map.put(sb.toString(),1);
                names[i]=sb.toString();
            }
            else{
                names[i]=temp;
                map.put(temp,1);
            }
        }
        return names;
    }
  
    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       String[] names = {"kaido","kaido(1)","kaido","kaido(1)"};
       String[] ans= tr.getFolderNames(names);
       for(String s:ans)
        System.out.println(s);
    }
}