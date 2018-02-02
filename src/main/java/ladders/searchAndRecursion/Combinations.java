package searchAndRecursion;

import java.util.ArrayList;
import java.util.List;

/*Given two integers n and k, return all possible combinations of 
 * k numbers out of 1 ... n.
 * For example, If n = 4 and k = 2, a solution is:
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 * 
 * Analysis: Backtracking, Array
 * You need to consider the boundary and the return condition very carefully!
 * Use a helper method to perform recursive backtracking;
 * add an element to next-level recursive call,
 * and remove the entry after the recursive call
 * 
 * 
 * 
 * */
public class Combinations {
	/**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> solution = new ArrayList<Integer>();
		
		if (n <= 0 || k <= 0){
			return result;
		}
		
		helper(result, solution, n, k, 1);
		return result;
		
	}
	
	private void helper(
			List<List<Integer>> result, 
			ArrayList<Integer> solution,
			int n, 
			int k, 
			int start){
				if (solution.size() == k){
					result.add(new ArrayList(solution));
					return;
				}
				
				for (int i = start; i <= n; i++){
					// <= n because we want 1 ~ n int his problem
					solution.add(i);
					// the new start should be after the next number after i
					helper(result, solution, n, k, i + 1);
					solution.remove(solution.size() - 1);
				}
	}

}
