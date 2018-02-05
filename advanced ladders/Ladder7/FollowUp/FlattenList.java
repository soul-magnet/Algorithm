package Ladder7.FollowUp;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Flatten List - Easy - Required

Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.

 Notice
If the element in the given list is a list, it can contain list too.

Example
Given [1,2,[1,2]], return [1,2,1,2].

Given [4,[3,[2,[1]]]], return [4,3,2,1].

Challenge 
Do it in non-recursive.

Tags 
LintCode Copyright Recursion Non Recursion
Related Problems 
Medium Flatten 2D Vector 45 %
 * 
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
public class FlattenList {
	
	// @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> res= new ArrayList<>();
        for (NestedInteger ele: nestedList){
            if(ele.isInteger()){
                res.add(ele.getInteger());
            }else{
                res.addAll(flatten(ele.getList()));
            }
        }
        return res;
    }

}
