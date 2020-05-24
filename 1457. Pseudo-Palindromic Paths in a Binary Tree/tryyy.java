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
/////////////////////////////Mine/////////////////////////////
    int res=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] arr = new int[9];
        helper(root,arr);
        return res;
    }
    
    public void helper(TreeNode node, int[] arr){
        if(node!=null)
            arr[node.val-1]++;
        if(node.left==null && node.right==null){
            if(isPalindrome(arr))
                res++;
            return;
        }
        if(node.left!=null){
            helper(node.left,arr);
            arr[node.left.val-1]--;
        }
        
        if(node.right!=null){
            helper(node.right,arr);
            arr[node.right.val-1]--;
        }
    }
    
    public boolean isPalindrome(int[] arr){
        boolean odd=false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==1 && !odd)
                odd=true;
            else if(arr[i]%2==1 && odd)
                return false;
        }
        return true;
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={2,3,1,3,1,null,1};
       tr.root=tr.createTree(input);
       int ans=tr.pseudoPalindromicPaths(tr.root);
       System.out.println(ans);           
    }
}