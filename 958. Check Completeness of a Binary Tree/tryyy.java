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
    private TreeNode  root;
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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null)
            return true;
        boolean flag=false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                if(flag)
                    return false;
                q.offer(node.left);
            }
            else
                flag=true;
            if(node.right!=null){
                if(flag)
                    return false;
                q.offer(node.right);
            }
            else
                flag=true;
        }
        return true;
    }


//////////////////////////Others////////////////////////////////
    // public boolean isCompleteTree(TreeNode root) {
    //     if(root==null)
    //         return true;
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.offer(root);
    //     while(q.peek()!=null){
    //         TreeNode node=q.poll();
    //         q.offer(node.left);
    //         q.offer(node.right);
    //     }
    //     while(!q.isEmpty() && q.peek()==null)
    //         q.poll();
    //     return q.isEmpty();
    // }



    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={1,2,3,4,5,null,7};
       tr.root=tr.createTree(input);
       boolean ans=tr.isCompleteTree(tr.root);
       System.out.println(ans);           
    }
}