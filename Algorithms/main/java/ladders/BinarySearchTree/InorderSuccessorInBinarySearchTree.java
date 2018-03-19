package main.java.ladders.BinarySearchTree;
/**
 * 448. Inorder Successor in Binary Search Tree - Medium

Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

If the given node has no in-order successor in the tree, return null.

 Notice
It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)


Example
Given tree = [2,1] and node = 1:

  2
 /
1
return node 2.

Given tree = [2,1,3] and node = 2:

  2
 / \
1   3
return node 3.

Challenge 
O(h), where h is the height of the BST.

Tags: Binary Search Tree Binary Tree

Related Problems 
Medium BST Swapped Nodes 14 %
Medium Validate Binary Search Tree 22 %
Hard Binary Search Tree Iterator 36 %
 * */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InorderSuccessorInBinarySearchTree {
    /*public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null) {
            return null;
        }
        TreeNode up = null;
        while (root != null && root != p) {
            if (root.val > p.val) {
                up = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }


        if (root == null){
            return null;
        }
        if(root.right==null){
            return up;
        }
        root = root.right;
        while( root.left!=null){
            root= root.left;
        }
        return root;
    }*/
    
    //recursive soulution
   public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        if(root == null) return null;
        
        if(root.val <= p.val){
            return inorderSuccessor(root.right, p);
        }else{
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }
    
    /*The inorder traversal of a BST is the nodes in ascending order. To find a successor, you just need to find the smallest one that is larger than the given value since there are no duplicate values in a BST. It just like the binary search in a sorted list. The time complexity should be O(h) where h is the depth of the result node. succ is a pointer that keeps the possible successor. Whenever you go left the current root is the new possible successor, otherwise the it remains the same.

Only in a balanced BST O(h) = O(log n). In the worst case h can be as large as n.
    */
    //O(h)time - elegant
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        
        while(root != null){
            if(p.val < root.val){
                succ = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return succ;
    }
    
    //same thing for predessor
    /*public TreeNode predecessor(TreeNode root, TreeNode p){
		if (root == null)
            return null;
        
          if (root.val >= p.val) {
            return predecessor(root.left, p);
          } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
          }
	 }*/
}