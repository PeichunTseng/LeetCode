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
//////////////////////////Mine////////////////////////////////
    public String shiftingLetters(String S, int[] shifts) {
        for(int i=shifts.length-2;i>=0;i--){
            shifts[i]=shifts[i]%26+shifts[i+1]%26;
        }
        char[] arr=new char[S.length()];
        for(int i=0;i<arr.length;i++){
            int d=(shifts[i]+(S.charAt(i)-'a'))%26;
            arr[i]=(char)((int)'a'+d);
        }
        return String.valueOf(arr);
    }


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        String S="abc";
        int[] shifts={3,5,9};
        String ans=tr.shiftingLetters(S,shifts);
        System.out.println(ans);           
    }
}