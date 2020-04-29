import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
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
    public static class TreeNode 
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) 
        {
            val = x;
        }
    }

    public static TreeNode createTree(Integer[] array) 
    {
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


///////////////////////自己寫  較差///////////////////////////
    // public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    //     if(root1==null && root2==null)
    //         return true;
    //     List<TreeNode> l1= new ArrayList<>();
    //     List<TreeNode> l2= new ArrayList<>();
    //     if(root1!=null)
    //         l1.add(root1);
    //     if(root2!=null)
    //         l2.add(root2);
    //     if(l1.size()!=l2.size())
    //         return false;
    //     while(l1.size()!=0 || l2.size()!=0){
    //         int count=l1.size();
    //         Collections.sort(l1,(a,b)->a.val-b.val);
    //         Collections.sort(l2,(a,b)->a.val-b.val);
    //         for(int i=0;i<count;i++){
    //             if(l2.size()==0)
    //                 return false;
    //             TreeNode n1=l1.remove(0);
    //             TreeNode n2=l2.remove(0);
    //             if(n1.val!=n2.val)
    //                 return false;
    //             Set<Integer> set = new HashSet<>();
    //             if(n1.left!=null){
    //                 l1.add(n1.left);
    //                 set.add(n1.left.val);
    //             }
    //             if(n1.right!=null){
    //                 l1.add(n1.right);
    //                 set.add(n1.right.val);
    //             }
    //             if(n2.left!=null){
    //                 if(!set.contains(n2.left.val))
    //                     return false;
    //                 l2.add(n2.left);
    //             }
    //             if(n2.right!=null){
    //                 if(!set.contains(n2.right.val))
    //                     return false;
    //                 l2.add(n2.right);
    //             }
    //         }
    //     }
    //     return l1.size()==l2.size();
    // }

///////////////////////別人寫  較好///////////////////////////
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2)
            return true;
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }


    public static void main(String[] args) 
    {
       tryyy tr1=new tryyy(); 
       Integer[] root1={1,2,3,4,5,6,null,null,null,7,8};
       tr1.root=tr1.createTree(root1);

       tryyy tr2=new tryyy(); 
       Integer[] root2={1,3,2,null,6,4,5,null,null,null,null,8,7};
       tr2.root=tr2.createTree(root2);

       boolean ans=tr1.flipEquiv(tr1.root,tr2.root);
       System.out.println(ans);             
    }
}


