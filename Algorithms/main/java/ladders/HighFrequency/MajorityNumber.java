package HighFrequency;

import java.util.ArrayList;

/*
 * Given an array of integers, the majority number is the number that 
 * occurs more than half of the size of the array. Find it.
 * Example:
 * Given [1, 1, 1, 1, 2, 2, 2], return 1
 * Challenge:
 * O(n) time and O(1) extra space
 * */
public class MajorityNumber {
	/**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int count = 0, candidate = -1;
        
        for (int i = 0; i < nums.size(); i++){
        	if (count == 0) {
        		candidate = nums.get(i);
        		count  = 1;
        	} else if (candidate == nums.get(i)) {
        		count++;
        	} else {
        		count--;
        	}
        }
        
        return candidate;
    }
}
