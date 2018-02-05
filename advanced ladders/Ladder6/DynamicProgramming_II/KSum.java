package Ladder6.DynamicProgramming_II;
/**
 * 
 * 89. k Sum - Hard - Optional
 
Given n distinct positive integers, integer k (k <= n) and a number target.

Find k numbers where sum is target. Calculate how many solutions there are?

Example
Given [1,2,3,4], k = 2, target = 5.

There are 2 solutions: [1,4] and [2,3].

Return 2.

Tags: LintCode Copyright Dynamic Programming

Related Problems 
Medium k Sum II 34 %
*/
public class KSum {
	
	 /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
  public int kSum(int A[], int k, int target) {
		// write your code here
		if (target < 0) {
			return 0;
		}

		int len = A.length;

		// D[i][j]: k = i, target j, the solution.
		int[][] D = new int[k + 1][target + 1];

		// only one solution for the empty set.
		D[0][0] = 1;
		for (int i = 1; i <= len; i++) {
			for (int t = target; t > 0; t--) {
				for (int j = 1; j <= k; j++) {
					if (t - A[i - 1] >= 0) {
						D[j][t] += D[j - 1][t - A[i - 1]];
					}
				}
			}
		}

		return D[k][target];
	}

}
