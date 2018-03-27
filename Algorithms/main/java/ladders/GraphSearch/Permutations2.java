package main.java.ladders.GraphSearch;

import java.util.ArrayList;
import java.util.Collections;

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

Tags 
Recursion LinkedIn Depth First Search
Related Problems 
Medium Next Permutation II 34 %
Medium Permutation Sequence 28 %
Medium Next Permutation 25 %
Medium Permutations 28 %
 * 
 * */
public class Permutations2 {
	/**
	 * dfs: int[i] is unique id for each num,
	 * iterate throught i to end
	 * backtrack if when generate a list size == nums size, add list to res
	 * for each layer, interate throught 0 to the end, use visted[num.size] to
	 * determine if the id visited not to be added
	 * then update visited[] for current id, dfs, backtrack remove id from
	 * visited[] and remove id from list[]
	 *
	 * @param nums
	 *            : A list of integers.
	 * @return: A list of unique permutations.
	 */
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
