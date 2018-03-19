package Google;
/**
 * 73. Construct Binary Tree from Preorder and Inorder Traversal - Google Onsite

Given preorder and inorder traversal of a tree, construct the binary tree.

 Notice
You may assume that duplicates do not exist in the tree.

Have you met this question in a real interview? Yes
Example
Given in-order [1,2,3] and pre-order [2,1,3], return a tree:

  2
 / \
1   3

Tags: Binary Tree

 * http://www.jiuzhang.com/qa/7376/
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
public class ConstructABinaryTreeFromPreorderAndInorderTraversal {
	/**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
   public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        return build(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] inorder, int il, int ir, int[] preorder, int pl, int pr) {
        if(il>ir){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int index = find (inorder,il, ir,preorder[pl] );
        root.left= build(inorder,il,index-1,preorder,pl+1,pl+1+(index-1-il));
        root.right= build(inorder,index+1,ir,preorder,pl+1+(index-il),pr);
        return root;
    }

    private int find(int[] inorder, int il, int ir, int target) {
        for (int i =il;i<=ir;i++){
            if(inorder[i]==target){
                return i;
            }
        }
        return -1;
    }

}
