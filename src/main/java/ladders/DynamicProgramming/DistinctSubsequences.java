package main.java.ladders.DynamicProgramming;
/**
/**
 * 118. Distinct Subsequences - Medium

Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some
(can be none) of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example
Given S = "rabbbit", T = "rabbit", return 3.

Challenge 
Do it in O(n2) time and O(n) memory.

O(n2) memory is also acceptable if you do not know how to optimize memory.

Tags 
String Dynamic Programming
Related Problems 
Medium Interleaving String 27 %
 * */
/* Analysis: 
 * In other words, this question ask how many time T has occurred in S,
 * where some char can be added in between T, but the order of T cannot change.
 * 
 * for example: S="aabb" T="aab",we need to define the occurrence of T in S, so
 * 1) we store the position of each letter of T in S, in a table:
 * 	a[0, 1]
 * 	b[0 ,1]
 * 	b[2 ,3]
 * 
 * 2) The problem can be viewed as "find how many paths from top to the bottom
 * with an ascending order". In other words, from the table above, for "a" 
 * we have only one choice 0. the other "a" we have only one choice 1,
 * and for b we can choose 2 or 3, thus the result is 2.
 * 
 * How to get path number? You can use dfs, but it might be time consuming.
 * Here we use DP, define res[i][j] the number of path can have for table[i][j]
 * res[i][j] = sum(res[i-1][k]), where table[i-1][k] < table[i][j].
 * The final result is the sum (res[last row]).
 * 
 * 2D array and store the length of string + 1
 * 
 * Reference: https://github.com/yuzhangcmu/LeetCode/blob/master/dp/NumDistinct.java
 * 			  http://blog.welkinlan.com/2015/04/29/distinct-subsequences-leetcode-java-dp/
 * 
 * */
public class DistinctSubsequences {
	
	/**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
    	if (S == null || T == null) {
            return 0;
        }

        int[][] nums = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            nums[i][0] = 1;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                nums[i][j] = nums[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    nums[i][j] += nums[i - 1][j - 1];
                }
            }
        }
        return nums[S.length()][T.length()];
    }
}
