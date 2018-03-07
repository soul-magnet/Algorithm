package main.java.ladders.searchAndRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 135. Combination Sum - Medium - Required

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

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

/* Analysis: The first impression of this problem should be depth-first search. 
 * To solve DFS problem, recursion is a normal implementation. 
 * Note that the candidates array is not sorted, we need to sort it first.
 * 
 * */
public class CombinationSum {
	/**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (candidates == null){
    		return result;
    	}
    	
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	Arrays.sort(candidates);
    	helper(candidates, target, path, 0, result);
    	return result;
    }
    
    private void helper(
    		int[] candidates,
    		int target,
    		ArrayList<Integer> path,
    		int index,
    		List<List<Integer>> result){
    		if (target == 0){
    			result.add(new ArrayList<Integer>(path));
    			return;
    		}
    		
    		int prev = -1;
    		for (int i = index; i < candidates.length; i++){
    			if (candidates[i] > target){
    				break;
    			}
    			if (prev != -1 && prev == candidates[i]){
    				continue;
    			}
    			
    			path.add(candidates[i]);
    			helper(candidates, target - candidates[i], path, i, result);
    			path.remove(path.size() - 1);
    			prev = candidates[i];
    		}
    		
    }
}
