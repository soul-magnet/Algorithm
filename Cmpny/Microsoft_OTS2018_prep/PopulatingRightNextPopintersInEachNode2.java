package Microsoft_OTS2018_prep;

import main.java.ladders.util.TreeLinkNode;
/** LeetCode
 * 117. Populating Next Right Pointers in Each Node II - Medium

Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
    
    
Related Topics: Tree, DFS, BFS

Similar Questions 
Populating Next Right Pointers in Each Node
Boundary of Binary Tree
 * */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingRightNextPopintersInEachNode2 {
	//Using Constant Space - O(1)
    public void connect(TreeLinkNode root) {
    	TreeLinkNode dummyHead = new TreeLinkNode(0);
    	TreeLinkNode pre = dummyHead;
    	while(root != null) {
    		if(root.left != null) {
    			pre.next = root.left;
    			pre = pre.next;
    		}
    		if(root.right != null) {
    			pre.next = root.right;
    			pre = pre.next;
    		}
    		root = root.next;
    		if(root == null) {
    			pre = dummyHead;
    			root = dummyHead.next;
    			dummyHead.next = null;
    			
    		}
    	}
    	
        
    }
}

