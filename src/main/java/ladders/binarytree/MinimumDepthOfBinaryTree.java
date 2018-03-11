package main.java.ladders.binarytree;

import java.util.LinkedList;
/* Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path 
 * from the root node down to the nearest leaf node.
 * 
 */

import binarytree.TreeNode;

/* Analysis: 
* - Recursive Solution:
* We can solve this easily using recursion. Because each of the leftChild
* and rightChild of a node is sub-tree itself. We first compute the max height 
* of left sub-tree, then compute the max height of right sub tree.
* Therefore, the max height of the current node is greater of the two heights + 1.
* For the base case,the current node is NULL, we return zero. 
* NULL signifies there is no tree, therefore its max height is zero.
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

public class MinimumDepthOfBinaryTree {
	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
	
	/*Recursive Approach*/
    public int minDepth(TreeNode root) {
        if (root == null)
        	return 0;
        if (root.left == null)
        	return minDepth(root.right) + 1;
        if (root.right == null)
        	return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
	
	//recursive -version 2
	public int minDepth(TreeNode root){
		if(root == null) return 0;
		return dfs(root);
	}
	
	public int dfs(TreeNode root){
		if(root == null) return Integer.MAX_VALUE;
		
		//base case: if the root is a leaf
		if(root.left == nulll && root.right == null) return 1;
		
		return Math.min(dfs(root.left), dfs(root.right) + 1);
			
	}
    
    /* Non_Recursive Traversal Solution uses the same sequence
     * Corresponding figure BFS, but at the time of first leaf can return the following code 
     * LinkedList is a queue in Java.
     * The add() and remove() methods are used to manipulate the queue*/
    
    /*public int minDepth(TreeNode root){
    	if (root == null)
    		return 0;
    	LinkedList queue = new LinkedList();
    	int currentNumber = 0;
    	int lastNumber = 1;
    	int level = 1;
    	queue.offer(root);
    	while (!queue.isEmpty()){
    		TreeNode curr = (TreeNode) queue.poll();
    		if (curr.left == null && curr.right == null)
    			return level;
    		lastNumber--;
    		if (curr.left != null){
    			queue.offer(curr.left);
    			currentNumber++;
    		}
    		if (curr.right != null){
    			queue.offer(curr.right);
    			currentNumber++;
    		}
    		if (lastNumber  == 0){
    			lastNumber = currentNumber;
    			currentNumber = 0;
    			level++;
    		}
    		
    	}
    	return 0;
    }
	*/
    /*same version different implementation for BFS approach*/ 
    /*public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
        
        nodes.add(root);
        counts.add(1);
        
        while (!nodes.isEmpty()){
        	TreeNode curr  = nodes.remove();
        	int count = counts.remove();
        	
        	if (curr.left != null){
        		nodes.add(curr.left);
        		counts.add(count + 1);
        	}
        	
        	if (curr.right != null){
        		nodes.add(curr.right);
        		counts.add(count + 1);
        	}
        	if (curr.left == null && curr.right == null){
        		return count;
        	}
        	
        }
        
        return 0;
        
    }*/
	
	//Another version
	public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
	}
	
}
