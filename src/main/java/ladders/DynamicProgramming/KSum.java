package DynamicProgramming;

import java.util.ArrayList;

/*
 * Given n distinct positive integers, integer k (k <= n) and a number target. 
 * Find k numbers where sum is target.
 * Calculate how many solutions there are?
 * Example:
 * Given [1,2,3,4], k = 2, target = 5. 
 * There are 2 solutions: [1,4] and [2,3]. Return 2.
 * 
 * Analysis: We can use backtracking to solve this problem, 
 * which is O(n^k). However, this is TLE
 * 
 * */
public class KSum {
	/**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
	public int ksum(int A[], int k, int target){
		ArrayList<Integer>result = new ArrayList<Integer>();
		if (A == null || A.length == 0){
			return 0;
		}
		
		result.add(0);
		helper(A, k, target, result, 0, new ArrayList<Integer>());
		return result.get(0);
	}
	
	private void helper(int A[], int k, int target, ArrayList<Integer>result,
			int curIndex, ArrayList<Integer> curList){
		if (curList.size() == k){
			if (target == 0){
				result.set(0, result.get(0) + 1);
			}
			return;
		}
		
		for (int i = curIndex; i < A.length; i++){
			curList.add(A[i]);
			helper(A, k, target - A[i], result, i + 1, curList);
			curList.remove(curList.size() - 1);
		}
	}

}
