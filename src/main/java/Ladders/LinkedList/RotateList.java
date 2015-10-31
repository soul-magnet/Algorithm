package LinkedList;
/* 
 * Given a list, rotate the list to the right by k places, 
 * where k is non-negative.
 * Example: Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.
 * Analysis:
 * The idea is to get the whole length of the list, 
 * then compute the rotate position.
 * ANd cut the list from the rotate position, link the front 
 * to the last part.
 * Use two pointer fast and slow to archive this.
 * 
 * e.g. 1->2->3->4->5->null, k = 2;
 * len = 5;
 * rotate pos = 5 -2 = 3;
 * cut list: 1->2->3--->4->5->null
 * link: 4->5->->1->2->3->null
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RotateList {
	/**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
	private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }
    
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        
        int length = getLength(head);
        n = n % length;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        
        while (head.next != null) {
            tail = tail.next;
            head = head.next;
        }
        
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
}
