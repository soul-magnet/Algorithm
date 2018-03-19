package main.java.ladders.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import DataStructure.TreeNode;
/**
 * 
 * 70. Binary Tree Level Order Traversal II - Medium

Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]
Tags: Queue Binary Tree Binary Tree Traversal Breadth First Search

Related Problems 
Medium Search Graph Nodes 45 %

*/
/*Analysis:First solution is comes with only one queue as in BSTLevel Order traversal I
 *This is another approach;
 *Maintain a stack and queue. Instead of printing put the result in stack
 *Finally print contents of the stack 
 *Time and Space complexity is O(n)
 *
 *public void reverseLevelOrderTraversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();
        
        q.offer(root);
        while(!q.isEmpty()){
            root = q.poll();
            if(root.right != null){
                q.offer(root.right);
            }
            if(root.left != null){
                q.offer(root.left);
            }
            s.push(root);
        }
        while(!s.isEmpty()){
            System.out.print(s.pop().data + " ");
        }
        
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
public class BinaryTreeLevelOrderTraversal2 {
	/**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null){
        	return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int currentLevelNodeNum = 1;
        int nextLevelNodeNum = 0;
        
        while (currentLevelNodeNum != 0){
        	ArrayList<Integer> currentLevelResult = new ArrayList<Integer>();
        	nextLevelNodeNum = 0;
        	while (currentLevelNodeNum != 0){
        		TreeNode node = queue.poll();
            	currentLevelNodeNum--;
            	currentLevelResult.add(node.val);
            	
            	if (node.left != null){
            		queue.offer(node.left);
            		nextLevelNodeNum++;
            	}
            	if (node.right != null){
            		queue.offer(node.right);
            		nextLevelNodeNum++;
            	}
        	}
        	result.add(0, currentLevelResult);
            currentLevelNodeNum = nextLevelNodeNum;
        	
        }
        return result;
        
    }
    
/*
 * ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curNum = 0;
        int lastNum = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty())
        {
            TreeNode cur = queue.poll();
            lastNum--;
            list.add(cur.val);
            if(cur.left!=null)
            {
                queue.add(cur.left);
                curNum ++;
            }
            if(cur.right!=null)
            {
                queue.add(cur.right);
                curNum++;
            }
            if(lastNum==0)
            {
                lastNum = curNum;
                curNum = 0;
                res.add(list);
                list = new ArrayList<Integer>();
            }
        }
        Collections.reverse(res);// with out this, the solution is same with level order traversal i
        return res;
        
        */    
    
}
