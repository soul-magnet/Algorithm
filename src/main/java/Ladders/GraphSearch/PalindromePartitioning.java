package GraphSearch;

import java.util.ArrayList;
import static java.lang.Math.abs;


/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
   Return all possible palindrome partitioning of s.

   Have you met this question in a real interview? Yes
   Example
   given s = "aab",
   Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 * Version 1: Depth First Search
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 * */
public class PalindromePartitioning {
	
	public ArrayList<ArrayList<String>> partition(String s){
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		if (s == null || s.length() == 0) {
			return result;
		}
		// track each possible partition
		ArrayList<String> partition = new ArrayList<String>();
		addPalindrome(s, 0, partition, result);
		
		return result;

	}
	
	void addPalindrome(String s, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> result){
		
		// stop condition
		if (start == s.length()) {
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
		
		for (int i = start + 1; i <= s.length(); i++) {
			String str = s.substring(start, i);
			if (isPalindrome(str)) {
				partition.add(str);
				addPalindrome(s, i, partition, result);
				partition.remove(partition.size() - 1);
			}
		}
	}
	
	private boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	} 
	
}
