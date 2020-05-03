import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Collections;


public class tryyy
{
//////////////////////////////Mine///////////////////////////////
    // public boolean kLengthApart(int[] nums, int k) {
    //     List<Integer> list = new ArrayList<>();
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]==1){
    //             list.add(i);
    //         }
    //     }
    //     if(list.size()<=1)
    //         return true;
    //     for(int i=1;i<list.size();i++){
    //         if(list.get(i)-list.get(i-1)-1<k){
    //             return false;          
    //         }
    //     }
    //     return true;
    // }

//////////////////////////////Mine improve///////////////////////////////
    public boolean kLengthApart(int[] nums, int k) {
        int last=-k-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(i-last-1<k)
                    return false;
                last=i;
            }
        }
        return true;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] nums={0,1,0,1};
        int k=1;
        boolean ans = tr.kLengthApart(nums,k);
        System.out.println(ans);      
    }
}


