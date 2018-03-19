package main.java.ladders.DynamicProgramming;
/*
 * Given two strings, find the longest common subsequence (LCS).
 * Your code should return the length of LCS.
 * Example: For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
 * 			For "ABCD" and "EACB", the LCS is "AC", return 2.
 * Clarification: What's the definition of Longest Common Subsequence?
 * 
 * Analysis: 
 * 
 * if (nums[i] == nums[j])
 * 		dp[i][j] = dp[i-1][j-1];
 * else 
 * 		dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
 * */
public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String A, String B){
		int n = A.length();
		int m = B.length();
		int dp[][] = new int[n+1][m+1];
		for (int i = 1; i <= n; i++){
			for (int j = 1; j <= m; j++){
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if(A.charAt(i - 1) == B.charAt(j - 1))
					dp[i][j] = dp[i -1][j -1] + 1;
			}
		}
		return dp[n][m];
	}
}
