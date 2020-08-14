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
    public int longestPalindrome(String s) {
        int[] arr= new int[58];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'A']++;
        }
        int total=0;
        boolean oneMore=false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                if(arr[i]%2==0)
                    total+=arr[i];
                else{
                    oneMore=true;
                    total+=arr[i]-1;
                }
            }
        }
        return oneMore? total+1:total;
    }


    public static void main(String[] args) {
        tryyy tr=new tryyy(); 
        String s="abccccdd"; 
        int ans=tr.longestPalindrome(s);
        System.out.println(ans);
    }
}