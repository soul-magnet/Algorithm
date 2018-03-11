package main.java.ladders.LinkedList;

/**
 * 99. Reorder List - Medium

Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln

reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

Example
Given 1->2->3->4->null, reorder it to 1->4->2->3->null.

Challenge 
Can you do this in-place without altering the nodes' values?

Tags 
Linked List
 * */
/* Analysis: This problem is not straightforward, because it requires
 * "in-place" operations. That means we can only change their pointers, 
 * not creating a new list.
 * 1. Break list in the middle to two lists(use fast and slow pointers)
 * 2. Reverse the order of the second list
 * 3. Merge two list back together
 * 
 * References: http://www.programcreek.com/2013/12/in-place-reorder-a-singly-linked-list-in-java/
 * 
 * */
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
public class ReorderList {
	/**
     * @param head: The head of linked list.
     * @return: void
     */
	// 1. Break list in the middle to two lists (use fast and slow pointers)
	private ListNode findMiddle(ListNode head) {
		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	// 2. Reverse the order of second list
	private ListNode reverse(ListNode head) {
		ListNode newHead = null;
		while (head != null){
			ListNode temp = head.next;
			head.next = newHead;
			head = temp;
		}
		return newHead;
	}
	
	// 3. Merge two list back together
	private void merge(ListNode head1, ListNode head2){
		int index = 0;
		ListNode dummy = new ListNode(0);
		while (head1 != null && head2 != null){
			if (index % 2 == 0){
				dummy.next = head1;
				head1 = head1.next;
			} else {
				dummy.next = head2;
				head2 = head2.next;
			}
			dummy = dummy.next;
			index++;
		}
		if (head1 != null){
			dummy.next = head1;
		} else {
			dummy.next = head2;
		}
	}
	
    public void reorderList(ListNode head) {  
        if (head == null || head.next == null)
        	return;
        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        merge(head, tail);
    }
    
    // Another Solution
    public void reorderList2(ListNode head) {  
        // write your code here
        if (head == null) {
            return;
        }
        int num = 0;
        ListNode cur = head;
        while (cur != null) {
            num++;
            cur = cur.next;
        }
        int posHead2 = 0;
        ListNode head2 = head;
        while (posHead2 < num / 2 + 1) {
            head2 = head2.next;
            posHead2++;
        }
        //reverse the second list
        head2 = reverse(head2);
        cur = head;
        //combine two lists
        while (head2 != null) {
            ListNode next1 = cur.next;
            ListNode next2 = head2.next;
            cur.next = head2;
            head2.next = next1;
            cur = next1;
            head2 = next2;
        }
        //terminate first list
        if (num % 2 == 0) {
            cur.next.next = null;
        } else {
            cur.next = null;
        }
    }
 
    private ListNode reverse2(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
