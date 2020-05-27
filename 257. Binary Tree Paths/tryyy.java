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
//////////////////////////////Mine////////////////////////////
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null)
            return res;
        StringBuilder sb = new StringBuilder();
        dfs(root,sb,res);
        return res;
    }

    public void dfs(TreeNode node, StringBuilder sb, List<String> res){
        sb.append("->");
        sb.append(node.val);
        int len=sb.length();
        if(node.left==null && node.right==null){
            res.add(sb.toString().substring(2));
            return;
        }
        if(node.left!=null){
            dfs(node.left,sb,res);
            sb.setLength(len);
        }
        if(node.right!=null){
            dfs(node.right,sb,res);
            sb.setLength(len);
        }
    }



    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={1,2,3,null,5};
       tr.root=tr.createTree(input);
       List<String> ans=tr.binaryTreePaths(tr.root);
       System.out.println(ans);           
    }
}