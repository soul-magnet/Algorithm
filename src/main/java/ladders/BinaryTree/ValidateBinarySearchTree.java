package main.java.ladders.BinaryTree;

/**
 * 95. Validate Binary Search Tree - Medium - Required

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
Divide and Conquer Recursion Binary Tree Binary Search Tree
Related Problems 
Medium BST Swapped Nodes 14 %
Medium Inorder Successor in Binary Search Tree 33 %
Easy Balanced Binary Tree 37 %
 * */
/* Analysis:
- All values on the left subtree must be less than root
- and all values on right subtree must be grater than root.
- so we just check the boundaries for each node.
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
public class ValidateBinarySearchTree {
	/**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
    	return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
       
    }
    
    public boolean isValidBST(TreeNode p, double min, double max){
    	if (p==null)
    		return true;
    	if (p.val <= min || p.val >= max){
    		return false;
    	}
    	
    	return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
    }
    
    // Version 1.2: Traverse
    private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;
    public boolean isValidBST2(TreeNode root) {
    	if (root == null) {
    		return true;
    	}
    	
    	if (!isValidBST(root.left)){
    		return false;
    	}
    	
    	if (!firstNode && lastVal >= root.val){
    		return false;
    	}
    	
    	firstNode = false;
    	lastVal = root.val;
    	if (isValidBST(root.right)){
    		return false;
    	}
    	return true;
    }
    // Version 2: Divide and Conquer
    
    public boolean isValidBST3(TreeNode root) {
    	ResultType r = validateHelper(root);
    	return r.is_bst;
    }
    
    private ResultType validateHelper(TreeNode root) {
    	if (root == null) {
    		return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
    		ResultType left = validateHelper(root.left);
    		ResultType right = validateHelper(root.right);
    		if (!left.is_bst || !right.is_bst) {
    			// id is_bst is false then minValue and maxValue are useless
    			return new ResultType(false, 0, 0);
    		}
    		return new ResultType(false, 0, 0);
    	}
    	return new ResultType(true,
    			Math.max(root.val, right.MaxValue),
    			Math.min(root.val, left.minValue));
    }
}

class ResultType {
	boolean is_bst;
	int maxValue, minValue;
	
	ResultType(boolean is_bst, int maxValue, int minValue){
		this.is_bst = is_bst;
		this.maxValue = maxValue;
		this.minValue = minValue;
	}
}
