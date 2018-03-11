package main.java.ladders.LinkedList;
/**
 * 242. Convert Binary Tree to Linked Lists by Depth  - Easy

Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth 
(e.g., if you have a tree with depth D, you'll have D linked lists).

Example
Given binary tree:

    1
   / \
  2   3
 /
4
return

[
  1->null,
  2->3->null,
  4->null
]
Tags: Linked List Binary Tree Breadth First Search

Related Problems 
Easy Flatten Binary Tree to Linked List 33 %
Medium Convert Binary Search Tree to Doubly Linked List 30 %
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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ConvertBinaryTreeToLinkedListByDepth {
	/**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists1(TreeNode root) {
        // Write your code here
        List<ListNode> result = new ArrayList<ListNode>();
       if (root == null)
            return result;
            
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        ListNode dummy = new ListNode(0);
        ListNode lastNode = null;
        while (!queue.isEmpty()) {
            dummy.next = null;
            lastNode = dummy;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                lastNode.next = new ListNode(head.val);
                lastNode = lastNode.next;

                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }
            result.add(dummy.next);
        }
        
        return result;
    }
    
     public List<ListNode> binaryTreeToLists(TreeNode root) {
         List<ListNode>result = new ArrayList<ListNode>();
         
         if(root == null) return result;
         
         Queue<TreeNode> queue = new LinkedList<TreeNode>();
         queue.offer(root);
         ListNode lastNode = new ListNode(0);
         lastNode.next = null;
         while(!queue.isEmpty()){
             int size = queue.size();
             for(int i = 0; i < size; i++){
                 TreeNode head = queue.poll();
                 lastNode.next = new ListNode(head.val);
                 
                if (head.left != null)
                    queue.offer(head.left);
                 
                 if (head.right != null)
                    queue.offer(head.right);
                 
             }
             result.add(lastNode);
         }
         
         return result;
     }

}
