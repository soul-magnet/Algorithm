package Ladder6.DynamicProgramming_II;
/**
 * 77. Longest Common Subsequence - Medium - Required

Given two strings, find the longest common subsequence (LCS).

Your code should return the length of LCS.

Clarification
What's the definition of Longest Common Subsequence?

https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
http://baike.baidu.com/view/2020307.htm
Example
For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

For "ABCD" and "EACB", the LCS is "AC", return 2.

Tags: LintCode Copyright Longest Common Subsequence Dynamic Programming

Related Problems 
Medium Longest Repeating Subsequence 36 %
Medium Edit Distance 31 %
Medium Longest Common Substring 31 %
 * */
public class LongestCommonSubsequence {
	/**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
         // write your code here
        if (A == null || B == null) {
            return 0;
        }
        
        int lenA = A.length();
        int lenB = B.length();
        int[][] D = new int[lenA + 1][lenB + 1];
        
        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if (i == 0 || j == 0) {
                    D[i][j] = 0;
                } else {
                    if (A.charAt(i - 1) == B.charAt(j - 1)) {
                        D[i][j] = D[i - 1][j - 1] + 1;
                    } else {
                        D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
                    }
                }
            }
        }
        
        return D[lenA][lenB];
    }

}
