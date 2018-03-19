package main.java.ladders.BinaryTree;
/**
 * 67. Binary Tree Inorder Traversal  - Easy - Required
 Description
 Notes
 Testcase
 Judge
Given a binary tree, return the inorder traversal of its nodes' values.

Have you met this question in a real interview? 
Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

return [1,3,2].

Challenge 
Can you do it without recursion?

Tags 
Recursion Binary Tree Binary Tree Traversal
Related Problems 
Easy Binary Tree Preorder Traversal 42 %
 * 
 * */
import java.util.ArrayList;
import java.util.Stack;

import DataStructure.TreeNode;

/* Analysis:
 * 
 * Solution 1: Iterative
 * 1. left child --> parent --> right child
 * 2. Use a stack to track nodes
 * 3. Understand when to push node into the stack and 
 * when to pop node out of the stack
 * */
//Definition for binary tree
/*public class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
   
   Solution 2: Recursive, trivial solution
}*/

public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (root == null)
			return result;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		// define a pointer to track nodes
		TreeNode p = root;
		
		while (!stack.empty() || p != null){
			// if it is not null, push to stack
			// and go down the tree to left
			if (p != null){
				stack.push(p);
				p = p.left;
				
				// if no left child
				// pop stack, process the node
				// then let p point to the right
		
			} else {
				TreeNode t = stack.pop();
				result.add(t.val);
				p = t.right;
			}
		}
		return result;
	}
	
	public ArrayList<Integer> inorderTraversall(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		TreeNode current = root;
		
		while (current != null || !stack.empty()){
			while (current != null) {
				stack.add(current);
				current = current.left;
			}
			current = stack.peek();
			stack.pop();
			result.add(current.val);
			current = current.right;
		}
		return result;
	}
}
