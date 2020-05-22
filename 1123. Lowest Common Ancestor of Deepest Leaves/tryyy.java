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
/////////////////////////////////Others///////////////////////////////

    TreeNode res;
    int max=0; 

    public TreeNode lcaDeepestLeaves(TreeNode root){
        helper(root,0);
        return res;
    }

    public int helper(TreeNode node, int depth){
        if(node==null)
            return 0;
        // if only one node is the leaf node, tha answer is it self,  
        // so we need to update the answer node, when we meet the longest noode
        if(depth>max){
            max=depth;
            res=node;
        }

        //the longest height of left subtree 
        int left=helper(node.left,depth+1);
        //the longest height of right subtree
        int right=helper(node.right,depth+1);

        // if the height of left subtree and right subtree is same, 
        // that mean the current node is the lowest common ancestor
        if(left==max && right==max)
            res=node;

        //return the longest height of left and right subtree
        return Math.max(depth,Math.max(left,right));
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={1,2,3,4,5,6,7};
       tr.root=tr.createTree(input);

       TreeNode ans=tr.lcaDeepestLeaves(tr.root);
       System.out.println(ans.val);           
    }
}