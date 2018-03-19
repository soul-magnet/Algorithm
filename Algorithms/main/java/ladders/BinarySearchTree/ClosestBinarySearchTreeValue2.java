package main.java.ladders.BinarySearchTree;
/**
 * 901. Closest Binary Search Tree Value II - Hard

Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

 Notice
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

Example
Given root = {1}, target = 0.000000, k = 1, return [1].

Challenge 
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

Tags: Stack Binary Search Tree Google

Related Problems 
Easy Closest Binary Search Tree Value 68 %
Easy Binary Tree Inorder Traversal 43 %
 * */

import java.util.List;

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

public class ClosestBinarySearchTreeValue2 {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
    }
}
