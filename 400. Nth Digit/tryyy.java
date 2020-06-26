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
import java.util.Queue; 
import java.util.LinkedList; 

public class tryyy
{
////////////////////////Mine//////////////////////////////////
    public int findNthDigit(int n) {
        int len=1;
        long count=9;
        int now=0;
        while(n>len*count){
            now+=count;
            n-=len*count;
            len++;
            count*=10;
        }
        int target=n%len;
        now+=n/len;
        if(target!=0)
            now++;
        String temp=String.valueOf(now);
        char ans= target==0? temp.charAt(temp.length()-1):temp.charAt(target-1);
        return ans-'0';
    }
  
    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int n=11;
       int ans=tr.findNthDigit(n);
       System.out.println(ans);
    }
}