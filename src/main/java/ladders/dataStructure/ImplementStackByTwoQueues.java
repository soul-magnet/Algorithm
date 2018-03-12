package main.java.ladders.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 494. Implement Stack by Two Queues - Easy - Related

Implement a stack by two queues. The queue is first in first out (FIFO). 
That means you can not directly pop the last element in a queue.

Example
push(1)
pop()
push(2)
isEmpty() // return false
top() // return 2
pop()
isEmpty() // return true

Tags: Stack Queue
 * */
public class ImplementStackByTwoQueues {
	 private Queue<Integer> q1 = new LinkedList<Integer>(),
				q2 = new LinkedList<Integer>();

		// Push a new item into the stack
		public void push(int x) {
			q2.offer(x);
			while (!q1.isEmpty()) {
				q2.offer(q1.poll());
			}
			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;

		}

		// Pop the top of the stack
		public void pop() {
			q1.poll();
		}

		// Return the top of the stack
		public int top() {
			return q1.peek();
		}

		// Check the stack is empty or not.
		public boolean isEmpty() {
			return q1.isEmpty();
		} 

}
