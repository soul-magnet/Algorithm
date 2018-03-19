package main.java.ladders.HashTable;
/**
 * 651. Binary Tree Vertical Order Traversal - Medium

Given a binary tree, return the vertical order traversal of its nodes' values. 
(ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Example
Given binary tree {3,9,20,#,#,15,7}

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
Return its vertical order traversal as:
[[9],[3,15],[20],[7]]

Given binary tree {3,9,8,4,0,1,7}

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
Return its vertical order traversal as:
[[4],[9],[3,0,1],[8],[7]]

Tags: Hash Table Google Facebook Snapchat

Related Problems 
Easy Binary Tree Level Order Traversal
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class BinaryTreeVerticalOrderTraversal {
	/*
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    private int min = 0, max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        
        List<List<Integer>> result = new  ArrayList<>();
        if(root == null) return result;
        computeRange(root, 0);
        for(int i = min; i <= max; i++)
            result.add(new ArrayList<>());
            
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> cols = new LinkedList<Integer>();
        
        queue.offer(root);
        cols.offer(-min);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int col = cols.poll();
            result.get(col).add(node.val);
            if(node.left != null){
                queue.offer(node.left);
                cols.offer(col - 1);
            }
            
            if(node.right != null){
                queue.offer(node.right);
                cols.offer(col + 1);
            }
        }
        
        return result;
    }
    
    private void computeRange(TreeNode root, int cols){
        if(root == null) return;
        min = Math.min(min, cols);
        max = Math.max(max, cols);
        computeRange(root.left,cols - 1);
        computeRange(root.right, cols + 1);
    }
	
}
