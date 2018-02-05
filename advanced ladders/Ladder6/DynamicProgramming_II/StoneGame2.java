package Ladder6.DynamicProgramming_II;
/**
 * 
 * 593. Stone Game II - Medium - Required
 
There is a stone game.At the beginning of the game the player picks n piles of stones in a circle.

The goal is to merge the stones in one pile observing the following rules:

At each step of the game,the player can merge two adjacent piles to a new pile.
The score is the number of stones in the new pile.
You are to determine the minimum of the total score.

Example
For [4, 1, 1, 4], in the best solution, the total score is 18:

1. Merge second and third piles => [4, 2, 4], score +2
2. Merge the first two piles => [6, 4]，score +6
3. Merge the last two piles => [10], score +10
Other two examples:
[1, 1, 1, 1] return 8
[4, 4, 5, 9] return 43

Tags: Dynamic Programming

Related Problems 
Medium Calculate Maximum Value II 30 %
Medium Stone Game 30 %
 * */
public class StoneGame2 {
	/**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame2(int[] A) {
        		if (A==null||A.length <= 1)return 0;
		int n = A.length,dp[][]  = new int[2 * n][2 * n],sum[] = new int[2 * n + 1];
		for (int i = 1; i <= 2 * n; ++i) sum[i] = sum[i - 1] + A[(i - 1) % n];
		for(int len = 2; len < n+1;len++)
			for(int i= 0;i < 2 * n && i+len-1 < 2 * n;i++) {
				int j = i + len - 1;//dp ij = min(dp ik + dp k+1 j +sum ij , dp[i][j])
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; ++k) {
					dp[i][j] = Math.min(dp[i][j],dp[i][k] + dp[k+1][j] + sum[j + 1] - sum[i]);
				}
			}int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; ++i)ans =Math.min(ans, dp[i][i + n - 1]);
		return ans;
    }

}
