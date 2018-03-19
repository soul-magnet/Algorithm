package main.java.ladders.BinaryTree;

import DataStructure.TreeNode;

/* Given a binary search tree and a new tree node, 
 * insert the node into the tree. 
 * You should keep the tree still be a valid binary search tree.
 * Challenge: Can you do it without recursion?
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
public class InsertNodeInBST {
	/**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
	// iterative
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		if (root == null)
			return node;
		TreeNode cur = root;
		TreeNode pre = null;
		while (cur != null){
			pre = cur;
			if (node.val < cur.val){
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		if (pre.val < node.val){
			pre.right = node;
		} else {
			pre.left = node;
		}
		return root;
	}
	
	// Recursive
	/*public TreeNode insertNode(TreeNode root, TreeNode node) {
		if (root == null)
			return node;
		if (node.val < root.val){
			root.left = insertNode(root.left, node);
		} else {
			root.right = insertNode(root.right, node);
		}
		
		return root;
	}*/
	

}
