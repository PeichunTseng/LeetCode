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

//////////////////////////Mine////////////////////////////////
    public int closestValue(TreeNode root, double target) {
        double remain=Double.MAX_VALUE;
        int res=0;
        while(remain>0.5 && root!=null){
            if(Math.abs(root.val-target)<remain){
                res=root.val;
                remain=Math.abs(root.val-target);
            }
            if(target>root.val)
                root=root.right;
            else if(target<root.val)
                root=root.left;
            else
                return root.val;
        }
        return res;
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={4,2,5,1,3};
       tr.root=tr.createTree(input);
       double target = 3.714286;
       int ans=tr.closestValue(tr.root,target);
       System.out.println(ans);           
    }
}


