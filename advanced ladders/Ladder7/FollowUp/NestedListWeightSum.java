package Ladder7.FollowUp;

import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 551. Nested List Weight Sum - Easy - Optional

Given a nested list of integers, return the sum of all integers in the list weighted by their depth. 
Each element is either an integer, or a list -- whose elements may also be integers or other lists.


Example
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1, 4 * 1 * 2 + 1 * 2 * 1 = 10)
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 42 + 63 = 27)

Tags:LinkedIn Recursion Depth First Search

Related Problems 
Medium Flatten Nested List Iterator 28 %
 * */

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
public class NestedListWeightSum {
	
	 public int depthSum1(List<NestedInteger> nestedList) {
         if(nestedList==null || nestedList.isEmpty()){
           return 0;
       }
       int res =0;
       
       Stack<Integer> stack1 = new Stack<>();
       Stack<NestedInteger> stack = new Stack<>();
       for (NestedInteger item : nestedList){
           stack.push(item);
           stack1.push(1);
       }
       while(!stack.isEmpty()){
           NestedInteger crt = stack.pop();
           if(crt.isInteger()){
               res += crt.getInteger()*stack1.pop();

           }else{
               List<NestedInteger> list = crt.getList();
               int weight = stack1.pop()+1;
               for (NestedInteger item : list){
                   stack.push(item);
                   stack1.push(weight);
               }
           }
       }
       return res;
   }
    public int depthSum(List<NestedInteger> nestedList) {
       if (nestedList == null || nestedList.size() == 0) {
           return 0;
       }
       int res = 0;
       Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
       for (NestedInteger nestedInt : nestedList) {
           queue.offer(nestedInt);
       }
       int weight =0;
       while( !queue.isEmpty()){
           int len = queue.size();
           weight++;
           for( int i=0; i< len; i++){
               NestedInteger crt = queue.poll();
               if(crt.isInteger()){
                   res += crt.getInteger()*weight;
               }else{
                   for(NestedInteger item: crt.getList()){
                       queue.offer(item);
                   }
               }
           }
       }
       return res;
   }

}
