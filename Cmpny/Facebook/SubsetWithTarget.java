package Facebook;

import java.util.Arrays;

/**
 * 818. Subset With Target - Hard

Give an array and a target. We need to find the number of subsets which meet the following conditions:
The sum of the minimum value and the maximum value in the subset is less than the target.

 Notice
The length of the given array does not exceed 50.
target <= 100000.

Example
Give array = [1,5,2,4,3], target = 4, return 2.

Explanation:
Only subset [1],[1,2] satisfy the condition, so the answer is 2.
Give array = [1,5,2,4,3],target = 5, return 5.

Explanation:
Only subset [1],[2],[1,3],[1,2],[1,2,3] satisfy the condition, so the answer is 5.

Tags: Facebook
 * */

//Juzihang Solution
public class SubsetWithTarget {
	 /**
     * @param nums: the array
     * @param target: the target
     * @return: the number of subsets which meet the following conditions
     */
    public long subsetWithTarget(int[] nums, int target) {
        // Write you code here
		Arrays.sort(nums);
	    long ans = 0;
	    for(int i = 0; i < nums.length; i++) {
	        int j = i;
	        while(j + 1 < nums.length && nums[i] + nums[j + 1] < target) {
	            j++;
	        }
	        if(nums[i] + nums[j] < target) {
	            ans += ((long)1<<(j - i)) ;
	        }
	        
	    }
	    return ans;
    }
}
