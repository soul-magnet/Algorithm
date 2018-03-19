package main.java.ladders.LinkedList;
/**
 * 378. Convert Binary Search Tree to Doubly Linked List 

Convert a binary search tree to doubly linked list with in-order traversal.

Have you met this question in a real interview? 
Example
Given a binary search tree:

    4
   / \
  2   5
 / \
1   3
return 1<->2<->3<->4<->5

Tags 
Linked List
Related Problems 
Easy Convert Binary Tree to Linked Lists by Depth 40 %
Easy Flatten Binary Tree to Linked List 33 %
Medium Convert Sorted List to Balanced BST 30 %
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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class ConvertBSTtoDoublyLinkedList {
     /*public DoublyListNode bstToDoublyList(TreeNode root) {
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode tail = dummy;
        dfs(root, tail);
        return dummy.next;
        
    }

    private DoublyListNode dfs(TreeNode root, DoublyListNode tail) {
        if (root==null){
            return tail;
        }
        if(root.left==null&&root.right==null){
            DoublyListNode crt = new DoublyListNode(root.val);
            tail.next = crt;
            crt.prev=tail;
            return crt;
        }
        DoublyListNode l = dfs(root.left, tail);
        DoublyListNode crt = new DoublyListNode(root.val);
        l.next = crt;
        crt.prev=l;
        DoublyListNode r = dfs(root.right, crt);
        return r;
    }*/
    
    //using stacks
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        //Init stack
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;    
        stack.push(node);
        //Create DoublyListNode header
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode dNode = dummy;
        
            
        while(!stack.isEmpty()) {
            while (node != null && node.left != null) {
                stack.push(node.left);
                node = node.left;
            }
            //add node
            node = stack.pop();
            DoublyListNode curr = new DoublyListNode(node.val);
            dNode.next = curr;
            curr.prev = dNode;
            dNode = dNode.next;
            
            //check right node and add to stack
            node = node.right;
            if (node != null) {
                stack.push(node);
            }  
        }
        
        return dummy.next;
    }
}

