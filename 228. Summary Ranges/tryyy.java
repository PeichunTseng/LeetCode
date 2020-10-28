import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
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
///////////////////////Mine/////////////////////////
    public List<String> summaryRanges(int[] nums) {
        List<String> res= new ArrayList<>();
        int len=nums.length;
        if(len==0)
            return res;
        int start=nums[0];
        int end=nums[0];
        for(int i=1;i<len;i++){
            if(nums[i]==end+1)
                end=nums[i];
            else{
                if(start==end)
                    res.add(String.valueOf(start));
                else{
                    String temp=String.valueOf(start)+"->"+String.valueOf(end);
                    res.add(temp);
                }
                start=nums[i];
                end=nums[i];
                
            }
        }
        if(start==end)
            res.add(String.valueOf(start));
        else{
            String temp=String.valueOf(start)+"->"+String.valueOf(end);
            res.add(temp);
        }
        return res;
    }


    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] nums={0,2,3,4,6,8,9};
        List<String> ans=tr.summaryRanges(nums);
        System.out.print(ans);        
    }
}