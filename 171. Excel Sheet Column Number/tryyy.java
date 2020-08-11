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
    public int titleToNumber(String s) {
        int count=s.length()-1;
        int temp=1;
        while(count!=0){
            temp*=26;
            count--;
        }
        int res=0;
        for(int i=0;i<s.length();i++){
            res+=temp*(s.charAt(i)-'A'+1);
            temp/=26;
        }
        return res;
    }


    public static void main(String[] args) {
        tryyy tr=new tryyy(); 
        String s="AB";
        int ans =tr.titleToNumber(s);
        System.out.println(ans);    
    }
}