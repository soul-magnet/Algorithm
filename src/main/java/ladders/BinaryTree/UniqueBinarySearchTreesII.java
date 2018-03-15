package main.java.ladders.BinaryTree;

import java.util.ArrayList;
import java.util.List;

import DataStructure.TreeNode;

/*
 * Given n, generate all structurally unique BST’s (binary search trees) 
 * that store values 1…n.
 * For example: Given n = 3, your program should return all 5 unique 
 * BST’s shown below.
 * 1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   Analysis:
   
  -There are n possible values for the root. Then for the left or right node of the root,
   there will also be different cases, and so forth.
  -So each root case is explores=d recursively with all possible combinations
  of left and right children.
  -Then each root case will be recalled where it is the left or right child of other roots.
  
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
public class UniqueBinarySearchTreesII {
	/**
     * @paramn n: An integer
     * @return: A list of root
     */
	public ArrayList<TreeNode> generateTrees(int n) {
	    return helper(1,n);
	}
	private ArrayList<TreeNode> helper(int left, int right)
	{
	    ArrayList<TreeNode> res = new ArrayList<TreeNode>();
	    if(left>right)
	    {
	        res.add(null);
	        return res;
	    }
	    for(int i=left;i<=right;i++)
	    {
	        ArrayList<TreeNode> leftList = helper(left,i-1);
	        ArrayList<TreeNode> rightList = helper(i+1,right);
	        for(TreeNode l : leftList)
	        {
	            for(TreeNode r: rightList)
	            {
	            	// should new a root here because it need to 
	            	// be different for each tree
	                TreeNode root = new TreeNode(i);
	                root.left = l;
	                root.right = r;
	                res.add(root);
	            }
	        }
	    }
	    return res;
	}
}
