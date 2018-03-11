package main.java.ladders.DepthFirstSearch;
/**
 * 107. Word Break - Medium - Related

Given a string s and a dictionary of words dict, 
determine if s can be break into a space-separated sequence of one or more dictionary words.

Have you met this question in a real interview? 
Example
Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code".

Tags 
String Dynamic Programming
Related Problems 
Medium Word Break III 33 %
Easy Split String 21 %
Hard Word Break II 20 %
 * */
public class WordBreak {
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
