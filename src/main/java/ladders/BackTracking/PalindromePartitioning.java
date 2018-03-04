package main.java.ladders.BackTracking;

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

/* Thoughts
 * 
 * 
 * */
public class PalindromePartitioning {
	
	
	//Version 1: DFS Solution + BackTracking
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
	 
	 //Version 2: DP + DFSApproach
	 //Thought Process: Asked myself how to check if a string is Palindrome or not.
	 //Usually a two point solution scanning from front and back
	 
	 //if you want to get all the possible palindrome partition
	 //first a nested for loop to get every possible partition for a string
	 //then a scanning for all the parititons.
	 //that's a O(n^2) for partition and O(n^2) for scanning of a string
	 //totaling at O(n^4) just for the partiotion.
	 
	 //However if we use 2D array to keep track of any string we have scanned so far with an additional pair
	 //we can determine whether it is palindrome or not by just looking at that pair
	 //which is the lineif(s.charAt(i) == s.charAt(j) && (i-j <= 2 || dp[j+1][i-1]))
	 //this way, the 2D array dp contains the possible palindrome partition among all
	 
	 //Second - Based on the prescanned palindrome partitions saved in dp array, a simple backtrack does the job
	 public List<List<String>>partition1(String s){
		List<List<String>>result = new ArrayList<>();
		boolean dp[][] = new boolean[s.length()][s.length()];
		
		for(int i=0; i < s.length(); i++) {
			for(int j = 0; j <= i; j++) {
				if(s.charAt(i) == s.charAt(j) && (i - j) <= 2 || dp[j+1][i-1]) {
					dp[j][i] = true;
				}
			}
		}
		
		helper(result, new ArrayList<>(), dp, s, 0);
		return result;
	 }
	 
	 private void helper(List<List<String>>result, List<String>path, boolean[][]dp, String s, int pos) {
		 if(pos == s.length()) {
			 result.add(new ArrayList<>(path));
			 return;
		 }
		 
		 for(int i = pos; i < s.length(); i++) {
			 if(dp[pos][i]) {
				 path.add(s.substring(pos, i+1));
				 helper(result, path, dp, s, i+1);
				 path.remove(path.size() - 1);
			 }
		 }
	 }
	 

}
