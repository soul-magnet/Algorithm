package main.java.ladders.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 136. Palindrome Partitioning - Medium

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Have you met this question in a real interview? Yes
Example
Given s = "aab", return:

[
  ["aa","b"],
  ["a","a","b"]
]
Tags: Backtracking Depth First Search

Related Problems 
Medium Palindrome Partitioning II 23 %
 * 
 * */


public class PalindromePartitioning {
	//Version 1: DFS
	 public List<List<String>> partition(String s) {
		 
		 List<List<String>> result = new ArrayList<List<String>>();
		 List<String> list = new ArrayList<String>();
		 dfs(s, 0, list, result);
		 return result;
	}
	 
	 public void dfs(String s, int position, List<String>list, List<List<String>>result){
		 if(position == s.length())
			 result.add(new ArrayList<String>(list));
		 else {
			 for(int i = position; i < s.length(); i++) {
				 if(isPalindrome(s, position, i)) {
					 list.add(s.substring(position, i+1));
					 dfs(s, i+1, list, result);
					 list.remove(list.size()-1);
				 }
			 }
		 }
	 }
	 
	 public boolean isPalindrome(String s, int low, int high) {
		 while(low < high)
			 if(s.charAt(low++) != s.charAt(high--))
				 return false;
		 return true;
	 }
	 
	 //Version 2: DP Solution
	 

}
