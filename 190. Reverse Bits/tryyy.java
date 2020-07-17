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
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            res<<=1;
            res=res|(n&1);
            n>>=1;
        }
        return res;
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int n=Integer.valueOf("00000010100101000001111010011100", 2);
       int ans=tr.reverseBits(n);
       System.out.println(ans);           
    }
}