package Ladders;

import java.util.ArrayList;
import java.util.Stack;
/*
Given a binary tree, return the preorder traversal of its nodes' values.
Example
Given binary tree {1,#,2,3}:

1
 \
  2
 /
3
return [1,2,3].
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

public class BinaryTreePreorderTraversal {
 
	/**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> preorder = new ArrayList<Integer>();
        
        if (root == null){
            return preorder;
        }
        
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
}
