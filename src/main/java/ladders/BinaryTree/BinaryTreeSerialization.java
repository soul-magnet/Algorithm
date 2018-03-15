package main.java.ladders.BinaryTree;

import java.util.Queue;

/**
 * 7. Binary Tree Serialization - Medium

Design an algorithm and write code to serialize and deserialize a binary tree. 
Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct 
the exact same binary tree is 'deserialization'.

 Notice
There is no limit of how you deserialize or serialize a binary tree, 
LintCode will take your output of serialize as the input of deserialize, it won't check the result of serialize.

Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.

Tags: Binary Tree Yahoo Microsoft Uber

Related Problems 
Medium Strings Serialization 40 %
Medium Search Range in Binary Search Tree 37 %
 * */
/* Analysis: 
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
    	if(root == null) return "{}";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        result.append("{");
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                result.append("#,");
                continue;
            }
            result.append(node.val+",");
            queue.add(node.left);
            queue.add(node.right);
        }
        result.append("}");
        return result.toString();
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
    	f(data == "{}") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.substring(1, data.length() - 2).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
       for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if(!values[i].equals("#")){
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(parent.left);
            }
            
            if(!values[++i].equals("#")){
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(parent.right);
            }
        }
        
        return root;
    }
    //another way of implementing
    public TreeNode deserialize1(String s) {
              if(s=="{}")return null;
       String[] a = s.substring(1,s.length()-2).split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(a[0]));
        q.offer(root); int i=1;
        while(i<a.length&&!q.isEmpty()){
            TreeNode now = q.poll();
            if(!a[i].equals("#")){
                now.left=new TreeNode(Integer.parseInt(a[i]));
                q.offer(now.left);
            }i++;
            if(!a[i].equals("#")){
                now.right=new TreeNode(Integer.parseInt(a[i]));
                q.offer(now.right);
            }i++;
        }
        return root;
    }
}
