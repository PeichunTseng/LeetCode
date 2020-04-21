import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
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
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        sb.append(S.replace("-","").toUpperCase());
        String str=sb.reverse().toString();
        //System.out.println(sb.toString());
        if(str.length()<=K)
            return sb.reverse().toString();
        sb = new StringBuilder();
        int count=(str.length()%K==0 ? str.length()/K : str.length()/K+1);
        for(int i=0;i<count;i++){
            if(i==count-1)
                sb.append(str.substring(i*K));
            else
                sb.append(str.substring(i*K,i*K+K));
            sb.append("-");
        }
        return sb.reverse().toString().substring(1);
    }




    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       //String S="5F3Z-2e-9-w";
       String S="2-5g-3-J";
       int K=2;
       String ans=tr.licenseKeyFormatting(S,K);
       System.out.println(ans);
       //System.out.println(S.toUpperCase());          
    }

}


