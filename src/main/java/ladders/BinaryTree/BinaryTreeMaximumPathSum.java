package main.java.ladders.BinaryTree;

import DataStructure.TreeNode;

/* Given a binary tree, find the maximum path sum. 
 * The path may start and end at any node in the tree. 
 * For example, given the below binary tree

       1
      / \
     2   3
the result is 6.

Analysis: 
	1) Recursively solve this problem
	2) Get largest left sum and right sum
	2) Compare to the stored maximum

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
public class BinaryTreeMaximumPathSum {
	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
	
	// single path:
	// max Path;
	int singlePath, maxPath;
	
    public BinaryTreeMaximumPathSum(int singlePath, int maxPath) {
		super();
		this.singlePath = singlePath;
		this.maxPath = maxPath;
	}
    
    private BinaryTreeMaximumPathSum helper(TreeNode root){
    	if (root == null){
    		return new BinaryTreeMaximumPathSum(0, Integer.MIN_VALUE);
    	}
    	// Divide
    	BinaryTreeMaximumPathSum left = helper(root.left);
    	BinaryTreeMaximumPathSum right = helper(root.right);
    	
    	// Conquer
    	int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
    	singlePath = Math.max(singlePath, 0);
    	int maxPath = Math.max(left.maxPath, right.maxPath);
    	maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
    	
    	return new BinaryTreeMaximumPathSum(singlePath, maxPath);
    }

	public int maxPathSum(TreeNode root) {
		BinaryTreeMaximumPathSum result = helper(root);
		return result.maxPath;
    }
	
	/*
	 public int maxPathSum(TreeNode root) {
		int max[] = new int[1]; 
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}
 
	public int calculateSum(TreeNode root, int[] max) {
		if (root == null)
			return 0;
	 
		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);
	 
		int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
	 
		max[0] = Math.max(max[0], Math.max(current, left + root.val + right));
	 
		return current;
		
		}*/
	
	
	//Updated recursive solution
	int maxValue = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root){
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
