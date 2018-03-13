package main.java.ladders.BinarySearchTree;
/**
 * 94. Binary Tree Maximum Path Sum - Medium

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example
Given the below binary tree:

  1
 / \
2   3
return 6.

Tags 
Divide and Conquer Recursion Dynamic Programming
Related Problems 
Medium Binary Tree Maximum Path Sum II 44 %
Easy Binary Tree Path Sum II 27 %
Easy Minimum Path Sum 35 %
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
public class BinaryTreeMaximumPathSum {
  
    int maxValue = Integer.MIN_VALUE; 
    public int maxPathSum(TreeNode root) {
       
       helper(root);
        
    	return maxValue;
    	
    
    }
    
    private int helper(TreeNode node){
       if(node == null) return 0;
       
       int left = Math.max(0, helper(node.left));
       int right = Math.max(0, helper(node.right));
       
       maxValue = Math.max(maxValue, left + right + node.val);
       return Math.max(left, right) + node.val;
    }
    
    
    
}

