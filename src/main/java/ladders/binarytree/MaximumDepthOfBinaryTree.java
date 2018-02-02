package binarytree;
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
import DataStructure.TreeNode;

/* Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 * 
 * Analysis: 
 * - Recursive Solution:
 * We can solve this easily using recursion. Because each of the leftChild
 * and rightChild of a node is sub-tree itself. We first compute the max height 
 * of left sub-tree, then compute the max height of right sub tree.
 * Therefore, the max height of the current node is greater of the two heights + 1.
 * For the base case,the current node is NULL, we return zero. 
 * NULL signifies there is no tree, therefore its max height is zero.
 * */

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
	}
}
