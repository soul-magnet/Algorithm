package Greedy;

import java.util.Arrays;

/*
 * Implement next permutation, which rearranges numbers 
 * into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange 
 * it as the lowest possible order (ie, sorted in ascending order).
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * Challenge: The replacement must be in-place, do not allocate extra memory.
 * 
 * 
 * */
public class NextPermutationII {
	/**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0){
        	return;
        }
        
        for (int i = nums.length -2; i >= 0; i--){
        	if (nums[i] < nums[i+1]){
        		int j = nums.length - 1;
        		for (; j>i; j--){
        			if (nums[i] < nums[j]){
        				break;
        			}
        		}
        		int temp = nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        		reverse(nums, i+1, nums.length-1);
        		return;
        	}
        }
        Arrays.sort(nums);
        
    }
    
    private void reverse(int[] nums, int i, int j){
    	while (i < j){
    		int temp = nums[i];
    		nums[i] = nums[j];
    		nums[j] = temp;
    		i++;
    		j--;
    	}
    }
}
