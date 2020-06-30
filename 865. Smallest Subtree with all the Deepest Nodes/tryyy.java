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
//////////////Same as 1123. Lowest Common Ancestor of Deepest Leaves /////////////
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

    public List <Integer> inorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList <>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        if (root != null){
          if (root.left != null){             
            helper(root.left, res);
          }
          res.add(root.val);
          if (root.right != null){
            helper(root.right, res);
          }
        }
    }
/////////////////////////////////Mine///////////////////////////////

    TreeNode res;
    int maxDepth=0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        helper(root,0);
        return res;
    }
    
    public int helper(TreeNode node, int depth){
        if(node==null)
            return depth-1;

        if(depth>maxDepth){
            res=node;
            maxDepth=depth;
        }

        int left=helper(node.left,depth+1);
        int right=helper(node.right,depth+1);

        if(left==maxDepth && right==maxDepth)
            res=node;
        
        return Math.max(left,right);
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={3,5,1,6,2,0,8,null,null,7,4};
       tr.root=tr.createTree(input);

       TreeNode ans=tr.subtreeWithAllDeepest(tr.root);
       System.out.println(ans.val);           
    }
}