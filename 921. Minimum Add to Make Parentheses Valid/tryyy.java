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
    public int minAddToMakeValid(String S) {
        int right=0;
        int left=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='(')
                left++;
            else{
                if(left>0)
                    left--;
                else
                    right++;
            }
        }
        return left+right;
    }
    
    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        String S="()))((";
        int ans=tr.minAddToMakeValid(S);
        System.out.println(ans);         
    }
}