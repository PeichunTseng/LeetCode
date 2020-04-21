import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class tryyy
{
///////////////////////////最差O(n*2)//////////////////////////////////////
    // public boolean checkValidString(String s) {
    //     return check(s, 0, 0);
    // }

    // private boolean check(String s, int start, int count) {
    //     if (count < 0) return false;
        
    //     for (int i = start; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (c == '(') {
    //             count++;
    //         }
    //         else if (c == ')') {
    //             if (count <= 0) 
    //                 return false;
    //             count--;
    //         }
    //         else if (c == '*') {
    //             return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
    //         }
    //     }
        
    //     return count == 0;
    // }

////////////////////////較好//////////////////////////////////////
    public boolean checkValidString(String S){
        int low=0;
        int high=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                low++;
                high++;
            }
            else if(ch=='*'){
                low--;
                high++;
            }
            else{
                low--;
                high--;
            }
            if(high<0) //代表 ')' 多
                return false;
            //重設下限
            low = Math.max(low, 0); //如果low<0 ,代表'*' 多, 所以可以忽略'*'的low
            // if(low<0)
            //     low=0;
        }
        return low==0;
    }


    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       String input="**())*)";

       System.out.println(tr.checkValidString(input));            
    }
}


