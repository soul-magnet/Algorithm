package main.java.ladders.BinarySearch;

import java.util.Stack;

import main.java.ladders.util.TreeNode;

/*Design an iterator over a binary search tree with the following rules:

Elements are visited in ascending order (i.e. an in-order traversal)
next() and hasNext() queries run in O(1) time in average.
Have you met this question in a real interview? Yes
Example
For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]

   10
 /    \
1      11
 \       \
  6       12
Challenge
Extra memory usage O(h), h is the height of the tree.

Super Star: Extra memory usage O(1)*/

// which data structure should we use? (stack)
// Since tree is Binary Search Tree, to get ascending order we need to take last in first out,
// So we can use this mechanism utilizing by Stack Structure
public class BinarySearchTreeItarator {
	
	public Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode current;
	
	public BinarySearchTreeItarator(TreeNode root) {
		
		while (!stack.empty()) {
			stack.pop();
		}
		current = root;
	}
	
	 //@return: True if there has next node, or false
	public boolean hasNext() {
		if (current != null || !stack.empty()) {
			return true;
		} else {
			return false;
		}
	}
	
	//@return: return next node
	public TreeNode next() {
		while (current != null){
			stack.push(current);
			current = current.left;
		}
		current = stack.peek();
		stack.pop();
		TreeNode nextNode = current;
		current = current.right;
		return nextNode;
	}
	
    

}
