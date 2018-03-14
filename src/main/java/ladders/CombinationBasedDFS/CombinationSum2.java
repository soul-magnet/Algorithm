package main.java.ladders.CombinationBasedDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 153. Combination Sum II - Medium - Required

Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

 Notice
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.

Example
Given candidate set [10,1,6,7,2,1,5] and target 8,

A solution set is:

[
  [1,7],
  [1,2,5],
  [2,6],
  [1,1,6]
]
Tags: Array Backtracking Depth First Search

Related Problems 
Medium Parser 23 %
Medium Coin Change II 29 %
Hard Add Operators 27 %
Medium Combination Sum 29 %
 * 
 * */
public class CombinationSum2 {
	 /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
	
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>>result = new ArrayList<>();
		Arrays.sort(num);
		dfs(result, new ArrayList<Integer>(), num, target, 0);
		return result;
	}
	
	private void dfs(List<List<Integer>>result, List<Integer>path, int[]num, int target, int pos) {
		if(target < 0) return ;
		else if(target == 0) result.add(new ArrayList<>(path));
		else {
			for(int i = pos; i < num.length; i++) {
				if(i > pos && num[i] == num[i-1])continue; /*Skip Duplicates*/
				path.add(num[i]);
				dfs(result, path, num, target - num[i], i+1);
				path.remove(path.size()-1);
			}
		}
	}

}
