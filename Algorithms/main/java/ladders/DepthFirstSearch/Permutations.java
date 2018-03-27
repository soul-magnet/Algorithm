package main.java.ladders.DepthFirstSearch;

import java.util.ArrayList;

/**15. Permutations - Medium - Required

Given a list of numbers, return all possible permutations.

 Notice
You can assume that there is no duplicate numbers in the list.

Example
For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Challenge: Do it without recursion.

Tags: LinkedIn Recursion
Related Problems 
Medium Print Numbers by Recursion 26 %
Medium Permutation Sequence 28 %
Medium Permutations II 26 %*/

public class Permutations {
	/*
	 * @param nums: A list of integers
	 * @return: A list of permutations
	 * */
	
	
	//Recursive backtracking 
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0) {
			return result;
		}
		// call recursive function 
		helper(nums,result, new ArrayList<Integer>());
		return result;
	}
	
	private static void helper(ArrayList<Integer>nums, ArrayList<ArrayList<Integer>>result, ArrayList<Integer>cur ){
		if (cur.size() == nums.size()) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		
		for (int j = 0; j < nums.size(); j++) {
			if (cur.contains(nums.get(j))){
				continue;
			}
			cur.add(nums.get(j));
			helper(nums, result, cur);
			// removing fixed character
			cur.remove(cur.size() - 1);
		}
	}
	
	public static void main(String args[]){
		ArrayList<Integer>nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		
		System.out.println(permute(nums));
	}
}