package main.java.ladders.DynamicProgramming;
/**
 * 79. Longest Common Substring - Medium 

Given two strings, find the longest common substring.

Return the length of it.

 Notice
The characters in substring should occur continuously in original string. 
This is different with subsequence.

Example
Given A = "ABCD", B = "CBCE", return 2.

Challenge 
O(n x m) time and memory.

Tags 
LintCode Copyright String
Related Problems 
Hard Longest Common Subsequence II 36 %
Medium Longest Common Subsequence 39 %
 * */
/* Analysis:  
 * DP question. Update the max during building table.
 * */
public class LongestCommonSubstring {
	/**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
	
	// Version 1: DP
	 public int longestCommonSubstring(String A, String B) {
		 if (A == null || B == null) return 0;
		 int max = 0;
		 int dp[][] = new int[A.length() + 1][B.length() + 1];
		 for (int i = 1; i <= A.length(); i ++){
			 for (int j = 1; j <= B.length(); j++){
				 if (A.charAt(i - 1) == B.charAt(j - 1)){
					 dp[i][j] = dp[i - 1][j - 1] + 1;
					 max = Math.max(max, dp[i][j]);
				 }
			 }
		 }
		 return max;
	 }
	 
	 //Version 2: 
	 /*public int longestCommonSubstring(String A, String B) {
		 int maxLen = 0;
		 int xLen = A.length();
		 int yLen = B.length();
		 
		 for (int i = 0; i < xLen; i++){
			 for (int j = 0; j < yLen; j++){
				 int len = 0;
				 while (i + len < xLen && j + len < yLen && A.charAt(i + len) == B.charAt(j + len))
					 len++;
				 if (len > maxLen){
					 maxLen = len;
				 }
			 }
		 }
		 
		 return maxLen;
	 }*/
}
