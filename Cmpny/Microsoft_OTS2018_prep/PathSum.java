package Microsoft_OTS2018_prep;
/**LeetCode
 * 112. Path Sum - Easy

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Related Topics:Tree, DFS

Similar Questions 
Path Sum II
Binary Tree Maximum Path Sum
Sum Root to Leaf Numbers
Path Sum IIIPath Sum IV
 * */

import main.java.ladders.util.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
 * Analysis: The basic idea is to subtract the value of current node from sum until it reaches a leaf node and 
 * the subtraction equals 0, then we know that we got a hit. Otherwise the subtraction at the end could not be 0.
 * */
class PathSum {
	//DFS Approach
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) return false;
    	if(root.left == null && root.right == null) return sum == root.val;
    	return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        
    }
    
    public static void main(String args[]) 
    {
        int sum = 21;
         
        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
  
        if (tree.haspathSum(tree.root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
    }
}
}

