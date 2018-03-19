package main.java.ladders.dataStructure;

/**
 * 12. Min Stack - Medium - Required

Implement a stack with min() function, which will return the smallest number in the stack.
It should support push, pop and min operation all in O(1) cost.

 Notice
min operation will never be called if there is no number in the stack.

Example
push(1)
pop()   // return 1
push(2)
push(3)
min()   // return 2
push(1)
min()   // return 1
Tags 
Stack Uber Google Zenefits
Related Problems 
Medium 132 Pattern 21 %
Hard Max Tree 33 %
Medium Implement Queue by Two Stacks 41 %
 * */
/* Implement a stack with min() function, which will return the smallest number in the stack.
 * It should support push, pop and min operation all in O(1) cost.
 * Example: Operations: push(1), pop(), push(2), push(3), min(), push(1), min() Return: 1, 2, 1
 * Note: min operation will never be called if there is no number in the stack
 * 
 * Analysis: To make constant time of getMin(), we need to keep track of the minimum 
 * element for each element in stack
 * 
 * There are several ways to solve this problem.
 * (1) Use an extra stack to store the minimum value. The space is O(n), time O(1)
 * (2) Use a variable to store the minimum value. The time is O(n), space is O(1)
 * 
 * */

public class MinStack {
	private class Node {
		int value;
		int min;
		Node next;
		
		Node (int x){
			value = x;
			next = null;
			min = x;
		}
	}
	
	Node head;
	public void push(int x) {
	
		if (head == null){
			head = new Node(x);
		} else {
			Node temp = new Node(x);
			temp.min = Math.min(head.min, x);
			temp.next = head;
			head = temp;
		}
	}
	
	public void pop() {
		if (head == null)
			return;
		head = head.next;
	}
	
	public int top() {
		if (head == null)
			return Integer.MAX_VALUE;
		return head.value;
	}
	
	public int getMin() {
		if (head == null)
			return Integer.MIN_VALUE;
		return head.min;
	}

}
