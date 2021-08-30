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
        public TreeNode(int x) { val = x; }
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
////////////////////////////Mine//////////////////////////////
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
      TreeNode res = null;
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);
      while(!q.isEmpty()){
        int count = q.size();
        TreeNode temp = q.poll();
        if(temp.val>p.val){
          if(res==null || temp.val<res.val) res=temp;
          if(temp.left!=null) q.offer(temp.left);
        }
        else if(temp.right!=null) q.offer(temp.right);
      }
      return res;
    }
//////////////////////////////////////////////////////////

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={2,1,3};
       tr.root=tr.createTree(input);

       TreeNode ans=tr.inorderSuccessor(tr.root,tr.root.left);
       System.out.println(ans.val);           
    }
}