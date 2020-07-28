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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        helperPos(root,res);
        return res;
        
    }
    public void helperPos(TreeNode n,List<Integer> l){
        if(n.left!=null)
            helperPos(n.left,l);
        if(n.right!=null)
            helperPos(n.right,l);
        l.add(n.val);
    }
////////////////////////////Others//////////////////////////////
    int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        postorderIndex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i); 
        }
        return dfs(0,inorder.length-1,map,postorder);
    }

    public TreeNode dfs(int l, int r, Map<Integer,Integer> map, int[] postorder){
        if(l>r)
            return null;
        int num=postorder[postorderIndex];
        TreeNode root=new TreeNode(num);
        postorderIndex--;

        root.right=dfs(map.get(num)+1,r,map,postorder);
        root.left=dfs(l,map.get(num)-1,map,postorder);
        return root;

    }



    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       int[] inorder={9,3,15,20,7};
       int[] postorder={9,15,7,20,3};
       tr.root=tr.buildTree(inorder,postorder);

       List<Integer> ans=tr.inorderTraversal(tr.root);
       System.out.println(ans);     

       List<Integer> ans1=tr.postorderTraversal(tr.root);
       System.out.println(ans1);      
    }
}