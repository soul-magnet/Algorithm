package main.java.ladders.BinarySearchTree;
/**
 * 93. Balanced Binary Tree - Easy

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which 
the depth of the two subtrees of every node never differ by more than 1.


Example
Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}

A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
The binary tree A is a height-balanced binary tree, but B is not.

Tags 
Divide and Conquer Recursion
Related Problems 
Medium Validate Binary Search Tree 22 %
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
public class BalancedBinaryTree {
     class result {
        public boolean balanced;
        public int depth;
        public result (boolean balanced, int depth){
            this.balanced=balanced;
            this.depth=depth;
        }
    }
    /*public boolean isBalanced(TreeNode root){
        return dfs( root).balanced;
    }

    private result dfs(TreeNode root) {
        if( root==null){
            return new result(true,0);
        }
        result l = dfs(root.left);
        result r = dfs(root.right);
        if(!l.balanced||!r.balanced){
            return new result(false,-1);//if it is not balanced then no need to record  Math.max(l.depth,r.depth), directly-1
        }
        if(Math.abs(l.depth-r.depth)>1){
            return new result(false,-1);
        }
        return new result(true, Math.max(l.depth,r.depth)+1);
    }*/
    
    //i prefer this method rather than the first solution
    
    public boolean isBalanced(TreeNode root){
        if(root == null) return true;
        int left = helper(root.left);
        int right = helper(root.right);
        
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int helper(TreeNode root){
        if (root == null) return 0;
        return Math.max(helper(root.left), helper(root.right)) + 1;
    }
    //or this is also the similar approach
    
    public boolean isBalanced(TreeNode root){
		if(root == null){
			return true;
		}
		return helper(root) > 0;
	}
	public int helper(TreeNode node){
		if(node == null){
			return 0;
		}
		
		int leftDepth = helper(node.left);
		int rightDepth = helper(node.right);
		
		if(leftDepth < 0 || rightDepth < 0 || Math.abs(leftDepth - rightDepth) > 1){
			return Integer.MIN_VALUE;
		}
		
		return Math.max(leftDepth, rightDepth) + 1;
	}
    
}
