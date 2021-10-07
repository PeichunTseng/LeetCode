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
public class tryyy{
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
///////////////////////////mine/////////////////////////////
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        help(root, list, targetSum-root.val, res);
        return res;
    }

    public void help(TreeNode node, List<Integer> list, int targetSum, List<List<Integer>> res){
        if(node.left == null && node.right  == null){
            if(targetSum == 0) res.add(new ArrayList<>(list));
            return;
        }

        if(node.left != null){
            list.add(node.left.val);
            help(node.left, list, targetSum - node.left.val, res);
            list.remove(list.size()-1);
        }

        if(node.right != null){
            list.add(node.right.val);
            help(node.right, list, targetSum - node.right.val, res);
            list.remove(list.size()-1);
        }
    }


    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       Integer[] input={5,4,8,11,null,13,4,7,2,null,null,5,1};
       tr.root=tr.createTree(input);
       List<List<Integer>> ans =tr.pathSum(tr.root,22);
       System.out.println(ans);
    }
}