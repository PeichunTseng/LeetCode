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
////////////////////////Mine//////////////////////////////////
    // public TreeNode balanceBST(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     inOrder(root,list);
    //     for(int a:list)
    //         System.out.println(a);
    //     int l=0;
    //     int r=list.size()-1;
    //     TreeNode res=helper(list,l,r);
    //     return res;
    // }
    
    // public TreeNode helper(List<Integer> list, int l, int r){
    //     if(l==r)
    //         return new TreeNode(list.get(l));
    //     int mid=l+(r-l)/2;
    //     TreeNode node=new TreeNode(list.get(mid));
    //     if(mid-1>=l)
    //         node.left=helper(list,l,mid-1);
    //     if(mid+1<=r)
    //         node.right=helper(list,mid+1,r);
    //     return node;
    // }
    
    // public void inOrder(TreeNode node, List<Integer> l){
    //     if(node.left!=null)
    //         inOrder(node.left,l);
    //     l.add(node.val);
    //     if(node.right!=null)
    //         inOrder(node.right,l);
    // }

////////////////////////Mine Improve//////////////////////////////////
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root,list);
        int l=0;
        int r=list.size()-1;
        TreeNode res=helper(list,l,r);
        return res;
    }
    
    public TreeNode helper(List<TreeNode> list, int l, int r){
        if(l>r)
            return null;
        int mid=l+(r-l)/2;
        TreeNode node=list.get(mid);
        node.left=helper(list,l,mid-1);
        node.right=helper(list,mid+1,r);
        return node;
    }
    
    public void inOrder(TreeNode node, List<TreeNode> l){
        if(node.left!=null)
            inOrder(node.left,l);
        l.add(node);
        if(node.right!=null)
            inOrder(node.right,l);
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={1,null,2,null,3,null,4,null,null};
       tr.root=tr.createTree(input);
       List<Integer> ans=tr.inorderTraversal(tr.root);
       System.out.println(ans);  

       tr.root=tr.balanceBST(tr.root); 
       List<Integer> ans1=tr.inorderTraversal(tr.root);
       System.out.println(ans1);
    }
}