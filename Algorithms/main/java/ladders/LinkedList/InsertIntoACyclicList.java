package main.java.ladders.LinkedList;
/**
 * 599. Insert into a Cyclic Sorted List - Easy - Required

Given a node from a cyclic linked list which has been sorted, 
write a function to insert a value into the list such that it remains a cyclic sorted list. 
The given node can be any single node in the list. Return the inserted new node.

 Notice
3->5->1 is a cyclic list, so 3 is next node of 1.
3->5->1 is same with 5->1->3

Example
Given a list, and insert a value 4:
3->5->1
Return 5->1->3->4

Tags 
Linked List Amazon
Related Problems 
Easy Insertion Sort List 31 %
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
public class InsertIntoACyclicList {
	/**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
//         if (node == null){
// 			return new ListNode(x);
// 		} else if(node.next == node) { //only one element
// 			//add this node  
// 			node.next = new ListNode(x);
// 			node.next.next = node; //the next's next reference points back to the head so forms a cycle
// 			return node.val < x ? node : node.next;//we check value and return the smaller one as headed
// 		} else if(x < node.val) {//if its the smallest element
// 			//find tail and append
// 			ListNode current = node;
// 			while(current.next != node)
// 				current = current.next;
// 			current.next = new ListNode(x);//add it after the tail
// 			current.next.next = node;//set the append node's next to the original header
// 			return current.next;
// 		} //otherwise, we either find a position when node.value<n and node.next.value>n or node.next==head
// 		ListNode current = node;
// 		while(current.next != node && current.next.val <=x){
// 			current = current.next;
// 		}
// 		ListNode currentNext = current.next;
// 		current.next = new ListNode(x);
// 		current.next.next = currentNext;//notice we made a copy of original next and assign it here
// 		return node;//return header position

        if(node == null){
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        
        ListNode curr = node;
        ListNode prev = null;
        
        do {
            prev = curr;
            curr = prev.next;
            
            if(x <= curr.val && x >= prev.val){
                break;
            }
            
            if((prev.val > curr.val) && (x < curr.val || x > prev.val)){
                break;
            }
        } while (curr != node);
        
        ListNode newNode = new ListNode(x);
        newNode.next = curr;
        prev.next = newNode;
        
        return newNode;
    }

}
