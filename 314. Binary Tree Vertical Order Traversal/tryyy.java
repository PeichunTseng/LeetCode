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
import java.util.TreeMap;
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

///////////////////////Mine//////////////////////////////////
    class newNode{
        TreeNode node;
        int ind;
        newNode(TreeNode node, int ind){
            this.node=node;
            this.ind=ind;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        if(root==null)
            return res;
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        Queue<newNode> q = new LinkedList<>();
        q.offer(new newNode(root,0));
        while(!q.isEmpty()){
            int count=q.size();
            for(int i=0;i<count;i++){
                newNode temp=q.poll();
                map.putIfAbsent(temp.ind,new ArrayList<>());
                map.get(temp.ind).add(temp.node.val);
                if(temp.node.left!=null)
                    q.offer(new newNode(temp.node.left,temp.ind-1));
                if(temp.node.right!=null)
                    q.offer(new newNode(temp.node.right,temp.ind+1));
            }
        }
        for(List<Integer> l:map.values())
            res.add(l);
        return res;

    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        Integer[] input={3,9,8,4,0,1,7,null,null,null,2,5};
        tr.root=tr.createTree(input);

        List<List<Integer>> ans=tr.verticalOrder(tr.root);
        for(List<Integer> l:ans)
            System.out.println(l);           
    }
}