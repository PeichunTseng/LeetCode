import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Deque;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Collections;


public class tryyy
{
//////////////////////////////Mine///////////////////////////////
    // public int findComplement(int num) {
    //     StringBuilder sb = new StringBuilder();
    //     String s= Integer.toBinaryString(num);
    //     for(char ch: s.toCharArray()){
    //         if(ch=='1')
    //             sb.append("0");
    //         else
    //             sb.append("1");
    //     }
    //     return Integer.parseInt(sb.toString(),2);
    // }

    public int findComplement(int num) {
        int todo = num, bit = 1;
        while (todo != 0) {
          // flip current bit
          num = num ^ bit;
          // prepare for the next run
          bit = bit << 1;
          todo = todo >> 1;
        }
        return num;
      }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int num = 13;  //1101
        int ans = tr.findComplement(num);
        System.out.print(ans);  
    }
}


