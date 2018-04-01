package main.java.ladders.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

/**
 * 16. Permutations II - Medium - Required

Given a list of numbers with duplicate number in it. Find all unique permutations.

Example: For numbers [1,2,2] the unique permutations are:

[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]

Challenge: Using recursion to do it is acceptable. If you can do it without recursion, that would be great!

Tags: Recursion LinkedIn Depth First Search

Related Problems 
Medium Next Permutation II 34 %
Medium Permutation Sequence 28 %
Medium Next Permutation 25 %
Medium Permutations 28 %
 * 
 * */

//
/* Analysis: DFS -Backtracking - Recursion Tree
 * What do I need?
 * 1. Result List
 * 2. tempList, keeps the current permutation until the count of each index equal 0
 * 3. visited boolean value
 * 
 * main trick: if(visited[i] || i > 0 && nums[i] == nums[i-1] && visited[i-1] ) //gives ascending order
 * 			   if(visited[i] || i > 0 && nums[i] == nums[i-1] && !visited[i-1] ) //gives descending order
 *             Both are working the difference is while ordering, ascending or descending order
 *             
 * https://www.youtube.com/watch?v=nYFd7VHKyWQ&list=PLrmLmBdmIlpslxZUHHWmfOzNn6cA7jvyh - recursion tree explanation
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/recursion/StringPermutation.java					
 * */
public class Permutations2 {
	/**
	 *  @param nums : A list of integers.
	 *  @return: A list of unique permutations.
	 */
	//LeetCode Version
	public List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>>result = new ArrayList<>();
		Arrays.sort(nums); //lexicographically sorted
		dfs(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
		return result;
	}
	
	private void dfs(List<List<Integer>>result, ArrayList<Integer>tempList,int[] nums, boolean[] visited) {
		if(tempList.size() == nums.length) {
			result.add(new ArrayList<Integer>(tempList));
			return;
		}
		for(int i = 0; i < nums.length; i++) {
			if(visited[i] || i > 0 && nums[i] == nums[i-1] && visited[i-1]) continue; //skip duplicate permutations; same with (visited[i] || i > 0 && nums[i] == nums[i-1] && !visited[i-1])
			tempList.add(nums[i]);
			visited[i] = true;
			dfs(result, tempList, nums, visited);
			tempList.remove(tempList.size()-1);
			visited[i] = false;
		}
	}
	
	//LintCode Version
	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> resArrayList = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0) {
			return resArrayList;
		}
		Collections.sort(nums);
		int[] visited = new int[nums.size()];
		dfs(nums, resArrayList, new ArrayList<Integer>(), visited);
		return resArrayList;

	}

	private void dfs(ArrayList<Integer> nums,
			ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp,
			int[] visited) {
		if (temp.size() == nums.size()) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < nums.size(); i++) {
			if (visited[i] == 1
					|| (i > 0 && visited[i - 1] != 1 && nums.get(i) == nums
					.get(i - 1))) {
				continue;
			}
			visited[i] = 1;
			temp.add(nums.get(i));
			dfs(nums, res, temp, visited);
			visited[i] = 0;
			temp.remove(temp.size() - 1);
		}

	}

}
