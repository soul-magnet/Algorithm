package binarytree;

import DataStructure.TreeNode;

/* Design an algorithm and write code to serialize and deserialize a binary tree. 
 * Writing the tree to a file is called 'serialization' and reading back 
 * from the file to reconstruct the exact same binary tree is 'deserialization'.
 * There is no limit of how you deserialize or serialize a binary tree, 
 * you only need to make sure you can serialize a binary tree to a string 
 * and deserialize this string to the original structure.
 * An example of testdata: Binary tree {3,9,20,#,#,15,7}, 
 * denote the following structure:

  3
 / \
9  20
  /  \
 15   7
* Our data serialization use bfs traversal. 
* This is just for when you got wrong answer and want to debug the input.
* You can use other method to do serializaiton and deserialization.
 * 
 * 
 * Analysis: 
 * Is given Tree is Binary Search Tree?
 * If the given tree is BST, we can store it by using either preorder or postorder traversal.
 * In case of BST, only preorder or post order traversal is sufficient to store structure information.
 * 
 * If given Binary Tree is Complete Tree?
 * A Binary Tree is complete if all levels are completely filled except possibly the last level
 * and all nodes of last level are as left as possible. (Binary Heaps are complete binary tree)
 * For a complete Binary Tree, level order traversal is sufficient to store the tree.
 * We now that the first node os root, next two nodes are nodes of next level, 
 * next four nodes are nodes of 2nd level and so on. 
 * 
 * If given Binary Tree is Full Tree?
 * A full Binary Tree, where every node has either 0 or 2 children. 
 * It is east to serialize such trees as  every internal node has 2 children. 
 * We can simply store preorder traversal and store a bit with every node to indicate
 * whether the node is an internal node or a leaf node.
 * 
 * How to store a general Binary Tree?
 * A simple solution is to store both inorder and preorder traversal. This solution
 * requires twice space of Binary Tree.
 * We can save space by storing Preorder traversal and a marker for NULL pointers
 * 
 * 
 * How much extra space is required?
 * If there are n keys, then the solution requires n+1 markers which may be
 * better than simple solution(storing keys twice) in situations where keys are bigor
 * keys have big data items associated with them. 
 * 
 * Can we optimize further?
 * 
 * If we closer look at above serialized trees, we can observe that all leaf node
 * as leaves can be identifies by extra bit. We still need marker for internal ndoes
 * with one child. Please note that there are always more leaf nodes than internal nodes in a Binary tree.
 * 
 * How to serialize n-ary tree?
 * 
 * In an n-ary tree, thre is no designed left or right child. We can store an
 * 'end of children' marker.
 * 
 * 
 * Let the marker for NULL pointers be '-1'
 * 
 * 
Input:
     12
    /
  13
Output: 12 13 -1 -1

Input:
      20
    /   \
   8     22 
Output: 20 8 -1 -1 22 -1 -1 

Input:
         20
       /    
      8     
     / \
    4  12 
      /  \
     10  14
Output: 20 8 4 -1 -1 12 10 -1 -1 14 -1 -1 -1 

Input:
          20
         /    
        8     
      /
    10
    /
   5
Output: 20 8 10 5 -1 -1 -1 -1 -1 

Input:
          20
            \
             8
              \   
               10
                 \
                  5   
Output: 20 -1 8 -1 10 -1 5 -1 -1 
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
public class BinaryTreeSerialization {
	 /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
    }
}
