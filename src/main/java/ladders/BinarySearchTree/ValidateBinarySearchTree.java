package main.java.ladders.BinarySearchTree;
/**
 * 95. Validate Binary Search Tree - Medium

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST

Example
An example:

  2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).

Tags 
Divide and Conquer Binary Search Tree Binary Tree Recursion
Related Problems 
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
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        // Just use the inOrder traversal to solve the problem.
        if (root == null) {
            return true;
        }
        
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean dfs(TreeNode root, long low, long up) {
        if (root == null) {
            return true;
        }
        
        if (root.val >= up || root.val <= low) {
            return false;
        }
        
        return dfs(root.left, low, root.val) 
           && dfs(root.right, root.val, up);
    }
}

