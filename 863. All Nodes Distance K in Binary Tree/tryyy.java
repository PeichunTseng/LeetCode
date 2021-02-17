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


    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x){
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

    public static TreeNode findT(TreeNode node, int tar){
        if(node==null)
            return null;
        if(node.val==tar)
            return node;
        TreeNode temp = findT(node.left,tar);
        if(temp==null)
            temp = findT(node.right,tar);
        return temp;

    }


/////////////////////////////////Others/////////////////////////////////////////
    Map<TreeNode,Integer> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        build(root,target);
        dfs(root,map.get(root),K,res);
        return res;
    }

    public int build(TreeNode root, TreeNode target){
        if(root == null)
            return -1;
        if(root == target){
            map.put(root,0);
            return 0;
        }
        int left = build(root.left,target);
        if(left >= 0){
            map.put(root,left+1);
            return left+1;
        }
        int right = build(root.right,target);
        if(right >= 0){
            map.put(root,right+1);
            return right+1;
        }
        return -1;
    }

    public void dfs(TreeNode root, int len, int k, List<Integer> res){
        if(root == null)
            return;
        if(map.containsKey(root))
            len = map.get(root);
        if(len == k)
            res.add(root.val);
        dfs(root.left, len+1, k, res);
        dfs(root.right, len+1, k, res);
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={3,5,1,6,2,0,8,null,null,7,4};
       tr.root=tr.createTree(input);
       TreeNode target = tr.findT(tr.root,5);
       //System.out.println(target.val);
       List<Integer> ans = tr.distanceK(tr.root,target,2);
       System.out.println(ans);

             
    }
}