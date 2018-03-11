package main.java.ladders.DataStrctureDesign;
/**
 * 528. Flatten Nested List Iterator - Medium

Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Notice
You don't need to implement the remove method.

Have you met this question in a real interview? 
Example
Given the list [[1,1],2,[1,1]], By calling next repeatedly until hasNext returns false, 
the order of elements returned by next should be: [1,1,2,1,1].

Given the list [1,[4,[6]]], By calling next repeatedly until hasNext returns false, 
the order of elements returned by next should be: [1,4,6].

Tags: Stack Recursion Google Snapchat Data Structure Design

Related Problems 
Medium Flatten 2D Vector 45 %
Easy Nested List Weight Sum 45 %
Medium Zigzag Iterator II 33 %
Medium Zigzag Iterator 44 %
Easy Flatten Binary Tree to Linked List 33 %
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    
    private Stack<NestedInteger> stack ;
    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        stack = new Stack<>();
        for(int i= nestedList.size()-1; i>-1;i-- ){
            stack.push(nestedList.get(i));
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {

        return stack.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        //if stack does not have integer , return false;
        //else flaten the current node to make it integers and push it to stack, once stack detect top is integer reture true
        while(!stack.isEmpty()){
            if(stack.peek().isInteger()){
                return true;
            }
            List<NestedInteger> list = stack.pop().getList();
            for(int i= list.size()-1; i>-1;i-- ){
                stack.push(list.get(i));
            }
        }
        return  false;
    }

    @Override
    public void remove() {
        if(!stack.isEmpty())
        stack.pop();
    }
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */

