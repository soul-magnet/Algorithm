package Microsoft_OTS2018_prep;
/**LeetCode
 * 112. Path Sum - Easy

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Related Topics:Tree, DFS

Similar Questions 
Path Sum II
Binary Tree Maximum Path Sum
Sum Root to Leaf Numbers
Path Sum IIIPath Sum IV
 * */

import main.java.ladders.util.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
 * Analysis: The basic idea is to subtract the value of current node from sum until it reaches a leaf node and 
 * the subtraction equals 0, then we know that we got a hit. Otherwise the subtraction at the end could not be 0.
 * */
class PathSum {
	//DFS Approach
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) return false;
    	if(root.left == null && root.right == null) return sum == root.val;
    	return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        
    }
}

