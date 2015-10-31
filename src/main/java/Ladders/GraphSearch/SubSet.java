package GraphSearch;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Given a set of distinct integers, return all possible subsets.

Have you met this question in a real interview? Yes
Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Note
Elements in a subset must be in non-descending order.

The solution set must not contain duplicate subsets.
*/
public class SubSet {
	
	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
     
    // 1. Sort the arrayList to the non-decreasing order
    // 2. Backtracking
	
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if (S == null){
			return result;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Collections.sort(S);
		
		for (int i = 0; i <= S.size(); i++){
			dfsHelper(result, i, S, list, 0);
		}
		
		return result;
	}
	
	private void dfsHelper(ArrayList<ArrayList<Integer>> result, int len, ArrayList<Integer>nums, ArrayList<Integer>tempList, int index){
		if (tempList.size() == len) {
			result.add(new ArrayList<Integer>(tempList));
			return;
		} else if (index == nums.size()){
			return;
		}
		
		for (int i = index; i < nums.size(); i++){
			int n = nums.get(i);
			tempList.add(n);
			dfsHelper(result, len, nums, tempList, i + 1);
			tempList.remove(tempList.size() -1);
		}
	}

}
