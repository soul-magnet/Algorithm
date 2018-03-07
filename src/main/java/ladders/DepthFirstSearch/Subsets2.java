package main.java.ladders.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. Subsets II 

Given a list of numbers that may has duplicate numbers, return all possible subsets

 Notice
Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.

Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Challenge: Can you do it in both recursively and iteratively?

Tags: Recursion
Related Problems 
Easy Sum of All Subsets 16 %
Easy Split String 21 %
Medium Subsets 26 %
 * 
 * */
public class Subsets2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>>result = new ArrayList<>();
		Arrays.sort(nums);
		dfs(result, new ArrayList<>(), nums, 0);
		return result;
	}
	
	private void dfs(List<List<Integer>>result, List<Integer>tempList, int[] nums, int pos) {
		result.add(new ArrayList<>(tempList));
		for(int i = pos; i<nums.length; i++) {
			if(i > pos && nums[i] == nums[i-1]) continue; /*skip duplicates*/
			tempList.add(nums[i]);
			dfs(result, tempList, nums, i+1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
