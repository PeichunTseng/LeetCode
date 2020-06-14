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
/////////////////////////Mine Time Limit/////////////////////// 
    // List<Integer> res = new ArrayList<>();
    // public List<Integer> largestDivisibleSubset(int[] nums) {
    //     Arrays.sort(nums);
    //     int largest=0;
    //     for(int i=0;i<nums.length;i++){
    //         List<Integer> temp = new ArrayList<>();
    //         temp.add(nums[i]);
    //         helper(nums, temp, i);
    //     }
    //     return res;
    // }
    
    // public void helper(int[] arr, List<Integer> list, int index){
    //     if(index==arr.length-1){
    //         if(list.size()>res.size())
    //             res=new ArrayList<>(list);
    //         return;
    //     }
    //     for(int i=index+1;i<arr.length;i++){
    //         if(arr[i]%list.get(list.size()-1)==0){
    //             list.add(arr[i]);
    //             helper(arr,list,i);
    //             list.remove(list.size()-1);
    //         }
    //     }
    //     if(list.size()>res.size())
    //             res=new ArrayList<>(list);
    // }
/////////////////////////Others Better/////////////////////// 
    // public List<Integer> largestDivisibleSubset(int[] nums) {
    //     if(nums.length==0)
    //         return new ArrayList<>();
    //     Arrays.sort(nums);
    //     List<Integer>[] dp=new ArrayList[nums.length];
    //     int resIndex=-1;
    //     int resSize=0;
    //     for(int i=0;i<nums.length;i++){
    //         int tempIndex=-1;
    //         int tempSize=0;
    //         dp[i]=new ArrayList<>();
    //         for(int j=i-1;j>=0;j--){
    //             if(nums[i]%nums[j]==0){
    //                 if(dp[j].size()>tempSize){
    //                     tempSize=dp[j].size();
    //                     tempIndex=j;
    //                 }
    //             }
    //         }
    //         if(tempSize!=0)
    //           dp[i]=new ArrayList(dp[tempIndex]);
    //         dp[i].add(nums[i]);
    //         if(dp[i].size()>resSize){
    //             resSize=dp[i].size();
    //             resIndex=i;
    //         }
    //     }
    //     return dp[resIndex];
    // }
/////////////////////////Others Best/////////////////////// 
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<Integer>();
        }
        
        Arrays.sort(nums);
        int[] sizes = new int[nums.length];
        int[] prevs = new int[nums.length];
        int maxidx = 0;
        for (int i = 0; i < nums.length; i++) {
            sizes[i] = 1;
            prevs[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && sizes[i] < sizes[j]+1) {
                    sizes[i] = sizes[j]+1;
                    prevs[i] = j;
                }
            }
            if (sizes[i] > sizes[maxidx]) {
                maxidx = i;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = maxidx; i != -1; i = prevs[i]) {
            list.add(nums[i]);
        }
        return list;
        
    }
    

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        int[] nums={1,3,9,18,54,108,540,90,180,360,720};
        //1,3,9,18,54,108,540
        //1,3,9,18,90,180,360,720
        List<Integer> ans=tr.largestDivisibleSubset(nums);
        System.out.println(ans);         
    }
}