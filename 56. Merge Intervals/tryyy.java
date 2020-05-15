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
////////////////////Mine//////////////////////
  public int[][] merge(int[][] intervals){
    if(intervals.length<2)
        return intervals;
    Arrays.sort(intervals,(a,b)->a[0]-b[0]);
    List<int[]> list = new ArrayList<>();
    int end=intervals[0][1];
    list.add(intervals[0]);
    for(int i=1;i<intervals.length;i++){
        if(intervals[i][0]<=end){
            end=Math.max(intervals[i][1],list.get(list.size()-1)[1]);
            list.get(list.size()-1)[1]=end;
        }
        else{
            list.add(intervals[i]);
            end=intervals[i][1];
        }
    }
    int[][] res = new int[list.size()][2];
    // for(int i=0;i<res.length;i++){
    //     res[i][0]=list.get(i)[0];
    //     res[i][1]=list.get(i)[1];
    // }
    res=list.toArray(new int[list.size()][]);
    return res;
  }
  ////////////////////Mine Improve//////////////////////
  //Operate in the original array
          
  public static void main(String[] args) {
    tryyy tr=new tryyy();
    int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
    int[][] ans = tr.merge(intervals);
    for(int[] arr:ans){
        System.out.print(arr[0]);
        System.out.print(" ");
        System.out.print(arr[1]);
        System.out.println();
    }
  }
}