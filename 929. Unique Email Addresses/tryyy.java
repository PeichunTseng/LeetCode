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
////////////////////////自己寫//////////////////////////
    // public int numUniqueEmails(String[] emails){
    //     Set<String> set = new HashSet<>();
    //     for(String s:emails){
    //         String[] tem=s.split("@");
    //         StringBuilder sb = new StringBuilder();
    //         for(char ch:tem[0].toCharArray()){
    //             if(ch=='.')
    //                 continue;
    //             else if(ch=='+')
    //                 break;
    //             else
    //                 sb.append(ch);
    //         }
    //         sb.append("@");
    //         sb.append(tem[1]);
    //         String res=sb.toString();
    //         set.add(res);
    //     }
    //     return set.size();
    // }


////////////////////////別人寫//////////////////////////
    public int numUniqueEmails(String[] emails){
        Set<String> set = new HashSet<>();
        for(String s:emails){
            String[] tem=s.split("@");
            String[] part=tem[0].split("\\+");
            set.add(part[0].replace(".","")+"@"+tem[1]);
        }
        return set.size();
    }




    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       String[] emails={"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
       int ans=tr.numUniqueEmails(emails);
       System.out.println(ans);             
    }

}


