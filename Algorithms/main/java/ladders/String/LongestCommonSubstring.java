package String;
/* Given two strings, find the longest common substring
 * Return the length of it. 
 * Example: 
 * Given A = "ABCD", B = "CBCE", return 2.
 * Note
 * The characters in substring should occur continuously in original string. 
 * This is different with subsequence.
 * Challenge:
 * O(n x m) time and memory.
 * 
 * Analysis:
 * Use DP, update the max during building table
 * dp[i][j] = 0(A.charAt(i) != B.charAt(i))
 * dp[i][j] = dp[i-1][j-1] + 1 (A.charAt(i) != B.charAt(i))
 * 
 * */

public class LongestCommonSubstring {
	/**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
	public int longestCommonSubstring(String A, String B){
		int maxLen = 0;
		int xLen = A.length();
		int yLen = B.length();
		
		for (int i = 0; i < xLen; i++) {
			for(int j = 0; j < yLen; j++){
				int len = 0;
				while (i + len < xLen && j + len < yLen && 
				A.charAt(i + len) == B.charAt(j + len))
					len++;
				if (len > maxLen){
					maxLen = len;
				}
					

			}
		}
		return maxLen;
	}

}
