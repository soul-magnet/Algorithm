package main.java.ladders.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 135. Combination Sum - Medium - Required

Given a set of candidate numbers (C) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

 Notice
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.

Example
Given candidate set [2,3,6,7] and target 7, a solution set is:

[7]
[2, 2, 3]

Tags: Array, Backtracking

Related Problems 
Medium Coin Change II 28 %
Hard Compute 24 Game 31 %
Hard Add Operators 27 %
Medium Factorization 28 %
Medium Combination Sum II 30 %
 * */
public class CombinationSum {
	/**
     * @param c for candidates: A list of integers
     * @param t for target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] c, int t) {
    	List<List<Integer>> result = new ArrayList<>();
    	Arrays.sort(c);
    	backtrack(result, new ArrayList<>(), c, t, 0);
    	return result;
    }
    
    private void backtrack(List<List<Integer>>res, List<Integer>tempList, int[] c, int t, int pos ) {
    	if(t < 0) return;
    	else if(t == 0) res.add(new ArrayList<>(tempList));
    	else {
    		for(int i=pos; i< c.length; i++) {
    			tempList.add(c[i]);
    			backtrack(res, tempList, c, t - c[i], i); //not i+1 because we can use the same elements
    			tempList.remove(tempList.size() - 1);
    		}
    	}
    }
}
