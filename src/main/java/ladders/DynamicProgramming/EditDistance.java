package main.java.ladders.DynamicProgramming;

/**
 * 119. Edit Distance - Medium

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
(each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
 
Example: Given word1 = "mart" and word2 = "karma", return 3.

Tags 
String Dynamic Programming
Related Problems 
Medium Edit Distance II 28 %
Medium Longest Common Subsequence 39 %
 * */
/* Analysis: if (str[i] == str[j])
 * 				T[i][j] = T[i - 1][j - 1];
 * 			else 
 * 				T[i][j] = min(T[i - 1][j], T[i - 1][j - 1], T[i][j - 1]);
 * */
public class EditDistance {
	/**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < m+1; i++){
        	dp[0][i] = i;
        }
        for (int i = 0; i < n+1; i++){
        	dp[i][0] = i;
        }
        
        for (int i = 1;  i < n+1; i++){
        	for (int j = 1; j < m+1; j++){
        		if (word1.charAt(i - 1) == word2.charAt(j - 1)){
        			dp[i][j] = dp[i-1][j-1];
        		} else {
        			dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
        		}
        	}
        }
        return dp[n][m];
    }
}
