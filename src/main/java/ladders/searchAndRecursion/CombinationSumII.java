package main.java.ladders.searchAndRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * For example, given candidate set 10,1,6,7,2,1,5 and target 8,
 * A solution set is: 
 * [1,7]
 * [1,2,5]
 * [2,6]
 * [1,1,6]
 * Note: All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * 
 * Analysis: 
 * This problem is an extension of Combination Sum. The difference is one number in the aray
 * can only be used ONCE.
 * */
public class CombinationSumII {
	/**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
	
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0)
        	return result;
        Arrays.sort(num);
        
        ArrayList<Integer> currentPath = new ArrayList<Integer>();
        helper(num, target, currentPath, result, 0);
        HashSet<List<Integer>> set = new HashSet<List<Integer>>(result);
        
        // remove duplicate lists
        result.clear();
        result.addAll(set);
        return result;
    }
	
	private void helper(
			int[] num, 
			int target, 
			ArrayList<Integer>currentPath,
			List<List<Integer>> result,
			int start) {
		if (target == 0){
			result.add(new ArrayList<Integer>(currentPath));
		}
		
		if (start >= num.length || target < 0)
			return;
		
		int prev = -1;
		
		for (int i = start; i < num.length; i++){
			if (num[i] != prev){
				currentPath.add(num[i]);
				helper(num, target - num[i],currentPath, result, i + 1);
				prev = num[i];
				currentPath.remove(currentPath.size() - 1);
			}
		}
	}
}
