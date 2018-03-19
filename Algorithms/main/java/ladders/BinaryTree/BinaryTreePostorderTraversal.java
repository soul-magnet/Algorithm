package main.java.ladders.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

import DataStructure.TreeNode;

/*
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * Example: Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

return [3,2,1].

Challenge: Can you do it without recursion?

Analysis: 
1. The order of "Postorder" is left child --> right child --> parent node
2. Find the relation between the previously visited node and the current node
3. Use a stack to track nodes
As we go down the tree to the left, check the previously visited node. 
If the current node is the left or right child of the previous node, 
then keep going down the tree and add left/right node to the stack when applicable.
When there is no children for current node, i.e the current node is a leaf,
pop it from the stack. Then the previous node become to be under the current node 
for next loop. 



*/
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
public class BinaryTreePostorderTraversal {
	 /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
	
	// Recursive
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
       ArrayList<Integer> result = new ArrayList<Integer>();
       if (root == null){
    	   return result;
       }
       
       result.addAll(postorderTraversal(root.left));
       result.addAll(postorderTraversal(root.right));
       result.add(root.val);
       
       return result;
    }
    
    // Iterative 
    public ArrayList<Integer> postorderTraversall(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode prev = null; // previously traversed node
    	TreeNode curr = root;
    	
    	if (root == null){
    		return result;
    	}
    	
    	stack.push(root);
    	while (!stack.empty()){
    		curr = stack.peek();
    		if (prev == null || prev.left == curr || prev.right == curr){
    			// traverse down to tree
    			if (curr.left != null){
    				stack.push(curr.left);
    			} else if (curr.right != null){
    				stack.push(curr.right);
    			}
    		} else if (curr.left == prev){
    			// traverse up the tree from left
    			if (curr.right != null){
    				stack.push(curr.right);
    			}
    		} else { // traverse up the tree from the right
    			result.add(curr.val);
    			stack.pop();
    			
    		}
    		prev = curr;
    	}
    	return result;
    }
}
