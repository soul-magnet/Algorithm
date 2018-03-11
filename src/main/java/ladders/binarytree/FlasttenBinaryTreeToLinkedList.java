package main.java.ladders.binarytree;
/**
 * 453. Flatten Binary Tree to Linked List 

Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.

 Notice
Don't forget to mark the left child of each node to null. 
Or you will get Time Limit Exceeded or Memory Limit Exceeded.

Have you met this question in a real interview? 
Example
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6
Challenge 
Do it in-place without any extra memory.

Tags 
Binary Tree Depth First Search
Related Problems 
Medium Flatten 2D Vector 45 %
Medium Flatten Nested List Iterator 28 %
Easy Convert Binary Tree to Linked Lists by Depth 40 %
Medium Convert Binary Search Tree to Doubly Linked List 30 %
Medium Convert Sorted List to Balanced BST 30 %
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
public class FlasttenBinaryTreeToLinkedList {
	 /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
      // public  TreeNode parentNode = null; //Total Runtime: 3441 ms
      

       public void flatten(TreeNode root) {
            dfs(root);
        /*if(root == null){
			 return;
		 }
		 
		 if(parentNode != null){
			 parentNode.left = null;
			 parentNode.right = root;
		 }
		 
		 parentNode = root;
		 TreeNode right = root.right;
		 flatten(root.left);
		 flatten(right);*/
        }

    private TreeNode dfs(TreeNode root) { //Total Runtime: 2776 ms
        if(root==null){
            return null;
        }
        if(root.left==null&&root.right==null){
            return root;
        }
        if(root.left ==null){

            return dfs( root.right);
        }
        if(root.right ==null){
            root.right=root.left;
            root.left=null;
            return dfs( root.right);
        }
        TreeNode l = dfs( root.left);
        TreeNode r = dfs( root.right);

        l.right=root.right;
        root.right=root.left;
        root.left=null;
        return r;

    }

}
