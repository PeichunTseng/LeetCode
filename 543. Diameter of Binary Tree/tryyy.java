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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root){
      dfs(root);
      return max;
      
    }

    public int dfs(TreeNode node){
        if(node==null)
            return 0;
        int left=dfs(node.left);
        int right=dfs(node.right);
        max=Math.max(max,left+right);
        return Math.max(left,right)+1;
    }


    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       Integer[] input={1,2,3,4,5};
       tr.root=tr.createTree(input);
       int ans=tr.diameterOfBinaryTree(tr.root);
       System.out.println(ans);       
    }
}