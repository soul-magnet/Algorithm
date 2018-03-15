package main.java.ladders.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/***
 * Given a binary tree, find all paths that sum of the nodes in the path equals 
 * to a given number target.
 * A valid path is from root node to any of the leaf nodes.
 * 
 * Example
Given a binary tree, and target = 5:

     1
    / \
   2   4
  / \
 2   3
return true, as there exist root-to-leaf path 1->2->2 = 5

*/
//this version is under leetcode not in lintcode
public class BinaryTreePathSum {
	
	 /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
	
	//Solution 1: Using Queue - Breadth First Search approach
	//Thoughts: Add all node to a queue and store sum value of each node to another queue
	// When it is a leaf node, check the stored sum value
	//For the tree above, it will check node 2, 3, and 4
	public boolean binaryTreePathSum(TreeNode root, int target) {
		
		if(root == null)
			return false;
		
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> values = new LinkedList<Integer>();
		
		nodes.add(root);
		values.add(root.val);
		
		while(!nodes.isEmpty()){
			TreeNode curr = nodes.poll();
			int sumValue = values.poll();
			
			if(curr.left == null && curr.right == null && sumValue == target){
				return true;
			}
			
			if(curr.left != null){
				nodes.add(curr.left);
				values.add(sumValue + curr.left.val);
			}
			
			if(curr.right != null){
				nodes.add(curr.right);
				values.add(sumValue+curr.right.val);
			}
		}
		
		return false;
	}
	
	//Solution 2: Recursion
	public boolean hasPathSumV2(TreeNode root, int target){
		if(root == null){
			return false;
		}
		
		if(root.val == target && (root.left == null && root.right == null)){
			return true;
		}
		
		return hasPathSumV2(root.left, target - root.val) || hasPathSumV2(root.right, target-root.val);
	}

}
