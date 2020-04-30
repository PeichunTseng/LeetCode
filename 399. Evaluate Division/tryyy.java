import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy
{
/////////////////////////////////Others/////////////////////////////////
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        Map<String,Map<String,Double>> map = buildGraph(equations,values);
        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            res[i]=helper(map,queries.get(i).get(0),queries.get(i).get(1), new HashSet<>());
        }
        return res;
    }

    public double helper(Map<String,Map<String,Double>> map, String start, String end, Set<String> visited){
        if(!map.containsKey(start) || !map.containsKey(end))
            return -1.0;
        visited.add(start);

        if(map.get(start).containsKey(end))
            return map.get(start).get(end);

        for(String key:map.get(start).keySet()){
            if(!visited.contains(key)){
                double temp=helper(map,key,end,visited);
                if(temp!=-1.0)
                    return temp*map.get(start).get(key);
            }
        }
        return -1.0;

    }

    public Map<String,Map<String,Double>> buildGraph(List<List<String>> equations, double[] values){
        Map<String,Map<String,Double>> map = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String x=equations.get(i).get(0);
            String y=equations.get(i).get(1);
            map.putIfAbsent(x,new HashMap<>());
            map.get(x).put(y,values[i]);
            map.putIfAbsent(y,new HashMap<>());
            map.get(y).put(x,1/values[i]);
        }
        return map;
    }


    public static void main(String[] args) {
       tryyy tr=new tryyy();
       List<List<String>> equations = new ArrayList<>();
       List<List<String>> queries = new ArrayList<>();

       String[][] input={{"a","b"},{"b","c"}};
       for(String[] arr:input){
         equations.add(Arrays.asList(arr));
       }
       
       String[][] input2={{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
       for(String[] arr:input2){
         queries.add(Arrays.asList(arr));
       }
  
       double[] values={2.0,3.0};
       double[] ans=tr.calcEquation(equations,values,queries);
       for(double aa:ans)
         System.out.println(aa);       
    }
}