package DataStructure;

import java.util.NoSuchElementException;
import java.util.Stack;
/*
 * As the title described, you should only use two stacks to implement a queue's actions.

The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.

Both pop and top methods should return the value of first element.

Have you met this question in a real interview? Yes
Example
For push(1), pop(), push(2), push(3), top(), pop(), you should return 1, 2 and 2

Challenge
implement it by two stacks, do not use any other data structure and push, pop and top should be O(1) by AVERAGE.*/
public class QueueWithTwoStacks<Integer> {
	
	private Stack<Integer> stack1, stack2; // front of queue and back of queue
	
	// create an empty queue
	public QueueWithTwoStacks() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	//move all integers from stack1 to stack2
	private void moveStack1ToStack2() {
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
	}
	
	// is the queue empty?
	public boolean isEmpty(){
		return stack1.isEmpty() && stack2.isEmpty();
	}
	
	// return the number of integers in the queue
	public int size() {
		return stack1.size() + stack2.size();
	}
	
	// return the last recently added
	public Integer peek() {
		if(isEmpty()) throw new NoSuchElementException("Queue Underflow");
		if(stack2.isEmpty()) moveStack1ToStack2();
		return stack2.peek();
	}
	
	// add the Integer to the queue
	public void enqueue(Integer a){
		stack1.push(a);
	}
	
	// remove and return the Integer on the Queue Last recent added
	public Integer deque(){
		if (isEmpty()) throw new NoSuchElementException("Queue Underflow");
		if (stack2.isEmpty()) moveStack1ToStack2();
		return stack2.pop();
	}
	
	// a test client
    public static void main(String[] args) {
    	QueueWithTwoStacks<String> q = new QueueWithTwoStacks<String>();
    	//while (!StdIn.isEmpty()) {
         //   String item = StdIn.readString();
        //    if (!item.equals("-")) q.enqueue(item);
        //    else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
       // StdOut.println("(" + q.size() + " left on queue)");
        
 }


