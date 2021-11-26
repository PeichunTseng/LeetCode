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
public class tryyy{
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
    int total = 0;
    public int distributeCoins(TreeNode root) {
        help(root);
        return total;
    }

    public int help(TreeNode node){
        if(node.left == null && node.right == null) {
            total += Math.abs(node.val-1);
            return node.val-1;
        }
        int l = node.left == null ? 0 : help(node.left);
        int r = node.right == null ? 0 : help(node.right);

        total += Math.abs(l+r+node.val-1);
        return l+r+node.val-1;

    }
//////////////////////////////////////////////////////////

    public static void main(String[] args){
       tryyy tr = new tryyy(); 
       Integer[] input={4,0,null,null,0,null,0};
       tr.root = tr.createTree(input);
       int ans = tr.distributeCoins(tr.root);
       System.out.println(ans);           
    }
}