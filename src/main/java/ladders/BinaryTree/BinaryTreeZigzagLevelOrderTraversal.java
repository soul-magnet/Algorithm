package main.java.ladders.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

import DataStructure.TreeNode;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * Example: Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
   
   *return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
   
* Analysis:
* Queue is not helpful here. You might want to consider using Stack instead.
* This problem can be solved easily using two stacks(one called currentLevel
* and the other one called nextLevel). 
* You would also need a variable to keep track of the current level's order
* (whether it is left->right or right->left) 
* You pop from stack currentLevel and print the node's value. 
* Whenever the current level's order is from left-> right, you push the nodes's
* left child, then its right child to stack nextLevel. 
* Stack is LIFO structure,so the next time when nodes are popped off nextlevel, 
* it will be in the reverse order
* 
*  On the other hand, when the current level's order is from right -> left, 
*  you would push the node's right child first, then its left child.
*  Finally, don't forget to swap those two stacks at the end of each level
*  (ie, when currentLevel is empty)
*  
 void printLevelOrderZigZag(BinaryTree *root) {
  stack<BinaryTree*> currentLevel, nextLevel;
  bool leftToRight = true;
  currentLevel.push(root);
  while (!currentLevel.empty()) {
    BinaryTree *currNode = currentLevel.top();
    currentLevel.pop();
    if (currNode) {
      cout << currNode->data << " ";
      if (leftToRight) {
        nextLevel.push(currNode->left);
        nextLevel.push(currNode->right);
      } else {
        nextLevel.push(currNode->right);
        nextLevel.push(currNode->left);
      }
    }
    if (currentLevel.empty()) {
      cout << endl;
      leftToRight = !leftToRight;
      swap(currentLevel, nextLevel);
    }
  }
}*/

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
public class BinaryTreeZigzagLevelOrderTraversal {
	 /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null){
        	return result;
        }
        
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> tmp;
        
        currLevel.push(root);
        boolean leftToRight = true;
        
        while (!currLevel.isEmpty()) {
        	ArrayList<Integer> currLevelResult = new ArrayList<Integer>();
        	while (!currLevel.isEmpty()){
        		TreeNode node = currLevel.pop();
        		currLevelResult.add(node.val);
        		
        		if (leftToRight){
        			if (node.left != null){
        				nextLevel.push(node.left);
        			}
        			if (node.right != null){
        				nextLevel.push(node.right);
        			}
        		} else {
        			if (node.right != null){
        				nextLevel.push(node.right);
        			}
        			
        			if (node.left != null){
        				nextLevel.push(node.left);
        			}
        		}
        	}
        	
        	result.add(currLevelResult);
        	tmp = currLevel;
        	currLevel = nextLevel;
        	nextLevel = tmp;
        	leftToRight = !leftToRight;
        }
        
        return result;
        
    }
}
