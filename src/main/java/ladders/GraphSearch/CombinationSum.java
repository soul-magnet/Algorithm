package main.java.ladders.GraphSearch;

import java.util.ArrayList;
import java.util.Arrays;
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

/* Analysis:
 * THe first impression of this problDFSem should be depth-first-search(DFS).
 * To solve problem, recursion is a normal implementation
 * Note that the candidates array is not sorted, we need to sort it first.
 * */

public class CombinationSum {

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if (candidates == null || candidates.length == 0) return result;
		ArrayList<Integer> current = new ArrayList<Integer>();
		Arrays.sort(candidates);
		
		combinationSum(candidates,target, 0, current, result);
		return result;
	}
	
	public void combinationSum(int[] candidates, int target,int j, ArrayList<Integer> current,
			ArrayList<ArrayList<Integer>> result){
		if (target == 0){
			ArrayList<Integer> temp = new ArrayList<Integer>(current);
			result.add(temp);
			return;
		}
		for (int i = j; i < candidates.length; i++){
			if(target < candidates[i])
				return;
			current.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i, current, result);
			current.remove(current.size() - 1);
		}
		
	}
}
