package HighFrequency;

import java.util.ArrayList;
import java.util.HashMap;

/* Tags: SubArray,HashTable
 * 
 * Given an integer array, find a subarray where the sum of numbers is zero.
 * Your code should return the index of the first number and the index of the last number.
 * 
 * Example
 * Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3]
 *
 * Analysis:
 * Intuitive solution is to use O(n2) time to consider every subarray
 * The better solution is to use a HashMap to map, when we meet two indexes
 * p and q with the same sum, we conclude that sum of subarray 
 * [p + 1 ... q] must be zero
 * 
 * */
public class SubArraySum {
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
	
	public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int len = nums.length;
		int sum = 0;
		
		for (int i = 0; i < len; i++){
			sum += nums[i];
			
			if (map.containsKey(sum)) {
				result.add(map.get(sum) + 1);
				result.add(i);
				return result;
			}
			
			map.put(sum, i);
		}
		return result;
    }
}
