package main.java.ladders.searchAndRecursion;

import java.util.ArrayList;
import java.util.List;

/* Given a string s, partition s such that every substring of 
 * the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * Given s = "aab"
 * Return
 * [
    ["aa","b"],
    ["a","a","b"]
  ]
 * 
 * */

// version 1: DFS 
public class PalindromePartitioning {
	/**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0){
        	return result;
        }
        
        List<String> path = new ArrayList<String>();
        helper(s, path, 0, result);
        return result;
        
    }
    private boolean isPalindrome(String s){
    	int start = 0;
		int end = s.length() - 1;
		while (start < end){
			if (s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
    }
	private void helper(String s, List<String> path, int index, List<List<String>> result) {
		if (index == s.length()){
			result.add(new ArrayList<String>(path));
			return;
		}
		for (int i = index + 1; i <= s.length(); i++){
			String prefix = s.substring(index, i);
			//String prefix = s.substring(index, i + 1);
			if (!isPalindrome(prefix)){
				continue;
			}
			path.add(prefix);
			helper(s, path, i, result);
			//helper(s, path, i + 1, result);
			path.remove(path.size() -1);
		}
		
	}
	
	// version2 2: Dynamic Progamming
	
	public List<List<String>> partitionDP (String s){
		List<List<String>> result = new ArrayList<List<String>>();
		if (s == null || s.length() == 0)
			return result;
		int len = s.length();
		
		// dp[i][j]: if this is a palindrome for s.substring(i, j + 1);
		boolean[][] isPalindrome = new boolean[len][len];
		
		for (int j = 0; j < len; j++){
			for (int i = 0; i <= j; i++){
				isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && 
						(j - i <= 2 || isPalindrome[i + 1][j - 1]);
			}
		}
		
		// bug : new map error
		dfs3(s, 0, new ArrayList<String>(), result, isPalindrome);
		return result;
	}
	private void dfs3(
			String s, 
			int index, 
			ArrayList<String> path, 
			List<List<String>> result,
			boolean[][] isPalindrome) {
		int len = s.length();
		if (index == len){
			result.add(new ArrayList<String>(path));
			return ;
		}
		
		for (int i = index; i < len; i++){
			String sub = s.substring(index, i + 1);
			if (!isPalindrome[index][i]){
				continue;
			}
			path.add(sub);
			dfs3(s, i + 1, path, result, isPalindrome);
			path.remove(path.size() - 1);
		}
		
	}
	
}
