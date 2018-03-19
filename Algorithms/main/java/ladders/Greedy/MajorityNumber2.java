package main.java.ladders.Greedy;

import java.util.ArrayList;
/**
 * 47. Majority Number II - Medium

Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.

Find it.

 Notice
There is only one majority number in the array.

Example
Given [1, 2, 1, 2, 1, 3, 3], return 1.

Challenge 
O(n) time and O(1) extra space.

Tags: Enumeration LintCode Copyright Greedy Zenefits

Related Problems 
Medium Single Number III 36 %
Medium Single Number II 40 %
Easy Single Number 46 %
Medium Majority Number III 30 %
Medium Majority Number II 31 %
Easy Majority Number 43 %
 * */
/* Analysis : As there could be at most 2 elements occurring more than 1 / 3 of the array, 
 * we have 2 slots for majority number candidates. Each number votes like this:
 *  - If it is one of the majority number candidates, it votes positive to itself, otherwise
 	- If there is one available majority number slot, it gets the slot and votes positive for itself,
	- otherwise, it votes negative to both majority candidates.
  At last, at least one of the two majority numbers must be more than 1 / 3 of the array.
 * 
 * */
public class MajorityNumber2 {
	
	/**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
    	int candidate1 = 0, candidate2 = 0;
    	int count1 = 0, count2 = 0;
    	for (int i = 0; i < nums.size(); i++){
    		if (candidate1 == nums.get(i)){
    			count1++;
    		} else if (candidate2 == nums.get(i)){
    			count2++;
    		} else if (count1 == 0){
    			candidate1 = nums.get(i);
    			count1 = 1;
    		} else if (count2 == 0){
    			candidate2 = nums.get(i);
    			count2 = 1;
    		} else {
    			count1--;
    			count2--;
    		}
    	}
    	count1 = count2 = 0;
    	for (int i = 0; i < nums.size(); i++){
    		if (nums.get(i) == candidate1){
    			count1++;
    		}
    	}
    	return count1 > count2 ? candidate1 : candidate2;
    }

}
