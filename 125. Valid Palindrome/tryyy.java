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
/////////////////////Mine //////////////////////
    public boolean isPalindrome(String s){
        int left=0;
        int right=s.length()-1;
        s=s.toLowerCase();
        System.out.println(s); 
        while(left<right){
            while(left<s.length() && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while(right>0 && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if(left==s.length() || right<0)
                return true;
            if(s.charAt(left)!=s.charAt(right))
                return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }


    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       String s="A man, a plan, a canal: Panama";
       boolean ans=tr.isPalindrome(s);
       System.out.println(ans);           
    }

}


