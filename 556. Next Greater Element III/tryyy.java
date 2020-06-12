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
/////////////////////////Mine/////////////////////// 
    public int nextGreaterElement(int n) {
        String s=String.valueOf(n);
        char[] arr=s.toCharArray();
        int len=arr.length;
        int index=len-2;
        while(index>=0){
            if(arr[index]<arr[index+1]){
                break;
            }
            index--;
        }
        if(index==-1)
            return -1;
        for(int i=len-1;i>=0;i--){
            if(arr[i]>arr[index]){
               char temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                break;
            }
        }
        Arrays.sort(arr, index+1, arr.length);
        long res = Long.valueOf(String.valueOf(arr));
        return res <= Integer.MAX_VALUE ? (int)res : -1;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int n=230241; //230412
        int ans=tr.nextGreaterElement(n);
        System.out.println(ans);         
    }
}