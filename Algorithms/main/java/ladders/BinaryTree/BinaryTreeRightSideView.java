package main.java.ladders.BinaryTree;
/**LeetCode
 * 199. Binary Tree Right Side View - Medium

Given a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

Related Topics: Tree, BFS, DFS

Similar Questions 
Populating Next Right Pointers in Each 
NodeBoundary of Binary Tree
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeRightSideView {
	//BFS Approach
	//One minor improvement I can think of is to peek the queue and add the value to the result before the for loop 
	//so that we do not have to check whether i is equal to zero every time.
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer>result = new ArrayList<>();
    	if(root == null) return result;
    	Queue<TreeNode>queue = new LinkedList<>();
    	queue.add(root);
    	
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		for(int i = 0; i < size; i++) {
    			TreeNode node = queue.poll();
    			if(i == size - 1) //last element in the current level
    				result.add(node.val);
    			if(node.left != null)
    				queue.add(node.left);
    			if(node.right != null)
    				queue.add(node.right);
    		}
    	}
       return result;
    }
    
    //DFS Approach
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}

