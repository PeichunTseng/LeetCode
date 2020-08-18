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
///////////////////////Mine/////////////////////
    // public int[] distributeCandies(int candies, int num_people) {
    //     int[] res=new int[num_people];
    //     int n=(int)Math.sqrt(2*candies);
    //     int count=n-1;
    //     for(int i=n;i<=n+1;i++){
    //         if(i*(i+1)<=2*candies)
    //            count=i; 
    //     }
    //     for(int i=1;i<=count;i++){
    //         int ind=(i-1)%num_people;
    //         res[ind]+=i;
    //         candies-=i;
    //     }
    //     if(candies>0)
    //         res[count%num_people]+=candies;
    //     return res;
    // }

///////////////////////Others Better/////////////////////
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        for (int give = 0; candies > 0; candies -= give) {
            res[give % num_people] +=  Math.min(candies, ++give);
        }
        return res;
    }


    public static void main(String[] args) {
        tryyy tr=new tryyy(); 
        int candies = 7; 
        int num_people = 4; 
        int[] ans=tr.distributeCandies(candies,num_people);
        for(int a:ans)
            System.out.println(a);
    }
}