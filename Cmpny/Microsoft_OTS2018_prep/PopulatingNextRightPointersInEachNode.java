package Microsoft_OTS2018_prep;

import main.java.ladders.util.TreeLinkNode;

/** LeetCode
 * 116. Populating Next Right Pointers in Each Node - Medium

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
    
Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree 
(ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
    
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
    

Related Topics: Tree, Depth First Search

Similar Questions 
Populating Next Right Pointers in Each Node II
Binary Tree Right Side View
 * */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersInEachNode {
	//Sleek Solution! More intuitive way might be:
	// 1. loop trough level 0 to level n-2;
	// 2. Traverse this level and connect children;
	//O(n) memory and O(1) time
    public void connect(TreeLinkNode root) {
    	while(root != null && root.left != null) {
    		TreeLinkNode curr = root;
    		while(curr != null) {
    			curr.left.next = curr.right;
    			curr.right.next = curr.next == null ? null : curr.next.left;
    			curr = curr.next;
    		}
    		root = root.left;
    	}
        
    }
    
    //question required to use only constant extra space
    //Recursion in this case will take more than constant extra space
    public void connect1(TreeLinkNode root) {
    	if(root == null) return;
    	if(root.left != null) {
    		root.left.next = root.right;
    		if(root.next != null)
    			root.right.next = root.left.next.left;
    	}
    	connect1(root.left);
    	connect1(root.right);
    }
    
}

