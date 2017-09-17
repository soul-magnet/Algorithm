package binarytree;

import BinarySearch.TreeNode;

/*
 * Given a binary search tree and a node in it, 
 * find the in-order successor of that node in the BST.
 * Example: Given tree = [2,1] and node = 1:

  2
 /
1
return node 2.

Given tree = [2,1,3] and node = 2:

  2
 / \
1   3
return node 3.

Note
If the given node has no in-order successor in the tree, return null.*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InorderSuccessorInBST {
	 public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	        TreeNode successor = null;
	        while (root != null && root.val != p.val){
	        	if (root.val > p.val){
	        		successor = root;
	        		root = root.left;
	        	} else {
	        		root = root.right;
	        	}
	        }
	        
	        if (root == null)
	        	return null;
	        if (root.right == null)
	        	return successor;
	        root = root.right;
	        while (root.left != null)
	        	root = root.left;
	        return root;
	    }
	
	
	//recursive solution
	public TreeNode successor(TreeNode root, TreeNode p) {
	  if (root == null)
	    return null;

	  if (root.val <= p.val) {
	    return successor(root.right, p);
	  } else {
	    TreeNode left = successor(root.left, p);
	    return (left != null) ? left : root;
	  }
	}
	//Predecessor - recursive solutuion

	public TreeNode predecessor(TreeNode root, TreeNode p) {
	  if (root == null)
	    return null;

	  if (root.val >= p.val) {
	    return predecessor(root.left, p);
	  } else {
	    TreeNode right = predecessor(root.right, p);
	    return (right != null) ? right : root;
	  }
	}
}
