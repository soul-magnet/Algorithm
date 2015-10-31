package GraphSearch;

import java.util.ArrayList;

/*
 * Given a list of integers, which denote a permutation.
 * Find the previous permutation in ascending order.
 * Example: For [1,3,2,3], the previous permutation is [1,2,3,3]
 * For [1,2,3,4], the previous permutation is [4,3,2,1]
 * Note: The list may contains duplicate integers.
 * */
public class PreviousPermutation {
	/**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		int peak = nums.size() - 1;
		while (peak > 0 && nums.get(peak - 1) <= nums.get(peak)){
			peak--;
		}
		peak--;
		if(peak >= 0){
			int swap = peak+1;
			while(swap < nums.size() && nums.get(swap) < nums.get(peak)){
				swap++;
			}
			swap--;
			int tmp = nums.get(swap);
			nums.set(swap, nums.get(peak));
			nums.set(peak, tmp);
		}
		int left = peak + 1;
		int right = nums.size() - 1;
		while (left < right){
			int tmp = nums.get(left);
			nums.set(left, nums.get(right));
			nums.set(right, tmp);
			left++;
			right--;
		}
		return nums;
    }
    
}
