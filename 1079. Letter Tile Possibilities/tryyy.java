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
    // int res=0;
    // public int numTilePossibilities(String tiles) {
    //     int[] arr=new int[26];
    //     for(int i=0;i<tiles.length();i++){
    //         arr[tiles.charAt(i)-'A']++;
    //     }
    //     dfs(arr,new StringBuilder());
    //     return res;
    // }
    
    // public void dfs(int[] arr, StringBuilder sb){
    //     for(char ch='A';ch<='Z';ch++){
    //         if(arr[ch-'A']!=0){
    //             res++;

    //             arr[ch-'A']--;
    //             int len=sb.length();
    //             sb.append(ch);
    //             dfs(arr,sb);

    //             arr[ch-'A']++;
    //             sb.setLength(len);
    //         }
    //     }
    // }

/////////////////////////Others Better/////////////////////// 
    public int numTilePossibilities(String tiles){
        int[] arr=new int[26];
        for(int i=0;i<tiles.length();i++){
            arr[tiles.charAt(i)-'A']++;
        }
        return dfs(arr);
    }

    public int dfs(int[] arr){
        int res=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                res++;
                arr[i]--;
                res+=dfs(arr);
                arr[i]++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        String tiles="AAB";
        int ans=tr.numTilePossibilities(tiles);
        System.out.println(ans);         
    }
}