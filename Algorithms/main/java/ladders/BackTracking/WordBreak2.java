package main.java.ladders.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 582. Word Break II - Hard

Given a string s and a dictionary of words dict, 
add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.
 
Example
Gieve s = lintcode,
dict = ["de", "ding", "co", "code", "lint"].

A solution is ["lint code", "lint co de"].

Tags 
Backtracking Dynamic Programming
Related Problems 
Medium Word Break III 33 %
Easy Split String 21 %
Medium Word Break 14 %
 * */
public class WordBreak2 {
	/*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
	public List<String> wordBreak(String s, Set<String> wordDict){
		ArrayList<String> result = new ArrayList<String>();
		if (s.length() == 0)
			return result;
		
		boolean[][] isWord = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++){
			for (int j = i; j < s.length(); j++){
				String word = s.substring(i, j + 1);
				isWord[i][j] = wordDict.contains(word);
			}
		}
		
		boolean[] possible = new boolean[s.length() + 1];
		possible[s.length()] = true;
		for (int i = s.length() - 1; i >= 0; i--){
			for (int j = i; j < s.length(); j++){
				if (isWord[i][j] && possible[j + 1]){
					possible[i] = true;
					break;
				}
			}
		}
		List<Integer> path = new ArrayList<Integer>();
		search(0, s, path, isWord, possible, result);
		return result;
	}
	
	private void search(int index, String s,
			List<Integer>path, boolean[][]isWord,
	        boolean[] possible,List<String>result){
		if (!possible[index]){
			return;
		}
		
		if(index == s.length()){
			StringBuilder sb = new StringBuilder();
			int lastIndex = 0;
			for (int i = 0; i < path.size(); i++){
				sb.append(s.substring(lastIndex, path.get(i)));
				if (i != path.size() - 1) sb.append(" ");
				lastIndex = path.get(i);
			}
			result.add(sb.toString());
			return;
		}
		
		for (int i = index; i < s.length(); i++){
			if(!isWord[index][i])
				continue;
			path.add(i + 1);
			search(i + 1, s, path, isWord, possible, result);
			path.remove(path.size() - 1);
		}
			
	}
	
	// version 2: 
	
	public ArrayList<String> wordBreak2(String s, Set<String> dict){
		// Note: the solution object is instantiated only once and is reused by
		// each test case
		
		Map<String, ArrayList<String>>map = new HashMap<String, ArrayList<String>>();
		return wordBreakHelper(s, dict, map);
	}

	private ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo) {
		
		if (memo.containsKey(s)) return memo.get(s);
		ArrayList<String>result = new ArrayList<String>();
		int n = s.length();
		if (n <= 0) return result;
		for (int len = 1; len <= n; ++len){
			String subfix = s.substring(0, len);
			if (dict.contains(subfix)){
				if (len == n){
					result.add(subfix);
				} else {
					String prefix = s.substring(len);
					ArrayList<String> tmp  = wordBreakHelper(prefix, dict, memo);
					for (String item : tmp){
						item = subfix + " " + item;
						result.add(item);
					}
				}
			}
		}
		memo.put(s, result);
		return result;
	}
}


