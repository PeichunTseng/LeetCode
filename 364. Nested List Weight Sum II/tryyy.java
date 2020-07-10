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
///////////////////////////Mine///////////////////////////////
    // public int depthSumInverse(List<NestedInteger> nestedList) {
    //     Map<Integer,Integer> map = new HashMap<>();
    //     int level=1;
    //     Queue<NestedInteger> q =new LinkedList<>();
    //     for(NestedInteger ni:nestedList){
    //         q.offer(ni);
    //     }

    //     while(!q.isEmpty()){
    //         int count=q.size();
    //         int sum=0;
    //         for(int i=0;i<count;i++){
    //             NestedInteger temp=q.poll();
    //             if(temp.isInteger()){
    //                 sum+=temp.getInteger();
    //             }
    //             else{
    //                 for(NestedInteger ni:temp.getList())
    //                     q.offer(ni);
    //             }
    //         }

    //         map.put(level,sum);
    //         level++;
    //     }
    //     int res=0;
    //     for(int key:map.keySet()){
    //         int v=map.get(key);
    //         res+=(v*(level-key));
    //     }
    //     return res;
        
    // }

///////////////////////////Mine Improve///////////////////////////////
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int res=0;
        Queue<NestedInteger> q =new LinkedList<>();
        for(NestedInteger ni:nestedList){
            q.offer(ni);
        }

        int pre=0;
        while(!q.isEmpty()){
            int count=q.size();
            int sum=0;
            for(int i=0;i<count;i++){
                NestedInteger temp=q.poll();
                if(temp.isInteger()){
                    sum+=temp.getInteger();
                }
                else{
                    for(NestedInteger ni:temp.getList())
                        q.offer(ni);
                }
            }
            res+=(pre+sum);
            pre=pre+sum;
        }
        return res; 
    }



    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={1,3,2,5,null,null,9,6,null,null,7};
       tr.root=tr.createTree(input);
       int ans=tr.widthOfBinaryTree(tr.root);
       System.out.println(ans);           
    }
}