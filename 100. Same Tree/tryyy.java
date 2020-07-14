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

//binary tree//
public class tryyy
{
    private TreeNode root1;
    private TreeNode root2;
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) {
            val = x;
        }

    }

    public static TreeNode createTree(Integer[] array) {
        if (array == null || array.length==0) {
            return null;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> integerQueue = new LinkedList<>();
        for (int i = 1; i < array.length; i++) {
            integerQueue.offer(array[i]);
        }

        TreeNode treeNode = new TreeNode(array[0]);
        treeNodeQueue.offer(treeNode);

        while (!integerQueue.isEmpty()){
            Integer leftVal = integerQueue.isEmpty() ? null : integerQueue.poll();
            Integer rightVal = integerQueue.isEmpty() ? null : integerQueue.poll();
            TreeNode current = treeNodeQueue.poll();
            if (leftVal !=null) {
                    TreeNode left = new TreeNode(leftVal);
                    current.left = left;
                    treeNodeQueue.offer(left);
            }
            if (rightVal !=null){
                    TreeNode right = new TreeNode(rightVal);
                    current.right = right;
                    treeNodeQueue.offer(right);
            }
        }
        return treeNode;
    }

//////////////////////////Mine////////////////////////////////
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     if(p!=null)
    //         queue.offer(p);
    //     if(q!=null)
    //         queue.offer(q);
    //     while(!queue.isEmpty()){
    //         if(queue.size()%2!=0)
    //             return false;
    //         TreeNode first= queue.poll();
    //         TreeNode sec= queue.poll();
    //         if(first.val!=sec.val)
    //             return false;
    //         if(first.left!=null)
    //             queue.offer(first.left);
    //         if(sec.left!=null)
    //             queue.offer(sec.left);
            
    //         if(queue.size()%2!=0)
    //             return false;
            
    //         if(first.right!=null)
    //             queue.offer(first.right);
    //         if(sec.right!=null)
    //             queue.offer(sec.right);
    //     }
    //     return true;
    // }
//////////////////////////Others Better////////////////////////////////
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        if(p.val!=q.val)
            return false;
        return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input1={1,2};
       Integer[] input2={1,null,2};
       tr.root1=tr.createTree(input1);
       tr.root2=tr.createTree(input2);

       boolean ans=tr.isSameTree(tr.root1,tr.root2);
       System.out.println(ans);           
    }
}