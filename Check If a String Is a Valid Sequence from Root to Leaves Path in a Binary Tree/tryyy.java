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
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
          this.val = val;
          this.left = left;
          this.right = right;
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

///////////////////////////Mine///////////////////////////////
    // public boolean isValidSequence(TreeNode root, int[] arr){
    //   return helper(root,arr,0);
    // }

    // public boolean helper(TreeNode node, int[] arr, int ind){
    //   boolean resL=false;
    //   boolean resR=false;
    //   if(arr[ind]!=node.val)
    //     return false;
    //   if(ind==arr.length-1){
    //     if(node.left!=null || node.right!=null)
    //       return false;
    //     else 
    //       return true;
    //   }
    //   if(node.left!=null && node.left.val==arr[ind+1])
    //     resL= helper(node.left,arr,ind+1);
    //   if(node.right!=null && node.right.val==arr[ind+1])
    //     resR= helper(node.right,arr,ind+1);
    //   return resL || resR;

    // }
///////////////////////////Mine Improve///////////////////////////////
    public boolean isValidSequence(TreeNode root, int[] arr){
      return helper(root,arr,0);
    }

    public boolean helper(TreeNode node, int[] arr, int ind){
      if(node==null || ind>=arr.length || node.val!=arr[ind])
        return false;
      if(ind==arr.length-1 && node.left==null && node.right==null)
        return true;
   
      return helper(node.left,arr,ind+1) || helper(node.right,arr,ind+1);
    }

//////////////////////////////////////////////////////////

    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       Integer[] input={0,1,0,0,1,0,null,null,1,0,0};
       //int[] arr={0,1,0,1};//true
       int[] arr={0,1,1};//false
       tr.root=tr.createTree(input);
       boolean ans=tr.isValidSequence(tr.root,arr);
       System.out.println(ans);           
    }

}


