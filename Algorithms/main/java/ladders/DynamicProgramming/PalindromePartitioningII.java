package main.java.ladders.DynamicProgramming;

/**
 * 108. Palindrome Partitioning II  - Medium 
Given a string s, cut s into some substrings such that every substring is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.
 
Example
Given s = "aab",

Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.

Tags: Dynamic Programming

Related Problems 
Medium Wiggle Sort II 25 %
Medium Palindrome Partitioning 28 %
Medium Longest Palindromic Substring 29 %
 * */
/* 
 * Analysis: Dynamic Programming, and also double DP problem! Why?
 * Because, if we use the same algorithm in Palindrome Partitioning I, 
 * definetely it will expire the time limit. When you are facing the problem 
 * asking "return the minimum/maximum, best, shortest..." it is also a good
 * direction targeting to DP(sometimes greedy also works fine)
 * 
 * - minimum cut Algorithm
 *if (isPalindrome(i, j))
 *		dp[i][j] = 0;
 *else
 *	T[i][j] = 1 + min(dp[i][k] + dp[k + 1][j]) where k = i..j-1
 *The above algorithm works well for the smaller test cases, 
 *However for the big test cases, it still cannot pass. Why?
 *The way we test the palindrome is time-consuming
 *ALso using similar DP idea, we can construct the look-up table before the main 
 *part above, so that the palindrome testing becomes the looking up operation.
 *The way we construct the table is also the idea of DP 
 * e.g.mp[i][j]==true if str[i:j] is palindrome.
       mp[i][i]=true;
       mp[i][j] = true if str[i]==str[j] and 
       (mp[i+1][j-1]==true or j-i<2 )  j-i<2 ensures the array boundary.
 * */
public class PalindromePartitioningII {
	public int minCut(String s){
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		int cuts[] = new int[len+1];
		int min = 0;
		
		if (s == null || s.length() == 0)
			return min;
		for (int i = len-1; i >= 0; i--){
			for(int j = i; j < len; j++){
				if ((s.charAt(i) == s.charAt(j) && (j - i < 2)) || 
						(s.charAt(i) == s.charAt(j) && dp[i+1][j-1])){
					dp[i][j] = true;
					cuts[i] = Math.min(cuts[i], cuts[j+1]+1);
				}
			}
		}
		min = cuts[0] - 1;
		return min;
	}
};
