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
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) {
            val = x;
        }

    }

    private TreeNode createTree(Integer[] array) {
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

    private TreeNode findNode(TreeNode node, int value){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.val==value)
                return temp;
            if(temp.left!=null)
                q.offer(temp.left);
            if(temp.right!=null)
                q.offer(temp.right);
        }
        return node;
    }

////////////////////////////Mine//////////////////////////////
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode first, TreeNode sec) {
    //     Map<TreeNode,TreeNode> map = new HashMap<>();
    //     bulidGrapth(root,map);
    //     Set<Integer> set =new HashSet<>();
    //     findFirstPath(first,set,map);
    //     while(map.containsKey(sec)){
    //         if(set.contains(sec.val))
    //             return sec;
    //         sec=map.get(sec);
    //     }
    //     return root;
    // }

    // private void bulidGrapth(TreeNode node, Map<TreeNode,TreeNode> map){
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.offer(node);
    //     while(!q.isEmpty()){
    //         TreeNode temp=q.poll();
    //         if(temp.left!=null){
    //             map.put(temp.left,temp);
    //             q.offer(temp.left);
    //         }
    //         if(temp.right!=null){
    //             map.put(temp.right,temp);
    //             q.offer(temp.right);
    //         }
    //     }
    // }

    // private void findFirstPath(TreeNode first, Set<Integer> set, Map<TreeNode,TreeNode> map){
    //     set.add(first.val);
    //     TreeNode next=map.get(first);
    //     if(map.containsKey(next))
    //         findFirstPath(next,set,map);
    // }


////////////////////////////Others better//////////////////////////////
    private TreeNode ans;

    public tryyy() {
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }


//////////////////////////////////////////////////////////
    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={3,5,1,6,2,0,8,null,null,7,4};
       tr.root=tr.createTree(input);
       TreeNode first=tr.findNode(tr.root,5);
       TreeNode sec=tr.findNode(tr.root,1);

       TreeNode ans=tr.lowestCommonAncestor(tr.root,first,sec);
       System.out.println(ans.val);           
    }
}