package main.java.ladders.GraphSearch;

import java.util.ArrayList;

/*
 * Recursive backtracking 
 * */
public class Permutation {
	/*
	 * @param nums: A list of integers
	 * @return: A list of permutations
	 * */
	
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0) {
			return result;
		}
		// call recursive function 
		helper(nums,result, new ArrayList<Integer>());
		return result;
	}
	
	private void helper(ArrayList<Integer>nums, ArrayList<ArrayList<Integer>>result, ArrayList<Integer>cur ){
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
}
