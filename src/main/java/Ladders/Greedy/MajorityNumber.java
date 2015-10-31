package Greedy;

import java.util.ArrayList;

/* Given an array of integers, the majority number is the number that 
 * occurs more than half of the size of the array. Find it.
 * Given [1, 1, 1, 1, 2, 2, 2], return 1
 * Challenge: O(n) time and O(1) extra space
 * Analysis: 
 * We can use HashMap as well, construct a hashmap that he key is each element
 * in the num, the value is the occurrence of num.
 * Check the value while constructing the map an get the result.
 * */

public class MajorityNumber {
	/**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
	public int majorityNumber(ArrayList<Integer> nums){
		int count = 0, candidate  = -1;
		for (int i = 0; i < nums.size(); i++){
			if (count == 0){
				candidate = nums.get(i);
			} else if (candidate == nums.get(i)){
				count++;
			} else {
				count--;
			}
		}
		
		return candidate;
	}
	// Another solution
	public int majorityNumber2(ArrayList<Integer> nums){
		if (nums == null || nums.size() == 0){
            return -1;
        }
        
        int voted = nums.get(0);
        int votes = 1;
        for (int i = 1; i < nums.size(); i++){
            if (nums.get(i) != voted){
                votes--;
            } else {
                votes++;
            }
            if (votes == 0){// reset current majority number
            votes = 1;
            voted = nums.get(i);
                
            }
        }
        return voted;
	}
}
