package main.java.ladders.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 392. Is Subsequence - LeetCode - Medium 
 * 
 * Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. 
t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of 
the characters without disturbing the relative positions of the remaining characters. 
(ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, 
and you want to check one by one to see if T has its subsequence. 
In this scenario, how would you change your code?

Related Topics: Binary Search, DP, Greedy
 * */
public class IsSubSequence {
	//Thoughts: Just use two pointers
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while(indexT < t.length()) {
        	if(t.charAt(indexT) == s.charAt(indexS)) {
        		indexS++;
        		if(indexS == s.length()) return true;
        	}
        	indexT++;
        }
        return false;
    }
    
    //Thoughts: Binary Search
    public boolean isSubsequence1(String s, String t) {
    	List<Integer>[]idx = new List[256]; //just for clarify
    	for(int i = 0; i < t.length(); i++) {
    		if(idx[t.charAt(i)] == null)
    			idx[t.charAt(i)] = new ArrayList<>();
    		idx[t.charAt(i)].add(i);
    	}
    	
    	int prev = 0;
    	for(int i = 0; i < s.length(); i++) {
    		if(idx[s.charAt(i)] == null) return false; // Note: char of S does NOT exist in t causing NPE
    		int j = Collections.binarySearch(idx[s.charAt(i)], prev);
    		if(j < 0) j = -j - 1;
    		if(j == idx[s.charAt(i)].size()) return false;
    		prev = idx[s.charAt(i)].get(j) + 1;
    	}
    	
    	return true;
    }
	

}
