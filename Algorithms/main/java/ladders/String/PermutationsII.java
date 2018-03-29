package main.java.ladders.String;

import java.util.ArrayList;
import java.util.Collections;

/*
 * For numbers [1,2,2] the unique permutations are:
 * [[1,2,2], [2,1,2], [2,2,1]]
 * 
 * */
public class PermutationsII {
	/**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0) {
			return result;
		}
		
		Collections.sort(nums);
		int[] visited = new int[nums.size()];
		helper(nums, result, visited, new ArrayList<Integer>());
		return result;
	}

	private void helper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result, int[] visited,
			ArrayList<Integer> cur) {
		if (cur.size() == nums.size()) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		
		for (int j = 0; j < nums.size(); j++){
			// if the number has been used or if the previous duplicate number
			// has finished this position (so its visited flag is set to 0)
			if (visited[j] == 1 || (j != 0 && nums.get(j) == nums.get(j - 1) && visited[j - 1] == 0)){
				continue;
			}
			visited[j] = 1;
			cur.add(nums.get(j));
			helper(nums, result,visited, cur);
			cur.remove(cur.size() - 1);
		}
		
	}
	
	// Iterative: Use hashset to remove duplicates
	
	/*public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        Collections.sort(nums);
        int[] visited = new int[nums.size()];
        
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.size(); i++) {
            Set<ArrayList<Integer>> nextResult = new HashSet<ArrayList<Integer>>();
            for (ArrayList<Integer> l : result) {
                for (int j = 0; j <= l.size(); j++) {
                    //skip duplicates
                    //while (j < l.size() && nums.get(i) == nums.get(j)) {
                    //    j++;
                    //}
                    l.add(j, nums.get(i));
                    nextResult.add(new ArrayList<Integer>(l));
                    l.remove(j);
                }
            }
            result = nextResult;
        }
        return new ArrayList<ArrayList<Integer>>(result);
    }*/
	
	
}
