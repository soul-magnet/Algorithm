package Ladder5.DynamicProblem_I;
/**
 * 581. Longest Repeating Subsequence - Medium - Optional
 
Given a string, find length of the longest repeating subsequence such that
the two subsequence don�t have same string character at same position, 
i.e., any ith character in the two subsequences shouldn�t have the same index in the original string.

Example
str = abc, return 0, There is no repeating subsequence

str = aab, return 1, The two subsequence are a(first) and a(second). 
Note that b cannot be considered as part of subsequence as it would be at same index in both.

str = aabb, return 2

Tags:Dynamic Programming

Related Problems 
Medium Repeat String 23 %
Medium Longest Common Subsequence 39 %
 * */

//JuizhangSOlution
public class LongestRepeatingSubsequence {
	
	/**
     * @param str a string
     * @return the length of the longest repeating subsequence
     */
    public int longestRepeatingSubsequence(String str) {
        // Write your code here
        int n = str.length();

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; ++i)
            for (int j = 0; j <= n; ++j)
                dp[i][j] = 0;
     
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j)
                    dp[i][j] = dp[i - 1][j - 1] + 1;                               
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n][n];
    }

}
