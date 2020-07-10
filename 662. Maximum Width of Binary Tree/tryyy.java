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
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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
///////////////////////////Mine///////////////////////////////
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        Queue<Integer> num= new LinkedList<>();
        Queue<TreeNode> q= new LinkedList<>();
        num.offer(1);
        q.offer(root);
        int res=0;
        while(!q.isEmpty()){
            int count=q.size();
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int i=0;i<count;i++){
                TreeNode temp=q.poll();
                int a=num.poll();
                min=Math.min(min,a);
                max=Math.max(max,a);
                if(temp.left!=null){
                    q.offer(temp.left);
                    num.offer(2*a);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                    num.offer(2*a+1);
                }
            }
            res=Math.max(max-min+1,res);
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