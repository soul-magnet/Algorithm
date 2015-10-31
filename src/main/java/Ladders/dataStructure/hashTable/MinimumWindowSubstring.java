package dataStructure.hashTable;

import java.util.HashMap;

/*
 * Given a string source and a string target, find the minimum window 
 * in source which will contain all the characters in target.
 * Example: source = "ADOBECODEBANC" target = "ABC" Minimum window is "BANC".
 * Note: If there is no such window in source that covers all characters 
 * in target, return the emtpy string "".
 * If there are multiple such windows, you are guaranteed that 
 * there will always be only one unique minimum window in source.
 * Challenge: Can you do it in time complexity O(n) ?
 * Clarification: Should the characters in minimum window has the same order in target?
 * - Not necessary.
 * Tags: HashTable
 * Analysis:
 * Hint: - How do we determine if a particular window contains T? (ideally in O(1) time)
 *       - How do we select all windows efficiently? (Ideally do not include
 *       other windows that wrap about a sub-window)
 * We have two pointers, p and q. S[p:q] stores the string covers
 * all the chars in T. We want minimum p:q
 * Start from the whole S, p=0, q= S.size()-1, if cannot cover T, return "";
 * Fix p, try to move q close to p, but keeo the requirement S[p:q] covers T.
 * Find the shortest p:q, here exactly is 1:q, where S[1:q] covers T.
 * Move p and q dynamically:
 * 	if S[p] is irrelevant char, p++;
 * 	if S[p] is char in T, must move q to left until find S[q] == S[p] to keep 
 * the requirement, or q is last.
 * 	When move q to left, if S[q] is in T, store the S[q] occurrence.
 * Every move, compare the length p:q store the minimum length and position.
 * 
 *  To check if the S[p:q] covers T, because the complexity requirement, the idea goes as follows:
 *  (1) use map<char, int>, to store the occurrence of chars in S and T. Be careful with duplicate case.
 *  (2) Check the occurrence of MapS and mapT, if mapS[T[i]]<mapT[T[i]]>, return false;
 *  After find the first covered String[1:q], ew do like one-by-one move, so the cover test can only be
 *  the occurrence of the first char S[p], and when move q, don't forget add occurrence if meets S[q] in T.
 * 
 * In a Nut Shell;
 * 1. keep absorbing new elements(by moving right border)until we have all candidates we need.
 * 2. keep squeezing the window (cy moving the left border) until we have abandoned all 
 * "extra" candidates. Update the minimum window size
 * 3. go to 1. 
 *  */
public class MinimumWindowSubstring {
	public String minWindow(String S, String T){
		if (S == null || T == null || S.length() == 0 || T.length() == 0)
			return "";
		HashMap<Character, Integer>map = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++){
			if (map.containsKey(T.charAt(i))){
				map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
			} else {
				map.put(T.charAt(i), 1);
			}
		}
		int count = 0;
		int left = 0;
		String result = "";
		int minLen = S.length() + 1;
		for (int right = 0; right < S.length(); right++){
			char currentChar =  S.charAt(right);
			if (map.containsKey(currentChar)){
				map.put(currentChar, map.get(currentChar) - 1);
				if (map.get(currentChar)>= 0){// if this is not a redundant key
					count++;
				}
				while(count == T.length()) // we move the left border right, until we find one that breaks the window
				{
					char leftChar =  S.charAt(left);
					if (map.containsKey(leftChar)){
						map.put(leftChar, map.get(leftChar)+1);
						// if this is the one needed for maintaining the window(not a redundant key)
						if (map.get(leftChar)>0)
						{
							if(minLen > right - left + 1){
							result = S.substring(left, right+1);
							minLen = right - left + 1;
							}
							count--;
						}
						
					}
					left++;
				}
			}
		}
		
		return result;
	}

}
