package main.java.ladders.Greedy;
/**
 * 46. Majority Number - Easy

Given an array of integers, the majority number is the number that occurs more than half of the size of the array. 
Find it.

 Notice
You may assume that the array is non-empty and the majority number always exist in the array.

Example
Given [1, 1, 1, 1, 2, 2, 2], return 1

Challenge 
O(n) time and O(1) extra space

Tags: Enumeration LintCode Copyright Greedy Zenefits

Related Problems 
Medium Single Number III 36 %
Medium Single Number II 40 %
Easy Single Number 46 %
Medium Majority Number III 30 %
Medium Majority Number II 31 %
Medium Digit Counts 26 %
 * */
import java.util.ArrayList;

/* Analysis: 
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
