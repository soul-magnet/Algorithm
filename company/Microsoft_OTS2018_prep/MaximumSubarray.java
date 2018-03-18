package Microsoft_OTS2018_prep;
/**LintCode: 41. Maximum Subarray - Modified: Return the maximum subarray itself
   LeetCode 53. Maximum Subarray
   
Given an array of integers, find a contiguous subarray which has the largest sum.

 Notice: The subarray should contain at least one number.

Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

Challenge 
Can you do it in time complexity O(n)?

Tags: Greedy LinkedIn Array LintCode Copyright Subarray Enumeration

Related Problems 
Hard Maximum Subarray V 30 %
Medium Maximum Subarray IV 35 %
Medium Maximum Average Subarray 18 %
Medium Continuous Subarray Sum 25 %
Medium Best Time to Buy and Sell Stock III 27 %
Hard Maximum Subarray III 25 %
 * */

public class MaximumSubarray {
    /**
	 * @param nums
	 *            : A list of integers
	 * @return: A integer indicate the sum of max subarray
	 */
	public int maxSubArray2(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}
		return max;
	}
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray1(int[] nums) {
        // write your code
    	//max= max(curent sum- min, max ); min=(min, sum),
        // dp[i]=max(dp[i-1]+num[i], num[i]), max=max(max,dp[i]);
        if(nums.length==0||nums==null){
            return 0;
        
        }
        // prefix add to together, 0+num[i]
        int max=Integer.MIN_VALUE, 
        sum=0, 
        minsum=0;
        //sum-minsum
        for(int i =0;i < nums.length; i++){
            sum+=nums[i]; 
            max=Math.max(sum-minsum, max);
            minsum=Math.min(sum, minsum);
        }
        return max;
    }
    /**
	 * @param nums
	 *            : A list of integers
	 * @return: A integer indicate the sum of max subarray
	 */
	public int maxSubArray(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		int [] local = new int[nums.length];
        int [] global = new int[nums.length];
        local[0]= nums[0]; global[0]=nums[0];
        for (int i=1; i< nums.length;i++){
            local[i]=Math.max(nums[i], local[i-1]+nums[i]);
            global[i]= Math.max(local[i],global[i-1]);
        }
        return global[nums.length-1];
	}
}
