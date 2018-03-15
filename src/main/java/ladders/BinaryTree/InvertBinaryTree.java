package main.java.ladders.BinaryTree;

import java.util.LinkedList;

import DataStructure.TreeNode;

/*
  1         1
 / \       / \
2   3  => 3   2
   /       \
  4         4
  
Challenge: Do it in recursion is acceptable, 
can you do it without recursion?

*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class InvertBinaryTree {
	/**
    * @param root: a TreeNode, the root of the binary tree
    * @return: nothing
    */
	// version 1: Recursive
   public void invertBinaryTree(TreeNode root) {
       if (root == null){
    	   return;
       }
       TreeNode temp = root.left;
       root.left = root.right;
       root.right = temp;
       
       invertBinaryTree(root.left);
       invertBinaryTree(root.right);
   }
   
   // version 2: Iterative
   public void invertBinaryTree2(TreeNode root){
	   LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	   if (root != null){
		   queue.add(root);
	   }
	   while (!queue.isEmpty()){
		   TreeNode p = queue.poll();
		   if (p.left != null)
			   queue.add(p.left);
		   if (p.right != null)
			   queue.add(p.right);
		   TreeNode temp = p.left;
		   p.left = p.right;
		   p.right = temp;
	   }
   }
}
