package Microsoft;
/**
 * 667. Longest Palindromic Subsequence - Medium

Given a string s, find the longest palindromic subsequence's length in s. 
You may assume that the maximum length of s is 1000.

Example
Given s = "bbbab" return 4
One possible longest palindromic subsequence is "bbbb".

Tags: Dynamic Programming Amazon Uber

Related Problems 
Hard Palindrome Pairs 18 %
Hard Count Different Palindromic Subsequences 28 %
Medium Convert Palindrome 21 %
Medium Longest Palindromic Substring 29 %
 * 
 * */
public class LongestPalindromicSubsequence {
	/**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
	
	//DP Approach - Juizhang Solution
    public int longestPalindromeSubseq(String s) {
        // write your code here
    	if(s.length() == 0) return 0;
    	int[][] dp = new int[s.length()][s.length()];
    	for(int i = s.length()-1; i >= 0; i--) {
    		dp[i][i] = 1;
    		for(int j = i +1; j < s.length(); j++) {
    			if(s.charAt(i) == s.charAt(j)) {
    				dp[i][j] = dp[i+1][j-1] + 2;
    			}else {
    				dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
    			}
    		}
    	}
    	
    	return dp[0][s.length() - 1];
    }
    
    
    //Cannot pass Oj
    // public int longestPalindromeSubseq(String s) {
    //     // write your code here
    //     int[][] dp = new int[s.length()][s.length()];
        
    //     for (int i = s.length() - 1; i >= 0; i--) {
    //         dp[i][i] = 1;
    //         for (int j = i+1; j < s.length(); j++) {
    //             if (s.charAt(i) == s.charAt(j)) {
    //                 dp[i][j] = dp[i+1][j-1] + 2;
    //             } else {
    //                 dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
    //             }
    //         }
    //     }
    //     return dp[0][s.length()-1];
    // }
    
    //cannot pass OJ
    //   public int longestPalindromeSubseq(String s) {
    //     int len=s.length();
    //     int[][] dp=new int[len][len];
    //     for (int i=0;i<len;i++)
    //         dp[i][i]=1;
    //     for (int d=1;d<len;d++) {
    //         for (int i=0;i<len-d;i++) {
    //             int j=i+d;
    //             if (s.charAt(i)==s.charAt(j)) dp[i][j]=2+dp[i+1][j-1];
    //             else dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
    //         }
    //     }
    //     return dp[0][len-1];
    // }

}
