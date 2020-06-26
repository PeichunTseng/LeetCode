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

/////////////////////////////Mine/////////////////////////////
    // int res=0;
    // public int sumNumbers(TreeNode root) {
    //     if(root==null)
    //         return 0;
    //     StringBuilder sb = new StringBuilder();
    //     help(root,sb);
    //     return res;
    // }

    // public void help(TreeNode node, StringBuilder sb){
    //     sb.append(node.val);
    //     if(node.left==null && node.right==null){
    //         res+=Integer.valueOf(sb.toString());
    //         return;
    //     }
    //     int len=sb.length();
    //     if(node.left!=null){
    //         help(node.left,sb);
    //         sb.setLength(len);
    //     }
    //     if(node.right!=null){
    //         help(node.right,sb);
    //         sb.setLength(len);
    //     }
    // }

/////////////////////////////Others Better/////////////////////////////
    public int sumNumbers(TreeNode root) {
        return help(root, 0);
    }

    private int help(TreeNode node, int currentSum) {
        if (node == null) 
            return 0;
        int sum=currentSum*10+node.val;
        if(node.left==null && node.right==null)
            return sum;
        int l=help(node.left,sum);
        int r=help(node.right,sum);
        return l+r;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={4,9,0,5,1};
       tr.root=tr.createTree(input);
       int ans=tr.sumNumbers(tr.root);
       System.out.println(ans);           
    }
}