package Microsoft;

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

//https://www.geeksforgeeks.org/compare-two-strings-represented-as-linked-lists/
public class CompareTwoIntegersInLinkedList {
	
	static class Node {
		char value;
		Node next;
	}
	
	public int compare(Node node1, Node node2) {
		if(node1 == null && node2 == null) return -1;
		
		while(node1 != null && node2 != null && node1.value == node2.value) {
			node1 = node1.next;
			node2 = node2.next;
		}
		
		//if the list are different size
		if(node1 != null )
	}
}

