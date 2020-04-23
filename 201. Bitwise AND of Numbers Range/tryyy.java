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

//binary tree//


public class tryyy
{
//////////////////////////others////////////////////////////////
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m < n) {
          m=m >>1;   //m>>=1   m=m>>1
          n=n >>1;
          shift++;
        }
        return m << shift;
      }

    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       int ans=tr.rangeBitwiseAnd(5,7);
       System.out.println(ans);           
    }

}


