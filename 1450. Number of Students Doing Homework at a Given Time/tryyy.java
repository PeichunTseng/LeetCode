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
//////////////////Mine//////////////////
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res=0;
        for(int i=0;i<startTime.length;i++){
            if(startTime[i]<=queryTime && endTime[i]>=queryTime)
                res++;
        }
        return res;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[] startTime={1,2,3};
        int[] endTime={3,2,7};
        int queryTime=4;
        int ans = tr.busyStudent(startTime,endTime,queryTime);
        System.out.println(ans);
    }
}