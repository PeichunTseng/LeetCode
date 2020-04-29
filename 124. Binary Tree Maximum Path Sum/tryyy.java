import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

//binary tree//
public class tryyy
{
    private TreeNode  root;
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x){
            val = x;
            left=right=null;
        }
    }

    public static TreeNode createTree(Integer[] array){
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
////////////////////////Others//////////////////////
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node){
        if(node==null)
            return 0;
        // max sum on the left and right sub-trees of node
        int leftSide=Math.max(dfs(node.left),0);
        int rightSide=Math.max(dfs(node.right),0);

        // it's totally a path 
        int currentPath=node.val+leftSide+rightSide;
        // update max sum 
        res=Math.max(res,currentPath);
        //because it can only choose one side to connect to higher node
        return node.val+Math.max(leftSide,rightSide);
    }



    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={10,9,20,null,null,15,-1};
       tr.root=tr.createTree(input);

       int ans=tr.maxPathSum(tr.root);
       System.out.println(ans);          
    }
}