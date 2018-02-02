package binarytree;

import DataStructure.TreeNode;

/* Given preorder and inorder traversal of a tree, 
 * construct the binary tree.
 * Example: Given in-order [1,2,3] and pre-order [2,1,3], return a tree:

  2
 / \
1   3
Note: You may assume that duplicates do not exist in the tree.

 * Analysis:
 * From the preorder array, we know that first element is the root.
 * We can find the root in inorder array. Then we can identify the left and the right
 * sub-trees in pre-order array. 
 * Recursively we can build up the tree.
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
public class ConstructBinaryTreeFromPreorderAndInorderTree {
	/**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null){
        	return null;
        }
        
        int preStart = 0;
        int preEnd = preorder.length-1;
        int inStart = 0;
        int inEnd = inorder.length-1;
        
        return helper(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }
	
	public TreeNode helper(int[] preorder, int preStart, int preEnd, 
			int[] inorder, int inStart, int inEnd){
		if(preStart>preEnd || inStart>inStart){
			return null;
		}
		
		int val = preorder[preStart];
		TreeNode p = new TreeNode(val);
		
		//find parent element indexfrom inorder
		int k=0;
		for (int i=0; i < inorder.length; i++){
			if (val == inorder[i]){
				k = i;
				break;
			}
		}
		p.left = helper(preorder, preStart + 1, preStart+(k - inStart), inorder,inStart, k-1);
		p.right = helper(preorder, preStart+(k-inStart)+1, preEnd, inorder,k+1, inEnd);
		return p;
	}
}

