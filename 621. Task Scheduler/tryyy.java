import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Stack;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy
{
//////////////////////Mine/////////////////////
    public int leastInterval(char[] tasks, int n){
        int[] arr= new int[26];
        for(int i=0;i<tasks.length;i++){
            arr[tasks[i]-'A']++;
        }
        Arrays.sort(arr);

        int total=tasks.length;
        int sameLevel=0;
        int max=arr[25];
        for(int i=25;i>=0;i--){
          if(arr[i]==0)
              break;
          if(arr[i]==max)
              sameLevel++;
        }

        int res=sameLevel;
        res=res+(max-1)*(n+1);
        if(total>res){
            total-=res;
            res+=total;
        }   

        return res;
    }


  public static void main(String[] args){
     tryyy tr=new tryyy();
     char[] tasks={'A','A','A','B','B','B'};
     int n=2;
     int ans=tr.leastInterval(tasks,n);
     System.out.println(ans);   
  }
}


