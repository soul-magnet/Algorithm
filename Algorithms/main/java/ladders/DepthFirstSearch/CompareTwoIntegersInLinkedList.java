package Microsoft;

import main.java.ladders.LinkedList.ListNode;

/**
 * You are given two integers. Each integer is represented as a linked list,
 * where each node in the list could represent the sign, or a single digit. 
 * Write a function that compares the two integers, and prints the value of the biggest one. 
 * You can assume the integers are already represented using the following data structure.
 * 
 * public class Node{
 * 		public char value;
 * 		public Node next;
 * }
 * 
 * Example: Input1: 1->0->0
 *          Input2: ->1->0->1
 *          output: 1->0->0
 * 
 * */

//www.geeksforgeeks.org/compare-two-strings-represented-as-linked-lists/
public class CompareTwoIntegersInLinkedList {
	
	static class Node {
		char value;
		Node next;
	}
	
	
	/**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
	public int compareTwoLinkedList(Node node1, Node node2) {
		if(node1 == null && node2 == null) return -1;
		Node tempList = new Node(0);
		Node lastNode = tempList;
		
		while(node1 != null && node2 != null) {
			if(node1.value != "->" && node1.value > node2.value){
				lastNode.next = node1;
				node1 = node1.next;
			}else{
				lastNode.next = node2;
				node2 = node2.next;
			}
			lastNode = lastNode.next;
		}
		
		//if the list are different size
		if(node1 != null ){
			lastNode.next = node1;
		}else{
			lastNode.next = node2;
		}
		
		return tempList.next;
	}
}

