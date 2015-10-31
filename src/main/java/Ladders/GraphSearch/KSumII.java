package GraphSearch;

import java.util.ArrayList;

/*
 * 
 * Given n unique integers, number k (1<=k<=n)  and target. 
 * Find all possible k integers where their sum is target.
 * Example; Given [1,2,3,4], k=2, target=5, [1,4] and [2,3] are possible solutions.
 * 
 * Analysis: backtracking
 * 
 * */
public class KSumII {
	/**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
	public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        // write your code here
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (A == null || A.length == 0) {
			return result;
		} 
		helper(A, k, target, result, 0,  new ArrayList<Integer>());
		return result;
    }
	
	private void helper(int A[], int k, int target, ArrayList<ArrayList<Integer>> result, int curIndex, ArrayList<Integer> curList){
		if (curList.size() == k){
			if (target == 0) {
				ArrayList<Integer>temp = new ArrayList<Integer>(curList);
				result.add(temp);
			}
			return;
		}
		
		for(int i = curIndex; i < A.length; i++){
			curList.add(A[i]);
			helper(A, k, target - A[i], result, i + 1, curList);
			curList.remove(curList.size() - 1);
		}
	}
}
