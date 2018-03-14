package main.java.ladders.PermutationBasedDFS;

import java.util.Set;
/**
 * 107. Word Break - Medium

Given a string s and a dictionary of words dict, 
determine if s can be break into a space-separated sequence of one or more dictionary words.

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
/* Analysis: First thought is DFS, searching every dict elements, if matched
 * go to the next position of s, until find the last match. 
 * 
 * Consider a very long s has a bunch of "a" and other letters, and the dict
 * has "a", the searching will be pretty slow then.
 * 
 * 
 * */
public class WordBreak {
	/**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
	
	/*
	 * DP Solution, however there is one TLE case
	 * Add a checker to check the max length of all dict items
	 * to skip checking
	 * */ 
	public boolean wordBreakDP(String s, Set<String> dict){
		if (s == null || s.length() == 0)
			return true;
		boolean[] res = new boolean[s.length() + 1];
		res[0] = true; // initialize to be true
		for (int i = 0; i < s.length(); i++){
			StringBuilder str = new StringBuilder(s.substring(0, i + 1));
			for (int j = 0; j <= i; j++){
				if (res[j] && dict.contains(str.toString())){
					res[i + 1] = true;
					break;
				}
				str.deleteCharAt(0);
				// as j increases, move right one char of str to keep str as s[j, i+1]
			}
		}
		return res[s.length()];
	}
	
	// Version 2
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0)
        	return true;
        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];
        
        canSegment[0] = true;
        for (int  i = 1; i <= s.length(); i++){
        	canSegment[i] = false;
        	for (int lastWordLength = 1;
        			lastWordLength <= maxLength && lastWordLength <= i;
        			lastWordLength++){
        		if(!canSegment[i - lastWordLength]){
        			continue;
        		}
        		String word = s.substring(i - lastWordLength, i);
        		if(dict.contains(word)){
        			canSegment[i] = true;
        			break;
        		}
        	}
        }
        return canSegment[s.length()];
    }
    
    private int getMaxLength(Set<String>dict){
    	int maxLength = 0;
    	for (String word : dict){
    		maxLength = Math.max(maxLength, word.length());
    	}
    	return maxLength;
    }
    
    
}
