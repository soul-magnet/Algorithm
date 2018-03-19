package main.java.ladders.dataStructure;

import java.util.Stack;
/**
 * 40. Implement Queue by Two Stacks - Medium - Required

As the title described, you should only use two stacks to implement a queue's actions.

The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.

Both pop and top methods should return the value of first element.

Example
push(1)
pop()     // return 1
push(2)
push(3)
top()     // return 2
pop()     // return 2
Challenge 
implement it by two stacks, do not use any other data structure and push, pop and top should be O(1) by AVERAGE.

Tags: Queue Stack LintCode Copyright
Related Problems 
Medium Min Stack 33 %
 * */
/*
 * As the title described, you should only use two stacks to implement 
 * a queue's actions.
 * The queue should support push(element), pop() and top()
 *  where pop is pop the first(a.k.a front) element in the queue.
 *  Both pop and top methods should return the value of first element.
 *  Example: For push(1), pop(), push(2), push(3), top(), pop(), 
 *  you should return 1, 2 and 2
 *  Challenge: implement it by two stacks, 
 *  do not use any other data structure and push, pop and top 
 *  should be O(1) by AVERAGE.
 *  
 *  Since the major difference between a queue and a stack is the order 
 *  (first-in first-out vs. last-in first-out), 
 *  we know that we need to modify peek() and pop() to go in reverse order. 
 *  We can use our second stack to reverse the order of the elements 
 *  (by popping s i and pushing the elements on to s2). 
 *  In such an implementation, on each peek() and pop() operation, 
 *  we would pop everything from s1 onto s2, perform the peek / pop operation, 
 *  and then push everything back.
 *  This will work, but if two pop / peeks are performed back-to-back, 
 *  we’re needlessly moving elements. We can implement a”lazy”approach 
 *  where we let the elements sit in s2 until we absolutely must reverse 
 *  the elements.
 *  In this approach, stackNewest has the newest elements on top and 
 *  stackOldest has the oldest elements on top. 
 *  When we dequeue an element, we want to remove the oldest element first, 
 *  and so we dequeue from stackOldest. If stackOldest is empty, 
 *  then we want to transfer all elements from stackNewest into this stack 
 *  in reverse order.To insert an element, we push onto stackNewest, 
 *  since it has the newest elements on top.
 *  Note the time is O(1) by Average
 *  */
public class ImplementQueueByTwoStacks {
	 private Stack<Integer> stack1; //save the ready-to-pop elements in FIFO order 
	    private Stack<Integer> stack2; //save the backup elements in LIFO order
	 
	    public void stack2ToStack1() { //transform elements from backup to ready-to-pop
			while (!stack2.empty()) {
				stack1.push(stack2.peek());
				stack2.pop();
			}
		}
		
	    public ImplementQueueByTwoStacks() {
	       stack1 = new Stack<Integer>();
	       stack2 = new Stack<Integer>();
	    }
	    
	    public void push(int number) {
	        stack2.push(number);
	    }
	 
	    public int pop() {
	        if (stack1.empty() == true) {
				this.stack2ToStack1();
			}
	        return stack1.pop();
	    }
	 
	    public int top() {
	        if (stack1.empty() == true) {
				this.stack2ToStack1();
			}
	        return stack1.peek();
	    }
}
