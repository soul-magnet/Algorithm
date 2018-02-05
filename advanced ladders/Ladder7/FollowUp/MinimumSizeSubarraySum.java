package Ladder7.FollowUp;
/**
 * 406. Minimum Size Subarray Sum - Medium - Required

Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. 
If there isn't one, return -1 instead.


Example
Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.

Challenge 
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

Tags:Array Two Pointers Facebook

Related Problems 
Medium Subarray Sum Closest 21 %
Easy Subarray Sum
 * */
public class MinimumSizeSubarraySum {
	 /**	two pointer

	 这�?�题�?�以用two pointer解，对�?一个i,将j�?��?�移，直到sum >= s, �?��?�的j就�?用看了，因为都是positive,所以肯定大于s
	 time complexity: O(n) space complexity: O(1)
    * @param nums: an array of integers
    * @param s: an integer
    * @return: an integer representing the minimum size of subarray
    */
   public int minimumSize1(int[] nums, int s) {
       	int j = 0, i = 0;
		int sum = 0;
		int ans = Integer.MAX_VALUE;
		for (i = 0; i < nums.length; i++) {
			while (j < nums.length && sum < s) {
				sum += nums[j];
				j++;
			}
			
			if (sum >= s) {
				ans = Math.min(ans, j - i );
			}
			sum -= nums[i];

		}
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		return ans;
   }
   
  public int minimumSize(int[] nums, int s) {
		if(nums==null||nums.length==0){
			return -1;
		}
		int res = Integer.MAX_VALUE, sum =0, l=0, r=0;
		while(r<nums.length){
			sum += nums[r];
			r++;
			while(sum>=s){
				res = Math.min(res,r-l);
				sum-=nums[l];
				l++;
			}
		}
		if (res == Integer.MAX_VALUE) {
			res = -1;
		}
		return res;
	}

}
