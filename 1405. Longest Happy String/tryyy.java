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

public class tryyy{
//////////////////////////Others////////////////////////////////
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        help(a,b,c,"a","b","c",sb);
        return sb.toString();
    }

    public void help(int a, int b, int c, String sss, String ss, String s, StringBuilder sb) {
        if(a < b) {
          help(b, a, c, ss, sss, s, sb);
          return;
        }

        if(b < c){
          help(a, c, b, sss, s, ss, sb);
          return;
        }

        if(b == 0){
          int round = Math.min(a, 2);
          for(int i = 0; i < round; i++){
            sb.append(sss);
          }
          return;
        }

        int aRound = Math.min(a, 2);
        int bRound = a - aRound >= b ? 1 : 0;
        for(int i = 0; i < aRound; i++){
          sb.append(sss);
        }
        for(int i = 0; i < bRound; i++){
          sb.append(ss);
        }

        help(a-aRound, b-bRound, c, sss, ss, s, sb);
    }

    public static void main(String[] args){
       tryyy tr = new tryyy(); 
       String ans = tr.longestDiverseString(1,1,7);
       System.out.println(ans);           
    }
}