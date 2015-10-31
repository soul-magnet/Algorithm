package LinkedList;
/*
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * Example: Given -21->10->4->5, tail connects to node index 1

Challenge: Follow up: Can you solve it without using extra space?
Analysis: This problem can be viewed as two major steps:
	1. Detect whether the loop exists in the linked list
	2. Find the loop start node if loop exists. 
	
	First step can be easily solved using fast&slow pointers
	For the second step;
	1. Set slow pointer to head
	2. slow = slow.next, fast = fast.next;
	3. until they meet count the steps

*/
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class LinkedListCycleII {
	 /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        if (head == null || head.next == null){
        	return null;
        }
        
        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow){
        	if (fast == null || fast.next == null){
        		return null;
        	}
        	fast = fast.next.next;
        	slow = slow.next;
        }
        while (head != slow.next){
        	head = head.next;
        	slow = slow.next;
        }
        return head;
    }
}
