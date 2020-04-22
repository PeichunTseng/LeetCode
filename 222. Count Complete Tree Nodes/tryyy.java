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
//////////////////////////first mine////////////////////////////////
    // public int countNodes(TreeNode root) {
    //   if(root==null)
    //     return 0;
    //   int res=0;
    //   Queue<TreeNode> q = new LinkedList<>();
    //   q.offer(root);
    //   while(!q.isEmpty()){
    //     int count=q.size();
    //     res+=count;
    //     for(int i=0;i<count;i++){
    //       TreeNode node = q.poll();
    //       if(node.left!=null)
    //         q.offer(node.left);
    //       if(node.right!=null)
    //         q.offer(node.right);
    //     }
    //   }
    //   return res;
    // }
//////////////////////////better mine////////////////////////////////
    public int countNodes(TreeNode root) {
      if(root==null)
        return 0;
      int l=root.left==null?0:countNodes(root.left);
      int r=root.right==null?0:countNodes(root.right);
      return 1+l+r; 
    }

//////////////////////////////////////////////////////////

    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       Integer[] input={1,2,3,4,5,6};
       tr.root=tr.createTree(input);

       int ans=tr.countNodes(tr.root);
       System.out.println(ans);           
    }

}


