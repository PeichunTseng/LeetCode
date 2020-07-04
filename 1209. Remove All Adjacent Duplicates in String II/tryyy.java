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
////////////////////////////Mine//////////////////////////////
    public String removeDuplicates(String s, int k) {
        int len=s.length();
        char[] arr=new char[len];
        int[] count=new int[len];
        int a=-1;
        int c=-1;
        for(int i=0;i<len;i++){
            if(a==-1){
                arr[++a]=s.charAt(i);
                count[++c]++;
            }
            else{
                if(s.charAt(i)==arr[a]){
                    arr[++a]=s.charAt(i);
                    count[c]++;
                    if(count[c]==k){
                        count[c--]=0;
                        a=a-k;
                    }
                }
                else{
                    arr[++a]=s.charAt(i);
                    count[++c]++;
                }
            }
        }
        return String.valueOf(arr).substring(0,a+1);
    }


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        String s="deeedbbcccbdaa"; 
        int k=3;
        String ans=tr.removeDuplicates(s,k);
        System.out.println(ans);           
    }
}