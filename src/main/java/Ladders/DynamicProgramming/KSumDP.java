package DynamicProgramming;

/*
 * Given n distinct positive integers,
 * integer k (k <= n) and a number target.
 * Find k numbers where sum is target. 
 * Calculate how many solutions there are?
 * Example:
 * Given [1,2,3,4], k = 2, target = 5. There are 2 solutions: [1,4] 
 * and [2,3]. Return 2.
 * 
 * Analysis: 
 * Thus we use DP which is O(n^3). Kinda same approach with backpacking
 * f[i][j][t] indicates the number of solutions for selecting j
 * numbers from A[0...i-1] with the sum of t.
 * Care the initialization and the two cases to be handle
 * 
 * */
public class KSumDP {
	
	/**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
	public int kSum(int A[], int k, int target){
		if (A == null || A.length == 0){
			return 0;
		}
		
		int n = A.length;
		
		
		int[][][] dp = new int[n + 1][k + 1][target + 1];
		
		// only the slots with k == 0 && t == 0 will be initialized as 1. 
		// All the others need to be 0
		// when A[i] == t so we could drive dp[i][j][k] from dp[i -1][j -1][0]
		for (int i = 1; i <= n +1; i++){
			for (int j = 1; j <= k && j <= i; j++) {
				for (int t = 1; t <= target; t++){
					dp[i][j][t] = 0;
					if (t >= A[i -1]) {
						dp[i][j][t] = dp[i -1][j -1][t - A[i -1]];
					}
					dp[i][j][t] += dp[i - 1][j][t];
					
				} // for t
			} // for j
					
		} // for i
		
		return dp[n][k][target];		
	}
	
	// 2 dimension
    public int  kSum2D(int A[], int k, int target) {
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
            
                for (int j = 1; j <= k; j++) {
                    for (int t = target; t > 0; t--) {
                    if (t - A[i - 1] >= 0) {
                        D[j][t] += D[j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        
        return D[k][target];
    }

}
