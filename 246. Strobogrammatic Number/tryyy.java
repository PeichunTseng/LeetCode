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
    // public boolean isStrobogrammatic(String num) {
    //     int index=0;
    //     char[] end=new char[num.length()];
    //     for(int i=num.length()-1;i>=0;i--){
    //         char ch=num.charAt(i);
    //         if(ch=='0')
    //             end[index++]='0';
    //         else if(ch=='1')
    //             end[index++]='1';
    //         else if(ch=='6')
    //             end[index++]='9';
    //         else if(ch=='8')
    //             end[index++]='8';
    //         else if(ch=='9')
    //             end[index++]='6';
    //         else 
    //             return false;
    //     }
    //     return num.equals(String.valueOf(end));
    // }

/////////////////////////Mine Improve///////////////////////
    public boolean isStrobogrammatic(String num) {
        int index=0;
        for(int i=num.length()-1;i>=0;i--){
            char ch=num.charAt(i);
            if(ch=='0' && num.charAt(index++)=='0')
                continue;
            else if(ch=='1' && num.charAt(index++)=='1')
                continue;
            else if(ch=='6' && num.charAt(index++)=='9')
                continue;
            else if(ch=='8'&& num.charAt(index++)=='8')
                continue;
            else if(ch=='9'&& num.charAt(index++)=='6')
                continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        String num="69";
        boolean ans=tr.isStrobogrammatic(num);
        System.out.println(ans);         
    }
}
