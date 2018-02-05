package Ladder3.DataStructure_II;

import java.util.Stack;

/**
 * 40. Implement Queue by Two Stacks 

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

public class ImplementQueueByTwoStacks {
	   private Stack<Integer> stack1;
	    private Stack<Integer> stack2;

	    public void Queue() {
	       // do initialization if necessary
	       stack1 = new Stack <Integer>();
	       stack2 = new Stack <Integer>();
	    }
	    
	    public void push(int element) {
	        stack2.push(element);
	    }

	    public int pop() {
	        if(stack1.isEmpty()){
	           this.stack2ToStack1();
	        }
	        return  stack1.pop();
	    }
	    public void stack2ToStack1(){
	        while(!stack2.isEmpty()){
	            stack1.push(stack2.pop());
	        }
	    }
	    public int top() {
	        if(stack1.isEmpty()){
	           this.stack2ToStack1();
	        }
	        return  stack1.peek();
	    }

}
