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

//////////////////////////////////////////////////////////
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

/////////////////////////Mine/////////////////////////////////
    // public boolean isCousins(TreeNode root, int x, int y){
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.offer(root);
    //     while(!q.isEmpty()){
    //         int count=q.size();
    //         Set<Integer> set = new HashSet<>();
    //         for(int i=0;i<count;i++){
    //             TreeNode temp = q.poll();
    //             Set<Integer> check = new HashSet<>();
    //             if(temp.left!=null){
    //                 set.add(temp.left.val);
    //                 check.add(temp.left.val);
    //                 q.offer(temp.left);
    //             }
    //             if(temp.right!=null){
    //                 set.add(temp.right.val);
    //                 check.add(temp.right.val);
    //                 q.offer(temp.right);
    //             }
    //             if(check.contains(x)&&check.contains(y))
    //                 return false;
    //         }
    //         if(set.contains(x)&&set.contains(y))
    //                 return true;
    //     }
    //     return false;
    // }


    /////////////////////////Mine Improve/////////////////////////////////
    public boolean isCousins(TreeNode root, int x, int y){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int count=q.size();
            boolean seeX=false;
            boolean seeY=false;
            for(int i=0;i<count;i++){
                TreeNode temp = q.poll();
                if(temp.val==x) seeX=true;
                if(temp.val==y) seeY=true;
                if(temp.left!=null && temp.right!=null){
                    if(temp.left.val==x && temp.right.val==y)
                        return false;
                    else if(temp.left.val==y && temp.right.val==x)
                        return false;
                }
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
            if(seeX && seeY)
                return true;
        }
        return false;
    }

    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       //Integer[] input={1,2,3,null,4,null,5};
       Integer[] input={1,2,3,null,4};
       tr.root=tr.createTree(input);
       // int x=5;
       // int y=4;
       int x=2;
       int y=3;
       boolean ans=tr.isCousins(tr.root,x,y);
       System.out.println(ans);           
    }

}


