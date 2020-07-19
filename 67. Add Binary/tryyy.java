import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math; 
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.PriorityQueue; 
import java.util.LinkedList;



public class tryyy
{
//////////////////////////Mine/////////////////////
    // public String addBinary(String a, String b) {
    //    int sA=a.length()-1;
    //    int sB=b.length()-1;
    //    StringBuilder sb = new StringBuilder();
    //    int temp=0;
    //    while(sA>=0 || sB>=0){
    //        int numA= sA<0 ? 0 : a.charAt(sA)-'0';
    //        int numB= sB<0 ? 0 : b.charAt(sB)-'0';
    //        if(numA==1 && numB==1){
    //            if(temp==1)
    //                sb.append(1);
    //            else
    //                sb.append(0);
    //            temp=1;    
    //        }
    //        else if(numA==0 && numB==0){
    //            if(temp==1)
    //                sb.append(1);
    //            else
    //                sb.append(0);
    //            temp=0;    
    //        }
    //        else{
    //            if(temp==1){
    //                sb.append(0);
    //                temp=1;    
    //            }
    //            else{
    //                sb.append(1);
    //                temp=0;    
    //            } 
    //        }
    //        sA--;
    //        sB--;
    //    }
    //    if(temp==1)
    //        sb.append(1);
    //    return sb.reverse().toString();
       
    // }

//////////////////////////Others/////////////////////
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) 
                sum += b.charAt(j--) - '0';
            if (i >= 0) 
                sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) 
            sb.append(carry);
        return sb.reverse().toString();
    }
     

    public static void main(String[] args) {
       tryyy tr = new tryyy();
       String a = "1010", b = "1011";//10101
       System.out.println(tr.addBinary(a,b));
    }
}

