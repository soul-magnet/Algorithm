package BinarySearch;

import Ladders.TreeNode;

/*
 * Given a sorted (increasing order) array, 
 * Convert it to create a binary tree with minimal height.
 * Given [1,2,3,4,5,6,7], return

     4
   /   \
  2     6
 / \    / \
1   3  5   7
Note: There may exist multiple valid solutions, return any of them.
Tags: Recursion, BinaryTree
 * Analysis: 
 * 
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
public class ConvertSortedArrayToBinarySearchTreeWithMinimalHeight {
	 /**
     * @param A: an integer array
     * @return: a tree node
     */
	
	private TreeNode buildTree(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(num[(start + end) / 2]);
        node.left = buildTree(num, start, (start + end) / 2 - 1);
        node.right = buildTree(num, (start + end) / 2 + 1, end);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) {
            return null;
        }
        return buildTree(num, 0, num.length - 1);
    }
}
