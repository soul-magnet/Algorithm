package main.java.ladders.LinkedList;

import java.util.HashMap;

/**
 * 105. Copy List with Random Pointer - Medium - Required

A linked list is given such that each node contains an additional random pointer 
which could point to any node in the list or null.

Return a deep copy of the list.

Example
Challenge 
Could you solve it with O(1) space?

Tags: Hash Table Linked List Uber
Related Problems 
Easy Clone Binary Tree 47 %
 * */

/*  Analysis: 
 * 1. copy every node, i.e. duplicate every node and insert it to the list
 * 2. copy random pointers for all newly created nodes
 * 3. break the list to two, decomposed to two independent lists
 * Reference: http://fisherlei.blogspot.com/2013/11/leetcode-copy-list-with-random-pointer.html
 * */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointer {
	/**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
	// No HashMap Version
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
    	RandomListNode current = head;
    	// 1. duplicate each node and append as its next
    	// a -> a'->  b -> b' -> ...
    	while (current != null){
    		RandomListNode next = current.next;
    		current.next = new RandomListNode(current.label);
    		current.next.next = next;
    		current = next;
    	}
    	// 2. assign random pointers for duplicates
    	current = head;
    	while (current != null){
    		if (current.random != null){
    			current.next.random = current.random.next;
    		}
    		current = current.next.next;
    	}
    	// 3. delete original nodes
    	current = head.next;
    	while (current.next != null){
    		current.next = current.next.next;
    	}
    	return head.next;
    	
    }
    
    //HasMap version
    public RandomListNode copyRandomList2(RandomListNode head){
    	if (head == null)
    		return null;
    	HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    	RandomListNode dummy = new RandomListNode(0);
    	RandomListNode pre = dummy,newNode;
    	while (head != null){
    		if (map.containsKey(head)){
    			newNode = map.get(head);
    		} else {
    			newNode = new RandomListNode(head.label);
    			map.put(head, newNode);
    		}
    		pre.next = newNode;
    		if (head.random != null){
    			if (map.containsKey(head.random)){
    				newNode.random = new RandomListNode(head.random.label);
    				map.put(head.random, newNode.random);
    			}
    		}
    		pre = newNode;
    		head = head.next;
    	}
    	return dummy.next;
    }
    
    // Another no HashMap version 
    private void copyNext(RandomListNode head){
    	while (head != null){
    		RandomListNode newNode = new RandomListNode(head.label);
    		newNode.random = head.random;
    		newNode.next = head.next;
    		head.next = newNode;
    		head = head.next.next;
    		
    	}
    }
    
    private void copyRandom(RandomListNode head){
    	while (head != null){
    		if (head.next.random != null){
    			head.next.random = head.random.next;
    		}
    		head = head.next.next;
    
    	}
    }
    
    private RandomListNode splitList(RandomListNode head){
    	RandomListNode newHead = head.next;
    	while (head != null){
    		RandomListNode temp = head.next;
    		head.next = temp.next;
    		head = head.next;
    		if (temp.next != null){
    			temp.next = temp.next.next;
    		}
    	}
    	return newHead;
    }
    public RandomListNode copyRandomList3(RandomListNode head){
    	if (head == null)
    		return null;
    	copyNext(head);
    	copyRandom(head);
    	return splitList(head);
    }
}
