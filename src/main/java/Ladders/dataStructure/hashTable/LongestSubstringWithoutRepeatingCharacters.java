package dataStructure.hashTable;

import java.util.Arrays;
import java.util.HashSet;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters 
 * for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * Challenge: O(n) time
 * Tag: Two Pointers, HashTable, String
 * 
 * Hint: Is there a better way other than brute force? Consider the kind of data structure
 * that can improve the run time complexity.
 * An ideal solution requires inly a one-time linear scan.
 * Make sure if the string can have characters other than 'a'-'z'(digits,
 * uppercase character? does it contain ASCII character only?
 * Or even unicode character sets?)
 * 
 * Analysis: 
 * 
 * Set two pointers, i and j. Scan the string from the start to the end.
 * Set a table to store if the character has occurred. 
 * if s[j] has occurred in S[i...j-1], compute current length and compare to the max length.
 * Then table[s[i]] = false; i++;
 * if s[j] has not occurred in S[i ..j-1], table[s[j]] = true; j++;
 * */
public class LongestSubstringWithoutRepeatingCharacters {
	/**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
    	 if (s == null || s.length() == 0) {
             return 0;
         }
         
         HashSet<Character> set = new HashSet<Character>();
         
         int leftBound = 0, max = 0;
         for (int i = 0; i < s.length(); i++) {
             if (set.contains(s.charAt(i))) {
                 while (leftBound < i && s.charAt(leftBound) != s.charAt(i)) {
                     set.remove(s.charAt(leftBound));
                     leftBound ++;
                 }
                 leftBound ++;
             } else {
                 set.add(s.charAt(i));
                 max = Math.max(max, i - leftBound + 1);
             }
         }
         
         return max;
    
    }
    
    // Another version with Array 
    public int lengthOfLongestSubstring1(String s){
    	if (s == null || s.length() == 0)
    		return 0;
    	
    	int[] map = new int[256]; // map from character's ASCII to its last occurred index
    	Arrays.fill(map, -1);
    	
    	int slow = 0 ;
    	int fast = 0;
    	int ans = 0;
    	for (fast = 0; fast < s.length(); fast++){
    		int ch = s.charAt(fast);
    		while (map[ch] != -1 && slow < fast){
    			int temp = s.charAt(slow);
    			map[temp] = -1;
    			slow++;
    		}
    		map[ch] = 0;
    		ans = Math.max(ans, fast - slow + 1);
    	}
    	return ans;
    }
    
}
