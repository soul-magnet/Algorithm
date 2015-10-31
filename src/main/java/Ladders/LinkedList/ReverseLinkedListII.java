package LinkedList;
/*
 * Reverse a linked list from position m to n.
 * Example: Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * Challenge: Reverse it in-place and in one-pass
 * 
 * */

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReverseLinkedListII {
	/**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
	
	public ListNode reverseBetween(ListNode head, int m, int n){
		 if (m >= n || head == null){
	        	return head;
	        }
		 ListNode runner = new ListNode(0);
		 runner.next = head;
		 
		 // save the pre node of the reverse part
		 ListNode pre = runner;
		 while (--m > 0){
			 pre = pre.next;
		 }
		 
		 // Save the first node of the reverse part, Node m
		 ListNode first = pre.next;
		 
		 // Save the last node of the reverse part, Node n
		 ListNode last = runner;
		 while (n-- >= 0){
			 last = last.next;
		 }
		 
		 // reverse the list
		 ListNode dummy = null;
		 head = pre.next;
		 while (head != last){
			 ListNode next = head.next;
			 head.next = dummy;
			 dummy = head;
			 head = next;
		 }
		 
		 // concat the reversed list
		 pre.next = dummy;
		 first.next = last;
		 
		 return runner.next;
	}
    public ListNode reverseBetween2(ListNode head, int m , int n) {
        if (m >= n || head == null){
        	return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++){
        	if (head == null)
        		return null;
        	head = head.next;
        }
        
        ListNode premNode  = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode, postnNode = mNode.next;
        for (int i = m; i < n; i++){
        	if(postnNode == null){
        		return null;
        	}
        	ListNode temp = postnNode.next;
        	postnNode.next = nNode;
        	nNode = postnNode;
        	postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;
        return dummy.next;
    }
}
