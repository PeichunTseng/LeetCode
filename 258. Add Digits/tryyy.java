import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy{
///////////////////////////////Mine////////////////////////////
    public int addDigits(int num) {
        if(num<10)
            return num;
        int res=0;
        while(num>0){
            res+=num%10;
            num/=10;
        }
        return addDigits(res);
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int nums=38;
        int res=tr.addDigits(nums);
        System.out.println(res);           
    }
}