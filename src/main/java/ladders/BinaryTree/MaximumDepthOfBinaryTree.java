package main.java.ladders.BinaryTree;
/**
 * 97. Maximum Depth of Binary Tree - Easy - Required

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Have you met this question in a real interview? 
Example
Given a binary tree as follow:

  1
 / \ 
2   3
   / \
  4   5
The maximum depth is 3.

Tags 
Divide and Conquer Recursion Binary Tree Uber
Related Problems 
Medium Binary Tree Leaves Order Traversal 43 %
Easy Minimum Depth of Binary Tree 31 %
 * */

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
public class MaximumDepthOfBinaryTree {
	 public int maxDepth(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        //divide and conquer
	        int left = maxDepth(root.left);
	        int right = maxDepth(root.right);
	        return Math.max(left, right) + 1;
	    }

}
