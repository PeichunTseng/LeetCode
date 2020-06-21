import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
//import java.util.Entry;
//import java.util.*;



public class tryyy
{
/////////////////答案錯的//////////////////  
/////////////////jave integer 最大值為 2147483647 //////////////////
    // public String multiply(String num1, String num2) {
    //   int a=transfer(num1);
    //   int b=transfer(num2);
    //   int c=a*b;
    //   String s=String.valueOf(c);
    //   return s;
        
    // }
    
    // public int transfer(String num){
    //     int length = num.length();
    //     int total=0;
    //     for(int i=0;i<length;i++){
    //       int a=Character.getNumericValue(num.charAt(i));
    //       int tem=a*(int)Math.pow(10,length-1-i);
    //       total=total+tem;

    //     }
    //     return total;
    // }


    
////////////////////////////多兩個Array來儲存///////////////////////////
    // public String multiply(String num1, String num2) 
    // {
    //         if((num1.length()==1 && num1.equals("0")) || (num2.length()==1 && num2.equals("0"))) 
    //             return "0";
    //         int[] ret = new int[num1.length()+num2.length()];
    //         Arrays.fill(ret,0);
    //         char[] arr1 = num1.toCharArray();
    //         char[] arr2 = num2.toCharArray();

    //         int flag = 0;
    //         for(int i = num2.length()-1;i>=0;i--)
    //         {
    //             int index = ret.length-1 - flag;
    //             for(int j = num1.length()-1;j>=0;j--)
    //             {
    //                 ret[index--] += (arr2[i] - '0') * (arr1[j] - '0');
    //             }
    //             flag++;
    //         }

    //         for(int i = ret.length-1;i >= 0;i--)
    //         {
    //             if(i-1 >= 0)
    //             {
    //                 ret[i-1] += ret[i] / 10;
    //             }
    //             ret[i] %= 10;
    //         }
    //         int i = 0;
    //         if(ret[0] == 0) i++;
    //         StringBuilder sb = new StringBuilder();
            
    //         for(;i < ret.length;i++)
    //         {
    //             sb.append(ret[i]);
    //         }
    //         return sb.toString();
    //     }

    public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0"))
                return "0";
            
            int sizeOfResult = num1.length() + num2.length();
            int[] result = new int[sizeOfResult];
            int carry = 0;
            int pointer = result.length - 1;
            for (int i = num1.length() - 1; i >= 0; i--) {
                int n1 = num1.charAt(i) - '0';
                int start = pointer;
                carry = 0;
                for (int j = num2.length() - 1; j >= 0; j--) {
                    int n2 = num2.charAt(j) - '0';
                    int res = n1 * n2 + result[start] + carry;
                    carry = res / 10;
                    res %= 10;
                    result[start] = res;
                    start--;
                }
                if (carry > 0) {
                    result[start] = carry;
                }
                pointer--;
            }

            if (carry > 0) {
                result[0] = carry;
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                if (i == 0 && result[0] == 0) 
                    continue;
                builder.append(result[i]);
            }
            return builder.toString();
    }

    public static void main(String[] args){
       tryyy tr=new tryyy();
       String num1 = "1", num2 = "2147483647";
       String a=tr.multiply(num1,num2);
       String b=tr.multiplyy(num1,num2);
       System.out.println(a);
       System.out.println(b);
    }
}


