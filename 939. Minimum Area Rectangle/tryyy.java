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

    public int minAreaRect(int[][] points){
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] p: points){
            map.putIfAbsent(p[0],new HashSet<>());
            map.get(p[0]).add(p[1]);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                if(points[i][0]==points[j][0] || points[i][1]==points[j][1])
                    continue;
                else if(map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1]))
                    min=Math.min(min,Math.abs(points[i][0]-points[j][0])*Math.abs(points[i][1]-points[j][1]));

            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       int[][] points={{1,1},{1,3},{3,1},{3,3},{2,2}};
       int ans=tr.minAreaRect(points);
       System.out.println(ans);            
    }

}


