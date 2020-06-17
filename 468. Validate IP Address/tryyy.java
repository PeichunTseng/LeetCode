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
    
//////////////////////////Mine////////////////////////////////
    public String validIPAddress(String IP) {
        if(checkIPv6(IP))
            return "IPv6";

        if(checkIPv4(IP))
            return "IPv4";

        return "Neither";
    }

    public boolean checkIPv4(String ip){
        if(ip.length()<7 || ip.charAt(0)=='.' || ip.charAt(ip.length()-1)=='.')
            return false;
        String[] arr=ip.split("\\.");
        if(arr.length!=4) return false;
        for(String s:arr){
            if((s.startsWith("0") && !s.equals("0")) || s.startsWith("+") ||s.startsWith("-"))
                return false;
            try{
                int temp=Integer.valueOf(s);
                if(temp<0 || temp>255)
                    return false;
            }
            catch(NumberFormatException e){
                return false;
            }
            
        }
        return true;
    }

    public boolean checkIPv6(String ip){
        if(ip.length()<15 || ip.charAt(0)==':' || ip.charAt(ip.length()-1)==':')
            return false;
        String[] arr=ip.split("\\:");
        if(arr.length!=8) return false;
        for(String s:arr){
            if(s.length()>4 || s.length()==0)
                return false;
            for(int i=0;i<s.length();i++){
                char temp=s.charAt(i);
                if((temp<='f' && temp>='a') || (temp<='F' && temp>='A') || (temp<='9' && temp>='0'))
                    continue;
                else
                    return false;
            }
        }
        return true;
    }

    // 1 IPv6 --> 8 Groups
    // 1 Group --> 4 hexadecimal digits
    // 1 hexadecimal digit --> 4 bits
    // 1 bit can take two values either 0 or 1
    // So 4 bits can take 2^4 values
    // So to represent 16 values using a single digit we use alphabets
    // 1 --> 1
    // 2 --> 2
    // 3 --> 3
    // 4 --> 4
    // 5 --> 5
    // 6 --> 6
    // 7 --> 7
    // 8 --> 8
    // 9 --> 9
    // 10 --> a or A
    // 11 --> b or B
    // 12 --> c or C
    // 13 --> d or D
    // 14 --> e or E
    // 15 --> f or F


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       String IP="1e1.4.5.6";
       String ans=tr.validIPAddress(IP);
       System.out.println(ans);           
    }
}