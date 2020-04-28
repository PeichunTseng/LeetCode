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

    public List <Integer> inorderTraversal(TreeNode root){
        List <Integer> res = new ArrayList <>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res){
        if (root != null) 
        {
            if (root.left != null) 
            {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) 
            {
                helper(root.right, res);
            }
        }
    }


////////////////////////////自己寫 較差//////////////////////////////

  // Map<Integer,Integer> map = new HashMap<>();
  // int preIndex=0;
  // public TreeNode bstFromPreorder(int[] preorder){
  //   int[] inorder=Arrays.copyOf(preorder,preorder.length);
  //   Arrays.sort(inorder);
  //   for(int i=0;i<inorder.length;i++)
  //     map.put(inorder[i],i);
  //   return help(inorder,preorder,0,inorder.length-1);

  // }

  // public TreeNode help(int[] in, int[] pre, int s, int e){
  //   if(e<s)
  //     return null;
  //   TreeNode node= new TreeNode(pre[preIndex]);
  //   int ind=map.get(pre[preIndex]);
  //   preIndex++;
  //   if(s==e)
  //     return node;
  //   node.left=help(in,pre,s,ind-1);
  //   node.right=help(in,pre,ind+1,e);
  //   return node;
  // }

  /////////////////////////////別人寫 較好/////////////////////////////
  int ind=0;
  public TreeNode bstFromPreorder(int[] preorder){
      return help(preorder,Integer.MAX_VALUE);
  }

  public TreeNode help(int[] pre, int bound){
      if(ind>=pre.length || pre[ind]>bound)
          return null;
      TreeNode node= new TreeNode(pre[ind++]);
      node.left=help(pre,node.val);
      node.right=help(pre,bound);
      return node;
    
  }






    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       int[] preorder={8,5,1,7,10,12};
       //int[] preorder={8,5,9};

       tr.root=tr.bstFromPreorder(preorder);

       List<Integer> ans=tr.inorderTraversal(tr.root);//1, 5, 7, 8, 10, 12
       System.out.println(ans);

             
    }



}


