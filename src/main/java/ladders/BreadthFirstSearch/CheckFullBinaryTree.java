package main.java.ladders.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 726. Check Full Binary Tree - Medium

A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. 
Conversely, there is no node in a full binary tree, which has one child node. 
More information about full binary trees can be found here.

Full Binary Tree
      1
     / \
    2   3
   / \
  4   5

Not a Full Binary Tree
      1
     / \
    2   3
   / 
  4   

Example
Given tree {1,2,3}, return true
Given tree {1,2,3,4}, return false
Given tree {1,2,3,4,5} return true

Tags:Amazon Binary Tree Breadth First Search

 * */
public class CheckFullBinaryTree {
	/*
     * @param : the given tree
     * @return: Whether it is a full tree
     */
	//recursive solution
    public boolean isFullTree1(TreeNode root) {
        // write your code here
    	
    	 if(root == null || root.val == 0) return true;
    	 
    	 if((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
    		 return false;
    	 }
     	
     	 boolean isLeft = isFullTree(root.left);
     	 boolean isRight = isFullTree(root.right);
     
     	return isLeft&&isRight;
    }
    
    //BFS Solution
    public boolean isFullTree(TreeNode root) {
        // write your code here
    	
    	 Queue<TreeNode>  queue = new LinkedList<>();
         queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                if (curr.right == null) {
                    return false;
                } else {
                    queue.offer(curr.left);
                } 
            }

            if (curr.right != null) {
                if (curr.left == null) {
                    return false;
                } else {
                    queue.offer(curr.right);
                }
            }
        }
        return true;
    }

}
