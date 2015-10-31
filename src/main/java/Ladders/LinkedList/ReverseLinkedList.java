package LinkedList;
/* Reverse a linked list.
 * Example: For linked list 1->2->3, the reversed linked list is 3->2->1
 * Challenge: Reverse it in-place and in one-pass
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
public class ReverseLinkedList {
	/**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
	// Iterative 
	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null){
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		
		return prev;
	}
	
	// Recursive
	ListNode newHead;
	public ListNode reverseList(ListNode head){
		if (head == null)return head;
		reverse2(head);
		head.next = null;
		return newHead;
		
	}
	
	public ListNode reverse2(ListNode head){
		if (head.next == null){
			newHead = head;
			return head;
		}
		reverse2 (head.next).next = head;
		return head;
	}
	

}
