package main.java.ladders.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * 627. Longest Palindrome - Easy

Given a string which consists of lowercase or uppercase letters, 
find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

 Notice: Assume the length of given string will not exceed 1010.
 
Example
Given s = "abccccdd" return 7

One longest palindrome that can be built is "dccaccd", whose length is 7.

Tags: Hash Table Amazon

Related Problems 
Easy Palindromic Ranges 25 %
Medium Convert Palindrome 21 %
Easy Valid Palindrome 24 %
 * 
 * */
public class LongestPalindrome {
	/**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
	
	//My Fave
	//Thoughts: Just count he number of same pairs, 
	//then this can be used to put in the different direction to consist of problem.
	//Then if there exist more chars, we can put one in the middle.
    public int longestPalindrome(String s) {
        // write your code here
    	if(s == null || s.length() == 0) return 0;
    	HashSet<Character> set = new HashSet<Character>();
    	int count = 0;
    	for(int i = 0; i < s.length(); i++) {
    		if(set.contains(s.charAt(i)))
    			set.remove(s.charAt(i));
    		else
    			set.add(s.charAt(i));
    	}
    	int odd = set.size();
    	return s.length() - (odd == 0 ? 0 : odd - 1);
    }
    
    
    //Juizhang Solution
    public int longestPalindrome1(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
}
    
    
    
    

}
