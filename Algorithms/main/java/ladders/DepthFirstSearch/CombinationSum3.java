package main.java.ladders.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**216. Combination Sum III

Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
 * 
 * */
public class CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
	    List<List<Integer>> list = new ArrayList<>();
	    backtrack(list, new ArrayList<Integer>(), k, n, 1);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int remain, int start) {
	    if(tempList.size() > k) return; /** no solution */
	    else if(tempList.size() == k && remain == 0) list.add(new ArrayList<>(tempList));
	    else{
	        for (int i = start; i <= 9; i++) {
	            tempList.add(i);
	            backtrack(list, tempList, k, remain-i, i+1);
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
}
