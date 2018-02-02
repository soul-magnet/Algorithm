package DataStructureII;

import java.util.Stack;

/**
 * 12. Min Stack - Medium - Required
 * 
Implement a stack with min() function, which will return the smallest number in the stack.
It should support push, pop and min operation all in O(1) cost.

 Notice: min operation will never be called if there is no number in the stack.

Example
push(1)
pop()   // return 1
push(2)
push(3)
min()   // return 2
push(1)
min()   // return 1

Tags: Stack Uber Google Zenefits

Related Problems 
Medium 132 Pattern 21 %
Hard Max Tree 33 %
Medium Implement Queue by Two Stacks 41 %
 * */

public class MinStack {
	
	private Stack< Integer> stack;
    private Stack <Integer> min;
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
        
    }

    public void push(int number) {
        stack.push(number);
        if(min.empty()){
            min.push(number);
        }
        else if(Integer.parseInt(min.peek().toString())>=number){ 
            min.push(number);
        }
    }

    public int pop() {
        // write your code here
        if(stack.peek().equals(min.peek())){
            min.pop();
        }
        return stack.pop();
    }

    public int min() {
        return min.peek();
    }

}
