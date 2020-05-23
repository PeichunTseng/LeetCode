import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.TreeSet;
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
    // "If two nodes have the same position, then the value of the node that is reported first is the value that is smaller."
    // This statment is ambiguous which make people think just order from small to large for each position.
    // From test case, the real requirement is:

    // If two nodes have the same position,
    // check the layer, the node on higher level(close to root) goes first
    // if they also in the same level, order from small to large
//////////////////////////Mine////////////////////////////////
    class newNode{
        TreeNode node;
        int ind;
        newNode(TreeNode node, int ind){
            this.node=node;
            this.ind=ind;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        Queue<newNode> q = new LinkedList<>();
        q.offer(new newNode(root,0));
        while(!q.isEmpty()){
            int count=q.size();
            Map<Integer,List<Integer>> inside = new HashMap<>();
            for(int i=0;i<count;i++){
                newNode temp=q.poll();
                inside.putIfAbsent(temp.ind,new ArrayList<>());
                inside.get(temp.ind).add(temp.node.val);
                set.add(temp.ind);
                if(temp.node.left!=null)
                    q.offer(new newNode(temp.node.left,temp.ind-1));
                if(temp.node.right!=null)
                    q.offer(new newNode(temp.node.right,temp.ind+1));
            }

            for(int key:inside.keySet()){
                List<Integer> list = inside.get(key);
                Collections.sort(list);
                map.putIfAbsent(key,new ArrayList<>());
                map.get(key).addAll(list);
            }
        }
        
        for(int a:set){
            res.add(map.get(a));
        }
        return res;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={1,2,3,4,5,6,7};
       tr.root=tr.createTree(input);

       List<List<Integer>> ans=tr.verticalTraversal(tr.root);
       for(List<Integer> l:ans)
        System.out.println(l);           
    }
}