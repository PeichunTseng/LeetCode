import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy{
///////////////////////////////Mine////////////////////////////
    public int minCost(int[][] costs) {
        int res=Integer.MAX_VALUE;
        if(costs.length==0)
            return 0;
        int r=costs[0][0];
        int g=costs[0][1];
        int b=costs[0][2];
        for(int i=1;i<costs.length;i++){
            int tempR=r;
            int tempG=g;
            int tempB=b;
            r=Math.min(g,b)+costs[i][0];
            g=Math.min(tempR,b)+costs[i][1];
            b=Math.min(tempR,tempG)+costs[i][2];
        }
        return Math.min(Math.min(r,g),b);
    }


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        //int[][] costs={{17,2,17},{16,16,5},{14,3,19}};
        int[][] costs={{17,2,10},{16,1,15},{19,1,20}};//18
        int res=tr.minCost(costs);
        System.out.println(res);           
    }
}