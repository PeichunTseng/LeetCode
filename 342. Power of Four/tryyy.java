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
    // public boolean isPowerOfFour(int num) {
    //     if(num==1) 
    //         return true;
    //     if(num%4!=0 || num<1)
    //         return false;
    //     return isPowerOfFour(num/4);
    // }

///////////////////////Others/////////////////////
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
    //First,greater than 0.
    //Second,only have one '1' bit in their binary notation,so we use x&(x-1) to delete the lowest '1',
    //and if then it becomes 0,it prove that there is only one '1' bit.
    //Third,the only '1' bit should be locate at the odd location,for example,16.It's binary is 00010000.
    //So we can use '0x55555555' to check if the '1' bit is in the right place.
    //0x55555555 is a hexametrical number，it is 1010101010101010101010101010101 in binary with a length of 32. 
    


    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       int num=16;
       boolean ans = tr.isPowerOfFour(num);         
       System.out.println(ans);    // returns false (already removed)      
    }
}