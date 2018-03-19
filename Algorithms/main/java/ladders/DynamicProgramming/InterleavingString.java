package main.java.ladders.DynamicProgramming;
/**
 * 29. Interleaving String - Medium

Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

Example
For s1 = "aabcc", s2 = "dbbca"

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
Challenge 
O(n2) time or better

Tags:Longest Common Subsequence Dynamic Programming

Related Problems 
Medium Distinct Subsequences 32 %
 * */
/* Analysis: valid[i][j] means whether s1[0 ... i-1] and s2[0...j-1] could
 * construct s3[0...i+j-1]
 * As the algorithm goes row by row and we only need the saved information of the
 * previous row. We can use 1-dimensional DP to retrieve old data and 
 * override old data with new data.
 * The logic goes as follows: Consider s1 = "aabcc", s2 = "dbbca"
 * 								  When s3 = "aadbbcbcac" return true
 * For given position[i,j] in the table,we have two choices: 
 * 	1.valid[i-1,j] && s1.charAt[i] == s3.charAt[i+j], for e.g., 
 *    for s1=”aabc”, s2=”db” and s3=”aadbbc”, 
 *    as “aab”+”db”=>“aadbb” & “c” of s1 and s3 matches, 
 *    this case is valid.
 *    
 *  2. valid[i,j-1] && s2.charAt[j] == s3.charAt[i+j], for e.g., 
 *  for s1=”aabc”, s2=”dbb” and s3=”aadbbcb”, 
 *  as “aabc”+”db”=>“aadbbc” & “b” of s2 and s3 matches, 
 *  this case is valid.
 *  
 *  Reference: http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/
 *  		   http://blog.welkinlan.com/2015/04/28/interleaving-string-leetcode-java-dp/
 *  
 * */
public class InterleavingString {
	/**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
	// passes 16/18 test casses,wrong answer
    public boolean isInterleave(String s1, String s2, String s3) {
    	 if (s1 == null || s2 == null || s3 == null) return false;
         if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) return true;
         if ((s1.length() + s2.length()) != s3.length()) return false;
     	String shorterString, longerString;
     	if (s1.length() < s2.length()) {
     		shorterString = s1;
     		longerString = s2;
     	} else {
     		shorterString = s2;
     		longerString = s1;
     	}
     	boolean[] valid = new boolean[shorterString.length() + 1];
     	valid[0] = true;
     	for (int i = 1; i <= shorterString.length(); i++) {
     	    if (shorterString.charAt(i-1)==s3.charAt(i-1)) valid[i]=true;
     	}
     	for (int i = 1; i <= longerString.length(); i++) {
     		for (int j = 1; j <= shorterString.length(); j++) {
     			valid[j] = (valid[j] && longerString.charAt(i-1)==s3.charAt(i+j-1)) ||
                            (valid[j-1] && shorterString.charAt(j-1)==s3.charAt(i+j-1));
     		}
     	}
         return valid[shorterString.length()];
    }
    // full solution
    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        boolean [][] interleaved = new boolean[s1.length() + 1][s2.length() + 1];
        interleaved[0][0] = true;
        
        for (int i = 1; i <= s1.length(); i++) {
            if(s3.charAt(i - 1) == s1.charAt(i - 1) && interleaved[i - 1][0])
                interleaved[i][0] = true;
        }
        
        for (int j = 1; j <= s2.length(); j++) {
            if(s3.charAt(j - 1) == s2.charAt(j - 1) && interleaved[0][j - 1])
                interleaved[0][j] = true;
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaved[i - 1][j]))
                    || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && interleaved[i][j - 1]))
                interleaved[i][j] = true;
            }
        }
        
        return interleaved[s1.length()][s2.length()];
    }
}
