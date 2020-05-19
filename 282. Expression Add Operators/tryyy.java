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
///////////////////////////////Others//////////////////////////////
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res,num,0,target,0,0,sb);
        return res;
    }

    private void helper(List<String> res, String num, int pos, int target, long currentValue, long lastOperation, StringBuilder sb){
        if(pos==num.length()){
            if(currentValue==target)
                res.add(sb.toString());
            return ;
        }

        for(int i=pos;i<num.length();i++){
            // because no number is start from integer 0
            if(num.charAt(pos)=='0' && i!=pos)
                break;
            long cur=Long.valueOf(num.substring(pos,i+1));
            int len=sb.length();
            if(pos==0){
                helper(res,num,i+1,target,cur,cur,sb.append(cur));
                sb.setLength(len);
            }
            else{
                helper(res,num,i+1,target,currentValue+cur,cur,sb.append("+").append(cur));
                sb.setLength(len);
                helper(res,num,i+1,target,currentValue-cur,-cur,sb.append("-").append(cur));
                sb.setLength(len);
                helper(res,num,i+1,target,currentValue-lastOperation+lastOperation*cur,lastOperation*cur,sb.append("*").append(cur));
                sb.setLength(len);
            }
        }
    }
 
    public static void main(String[] args){
        tryyy tr=new tryyy();
        String num="123";
        //int target=24;
        int target=6;
        List<String> ans=tr.addOperators(num,target);
        System.out.println(ans);
    }
}