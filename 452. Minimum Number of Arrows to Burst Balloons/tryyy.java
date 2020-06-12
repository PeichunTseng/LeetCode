import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
/////////////////////////Mine/////////////////////// 
    public int findMinArrowShots(int[][] points) {
        if(points.length==0)
            return 0;
        Arrays.sort(points,(a,b)->a[0]-b[0]);
        int res=1;
        int e=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=e){
                e=Math.min(e,points[i][1]);
            }
            else{
                e=points[i][1];
                res++;
            }
                
        }
        return res;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[][] points={{10,16},{2,8},{1,6},{7,12}};
        int ans=tr.findMinArrowShots(points);//2
        System.out.println(ans);         
    }
}