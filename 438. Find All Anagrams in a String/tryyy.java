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
    ////////////////////////Mine///////////////////////////
    // public List<Integer> findAnagrams(String s, String p){
    //     List<Integer> ans = new ArrayList<>();
    //     if(s.length()<p.length())
    //         return ans;

    //     int[] arr= new int[26];
    //     int len =p.length();
    //     for(char ch:p.toCharArray()){
    //         arr[ch-'a']++;           
    //     }


    //     for(int i=0;i<=s.length()-len;i++){
    //         if(arr[s.charAt(i)-'a']==0)
    //             continue;
    //         int end=i+len;
    //         int[] tem= new int [26];
    //         for(int j=i;j<end;j++){
    //             tem[s.charAt(j)-'a']++; 
    //         }
    //         if(Arrays.equals(arr,tem))
    //             ans.add(i);
    //     }
    //     return ans;

    // }


    ////////////////////////Others///////////////////////////
    // public List<Integer> findAnagrams(String s, String p){
    //     List<Integer> ans = new ArrayList<>();
    //     if(s.length()<p.length())
    //         return ans;

    //     int len =p.length();
    //     int[] arr= new int[26];
    //     for(char ch:p.toCharArray())
    //         arr[ch-'a']++;           

    //     int[] tem= new int[26];
    //     for(int i=0;i<s.length();i++){

    //         tem[s.charAt(i)-'a']++;

    //         if(i>=len)
    //             tem[s.charAt(i-len)-'a']--;

    //         if(Arrays.equals(arr,tem))
    //             ans.add(i-len+1);
    //     }
    //     return ans;

    // }

    ////////////////////////Sliding window  Best///////////////////////////
    public List<Integer> findAnagrams(String s, String p){
      List<Integer> res = new ArrayList<>();

      int[] record = new int[26];
      for(char ch:p.toCharArray()){
        record[ch-'a']++;
      }

      int count=0;
      int left=0;
      for(int i=0;i<s.length();i++){
        char temp=s.charAt(i);
        record[temp-'a']--;
        if(record[temp-'a']>=0){     
          count++;
        }

        if(count==p.length())
          res.add(left);
        
        if(i-left==p.length()-1){
          record[s.charAt(left)-'a']++;
          if(record[s.charAt(left)-'a']>0){          
            count--;
          }
          left++;
        }

      }
      return res;
    }


///////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       String s= "cbaebabacd" ;
       String p= "abc";
       List <Integer> ans=tr.findAnagrams(s,p);
       System.out.println(ans);           
    }
}


