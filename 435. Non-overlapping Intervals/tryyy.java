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
///////////////////////Others/////////////////////
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]==b[1]?b[0]-a[0]:a[1]-b[1]);
        int res=0;
        if(intervals.length<1)
            return 0;
        int lastEnd=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<lastEnd)
                res++;
            else
                lastEnd=Math.max(lastEnd,intervals[i][1]);
        }
        return res;
        
    }


    public static void main(String[] args) {
        tryyy tr=new tryyy(); 
        int[][] intervals={{1,2},{2,3},{3,4},{1,3}}; 
        int ans=tr.eraseOverlapIntervals(intervals);
        System.out.println(ans);
    }
}