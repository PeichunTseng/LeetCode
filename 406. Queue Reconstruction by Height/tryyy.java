import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;
import java.util.Random;


public class tryyy
{
///////////////////////Mine////////////////////////
    // public int[][] reconstructQueue(int[][] people) {
    //     int[][] res=new int[people.length][2];
    //     for(int[] arr:res){
    //         arr[0]=-1;
    //     }
        
    //     Arrays.sort(people,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
    //     for(int i=0;i<people.length;i++){
    //         int position=helper(res,people[i]);
    //         res[position]=people[i];
    //     }
    //     return res;
    // }
    
    // public int helper(int[][] res, int[] peo){
    //     int count=-1;
    //     int position=0;
    //     for(int i=0;i<res.length;i++){
    //         if(res[i][0]==-1 || res[i][0]==peo[0])
    //             count++;
    //         if(count==peo[1]){
    //             position=i;
    //             break;
    //         }
    //     }
    //     return position;
    // }



///////////////////////Others Better/////////////////////////
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][]);
    }
    
    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[][] people={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] ans=tr.reconstructQueue(people);
        for(int[] arr:ans){
            System.out.print(arr[0]+" "+arr[1]);
            System.out.println();
        }
    }
}