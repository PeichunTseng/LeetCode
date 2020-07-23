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

public class tryyy{
///////////////////////////////Mine////////////////////////////
    // public int[] singleNumber(int[] nums) {
    //     Map<Integer,Integer> map = new HashMap<>();
    //     for(int a:nums)
    //         map.put(a,map.getOrDefault(a,0)+1);
    //     int[] res=new int[2];
    //     int index=0;
    //     for(int key:map.keySet()){
    //         if(map.get(key)==1){
    //             res[index++]=key;
    //         }
    //     }
    //     return res;
    // }

///////////////////////////////Others better////////////////////////////
    //https://leetcode.com/problems/single-number-iii/discuss/68901/Sharing-explanation-of-the-solution
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num: nums){
            diff^=num;
        }
        diff = Integer.highestOneBit(diff);//去最左邊為1的數
        
        int[] result = new int[2];
        Arrays.fill(result,0);
        for(int num: nums){
            if((diff & num) == 0){ // only 1&1=1, others are equals 0
                result[0] ^= num;  // 相同為０  不同為１
            }
            else{
                result[1] ^= num;
            }
        }
        return result;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] nums={1,2,1,3,2,5};
        int[] ans=tr.singleNumber(nums);
        for(int a:ans)
            System.out.println(a);           
    }
}