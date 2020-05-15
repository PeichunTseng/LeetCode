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

//////////////////////Mine/////////////////////////
    // public int rangeSumBST(TreeNode root, int L, int R) {
    //     int res=0;
    //     if(root.val>=L && root.val<=R)
    //         res+=root.val;
    //     if(root.left!=null)
    //         res+=rangeSumBST(root.left,L,R);
    //     if(root.right!=null)
    //         res+=rangeSumBST(root.right,L,R);
    //     return res;
    // }

///////////////////////Mine  improve/////////////////////
    public int rangeSumBST(TreeNode root, int L, int R) {
        int res=0;
        if(root.val>=L && root.val<=R)
            res+=root.val;
        if(root.left!=null && root.val>L)
            res+=rangeSumBST(root.left,L,R);
        if(root.right!=null && root.val<R)
            res+=rangeSumBST(root.right,L,R);
        return res;
    }

    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       Integer[] input={10,5,15,3,7,null,18};
       tr.root=tr.createTree(input);
       int L=7;
       int R=15;
       int ans=tr.rangeSumBST(tr.root,L,R);
       System.out.println(ans);           
    }

}