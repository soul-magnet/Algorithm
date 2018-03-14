package main.java.ladders.searchAndRecursion;

import java.util.Set;

/**
 * 108. Palindrome Partitioning II - Medium - Related

Given a string s, cut s into some substrings such that every substring is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Have you met this question in a real interview? 
Example
Given s = "aab",

Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.

Tags 
Dynamic Programming
Related Problems 
Medium Wiggle Sort II 25 %
Medium Palindrome Partitioning 28 %
Medium Longest Palindromic Substring 29 %
 * */
public class PalindromePartitioning2 {
	  private int getMaxLength(Set<String> dict) {
	        int maxLength = 0;
	        for (String word : dict) {
	            maxLength = Math.max(maxLength, word.length());
	        }
	        return maxLength;
	    }  

	    public boolean wordBreak(String s, Set<String> dict) {
	        if (s == null || s.length() == 0) {
	            return true;
	        }

	        int maxLength = getMaxLength(dict);
	        boolean[] canSegment = new boolean[s.length() + 1];

	        canSegment[0] = true;
	        for (int i = 1; i <= s.length(); i++) {
	            canSegment[i] = false;
	            for (int lastWordLength = 1;
	                     lastWordLength <= maxLength && lastWordLength <= i;
	                     lastWordLength++) {
	                if (!canSegment[i - lastWordLength]) {
	                    continue;
	                }
	                String word = s.substring(i - lastWordLength, i);
	                if (dict.contains(word)) {
	                    canSegment[i] = true;
	                    break;
	                }
	            }
	        }

	        return canSegment[s.length()];
	    }

}
