import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math; 
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.PriorityQueue; 
import java.util.Random;

public class tryyy
{
//////////////////Others//////////////////
    public int[] exclusiveTime(int n, List<String> logs){
        int[] res=new int[n];
        Stack<Integer> stack = new Stack<>();
        String[] preString = splitString(logs.get(0));
        int firstId=Integer.valueOf(preString[0]);
        int preStamp=Integer.valueOf(preString[2]);
        stack.push(firstId);

        for(int i=1;i<logs.size();i++){
            String[] temp= splitString(logs.get(i));
            int index=Integer.valueOf(temp[0]);
            int stamp=Integer.valueOf(temp[2]);
            if(temp[1].equals("start")){
                if(!stack.isEmpty())
                    res[stack.peek()]+=stamp-preStamp;
                stack.push(index);
                preStamp=stamp;
            }
            else{
                int finishedId=stack.pop();
                res[finishedId]+=stamp-preStamp+1;
                preStamp=stamp+1;
            }
        }
        return res;
    }

    private String[] splitString(String s){
        String[] temp=s.split(":");
        return temp;
    }

 
    public static void main(String[] args){
        tryyy tr=new tryyy();
        String[] arr={"0:start:0","1:start:2","1:end:5","0:end:6"};
        List<String> logs=new ArrayList<>();
        for(String s:arr)
            logs.add(s);
        int n=2;
        int[] ans=tr.exclusiveTime(n,logs);
        for(int a:ans)
            System.out.println(a);
    }
}