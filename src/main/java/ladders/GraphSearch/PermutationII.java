package GraphSearch;

import java.util.ArrayList;
import java.util.Collections;

/*
 *
 * Find Unique Permutations
 * 
 * */
public class PermutationII {
	public ArrayList<ArrayList<Integer>> permutationUnique(ArrayList<Integer> nums){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0) {
			return result;
		}
		
		Collections.sort(nums);
		int[] visited = new int[nums.size()];
		helper(nums, result, visited, new ArrayList<Integer>());
		return result;
	}
	
	private void helper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>>result, int[] visited, ArrayList<Integer> cur){
		if (cur.size() == nums.size()) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		
		for (int j = 0; j < nums.size(); j++) {
			if (visited[j] == 1 || (j != 0 && nums.get(j) == nums.get(j - 1) && visited[j - 1] == 0)) {
				continue;
			}
			visited[j] = 1;
			cur.add(nums.get(j));
			helper(nums, result, visited, cur);
			visited[j] = 0;
			// removing fixed character
			cur.remove(cur.size() - 1);
		}
	}
}
