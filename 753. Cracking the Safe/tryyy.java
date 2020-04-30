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
///////////////////////Others///////////////////////
    String res="";
    public String crackSafe(int n, int k){
        Set<String> set = new HashSet<>();
        int total=(int)Math.pow(k,n);
        for(int i=0;i<n;i++){
            res+="0";
        }
        set.add(res); 
        dfs(set,total,n,k);
        return res;
    }

    public boolean dfs(Set<String> set, int total, int n, int k){
        if(set.size()==total)
            return true;
        for(int i=0;i<k;i++){
            String temp=res.substring(res.length()-n+1);
            temp+=String.valueOf(i);
            if(!set.contains(temp)){
                res+=String.valueOf(i);
                set.add(temp);
                if(dfs(set,total,n,k))
                    return true;
                else{
                    set.remove(temp);
                    res=res.substring(0,res.length()-1);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       int n=2;
       int k=2;
       String ans=tr.crackSafe(n,k);
       System.out.println(ans);           
    }

}


