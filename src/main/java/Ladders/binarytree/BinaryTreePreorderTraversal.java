package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import DataStructure.TreeNode;

/*
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Example: Given binary tree {1,#,2,3}:

1
 \
  2
 /
3
return [1,2,3].

Challenge: Can you do it without recursion?


 * Analysis: 
 * 1. What is preorder? - parent node is processed before its children
 * 2. Use Stack from Java core library
 * The key is solving this problem is using a stack to store left and right children,
 * and push right child first so that it is processed after the left child.
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
public class BinaryTreePreorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
	
	// Version 1: Non-Recursion (Recommended)
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
       Stack<TreeNode> stack = new Stack<TreeNode>();
       ArrayList<Integer> preorder = new ArrayList<Integer>();
       
       if (root == null)
    	   return preorder;
       stack.push(root);
       while (!stack.empty()){
    	   TreeNode node = stack.pop();
    	   preorder.add(node.val);
    	   if (node.right != null){
    		   stack.push(node.right);
    	   }
    	   if (node.left != null){
    		   stack.push(node.left);
    	   }
       }
       return preorder;
    }
    
    // Version 2: Divide & Conquer
    /*public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // null or leaf
        if (root == null) {
            return result;
        }
        
        // Divide
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        
     // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;

    }*/
    
    // Version 3: Traverse
    
    /*public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }*/
    


}
