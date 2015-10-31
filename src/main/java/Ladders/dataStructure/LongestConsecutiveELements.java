package DataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Have you met this question in a real interview? Yes
Example
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Clarification
Your algorithm should run in O(n) complexity.
*/

// Because it requires O(n) complexity, we can not solve the problem
// by sorting the array, which takes at least O(nlogn) time.
// we can use HashSet to add and remove elements. HashSet is implemented by using hash table.
// Elements are not ordered. The add, remove and contains methods have constant time complexity O(1).

public class LongestConsecutiveELements {
	// if array is empty, return 0
	public static int longestConsecutive(int[] num) {
		if (num.length == 0) {
			return 0;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;
		
		for (int index : num){
			int left = index - 1;
			int right = index + 1;
			int count = 1;
			
			while (set.contains(left)){
				count++;
				set.remove(left);
				left--;
			}
			
			while(set.contains(right)){
				count++;
				set.remove(right);
				right++;
			}
			max = Math.max(count, max);
		}
		
		return max;
		
	}
	
	// if you use hash map instead of hash set 
	// Sort & Search : space O(1) and time O(n logn)
	
	/*public int longestConsecutive(int[] num) {
		HashMap<Integer, Integer>hs =  new HashMap<Integer, Integer>();
		for(int i : num){
			hs.put(i, 0);
		}
		int maxL = 1;
		for (int i : num){
			if(hs.get(i) == 1) continue;
			
			int tmp = i;
			int current_max = 1;
			while(hs.containsKey(tmp + 1)){
				current_max++;
				tmp++;
				hs.put(tmp, 1);
			}
			tmp = i;
			while(hs.containsKey(tmp - 1)){
				current_max++;
				tmp--;
				hs.put(tmp, 1);
			}
			maxL = Math.max(current_max, maxL);
		}
		return maxL;
	}*/

}
