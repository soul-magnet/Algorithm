package binarytree;

import java.util.LinkedList;

import DataStructure.TreeNode;

/*
 * Design an iterator over a binary search tree with the following rules:
 * Elements are visited in ascending order (i.e. an in-order traversal)
 * next() and hasNext() queries run in O(1) time in average.
 * Example: For the following binary search tree, in-order traversal by using iterator is[1, 6, 10, 11, 12]


   10
 /    \
1      11
 \       \
  6       12

Challenge: Extra memory usage O(h), h is the height of the tree.

Super Star: Extra memory usage O(1)*/
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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BinarySearchTreeIterator {
	//@param root: The root of binary tree.
	private LinkedList<TreeNode> stack;
	private TreeNode current;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new LinkedList<TreeNode>();
        current = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return (current != null || !stack.isEmpty());
    }
    
    //@return: return next node
    public TreeNode next() {
        while (current != null){
        	stack.push(current);
        	current = current.left;
        }
        
        current = stack.pop();
        TreeNode res = current;
        current = current.right;
        return res;
    }
    /* More clear implementation
      Stack<TreeNode> stack;
 
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
 
	public boolean hasNext() {
		return !stack.isEmpty();
	}
 
	public int next() {
		TreeNode node = stack.pop();
		int result = node.val;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}*/
}
