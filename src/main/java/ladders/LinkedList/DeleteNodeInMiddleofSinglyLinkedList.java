package LinkedList;
/*
 * Implement an algorithm to delete a node in the middle of a singly linked list, 
 * given only access to that node.
 * Example: Given 1->2->3->4, and node 3. return 1->2->4
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
public class DeleteNodeInMiddleofSinglyLinkedList {
	/**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // since i have only access to given node
    	if (node == null || node.next == null)
    		return;
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
}
