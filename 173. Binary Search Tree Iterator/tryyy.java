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
    public tryyy() {}
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
    List<Integer> list;
    int ind;
    public tryyy(TreeNode node) {
        root=node;
        list = new ArrayList<>();
        ind=-1;
        if(root!=null)
            inOrder(root,list);
    }

    public void inOrder(TreeNode node, List<Integer> l){
        if(node.left!=null)
            inOrder(node.left,l);
        l.add(node.val);
        if(node.right!=null)
            inOrder(node.right,l);
    }
    
    /** @return the next smallest number */
    public int next() {
        ind++;
        return list.get(ind);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return ind<list.size()-1;
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       Integer[] input={7,3,15,null,null,9,20};
       tr.root=tr.createTree(input);
       tryyy trr=new tryyy(tr.root); 
       System.out.println(trr.next());    // return 3
       System.out.println(trr.next());    // return 7
       System.out.println(trr.hasNext()); // return true
       System.out.println(trr.next());    // return 9
       System.out.println(trr.hasNext()); // return true
       System.out.println(trr.next());    // return 15
       System.out.println(trr.hasNext()); // return true
       System.out.println(trr.next());    // return 20
       System.out.println(trr.hasNext()); // return false          
    }
}


