import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy
{
///////////////////////Mine///////////////////////
    // public String addStrings(String num1, String num2){
    //     int len=Math.max(num1.length(),num2.length());
    //     if(num1.length()<len){
    //         num1=addToLen(num1,len);
    //     }
    //     if(num2.length()<len){
    //         num2=addToLen(num2,len);
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     int next=0;
    //     for(int i=len-1;i>=0;i--){
    //         int temp=(num1.charAt(i)-'0')+(num2.charAt(i)-'0')+next;
    //         sb.append(temp%10);
    //         next=temp/10;
    //     }
    //     if(next!=0)
    //         sb.append(next);
    //     return sb.reverse().toString();
    // }

    // public String addToLen(String s, int len){
    //     int num=len-s.length();
    //     String res="";
    //     for(int i=0;i<num;i++){
    //         res+="0";
    //     }
    //     return res+s;
    // }
///////////////////////Others better///////////////////////
    public String addStrings(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        int next=0;
        for(int i=num1.length()-1,j=num2.length()-1;i>=0 || j>=0 || next!=0; i--,j--){
            int x= i>=0 ? num1.charAt(i)-'0' : 0;
            int y= j>=0 ? num2.charAt(j)-'0' : 0;
            int num=x+y+next;
            sb.append(num%10);
            next=num/10;
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       String num1="19";
       String num2="82";
       String ans=tr.addStrings(num1,num2);
       System.out.println(ans);           
    }

}


