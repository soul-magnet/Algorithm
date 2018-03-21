package Microsoft_OTS2018_prep;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 191. Maximum Product Subarray - Medium - Related(LintCode) 
 * 152. Maximum Product Subarray  -Medium - (LeetCode)

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example
For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.

Tags: Subarray Dynamic Programming LinkedIn

Related Problems 
Medium Rogue Knight Sven 31 %
Medium Best Time to Buy and Sell Stock 40 %
Medium Maximum Subarray Difference 24 %
Easy Minimum Subarray 37 %
Medium Maximum Subarray II 26 %
 * */
public class MaximumProductSubarray {
	 /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public static int maxProduct(int[] nums) {
		int[] max = new int[nums.length];
		int[] min = new int[nums.length];

		min[0] = max[0] = nums[0];
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			min[i] = max[i] = nums[i];
			if (nums[i] > 0) {
				max[i] = Math.max(max[i], max[i - 1] * nums[i]);
				min[i] = Math.min(min[i], min[i - 1] * nums[i]);
			} else if (nums[i] < 0) {
				max[i] = Math.max(max[i], min[i - 1] * nums[i]);
				min[i] = Math.min(min[i], max[i - 1] * nums[i]);
			}

			result = Math.max(result, max[i]);
		}

		return result;
	}
    
    //Another version
    public int maxProduct1(int[] nums) {
       int max = Integer.MIN_VALUE;    // global max
       int maxloc = 1, minloc = 1;     // max or min end here
       for (int num : nums) {          // negative could cause maxloc and minloc swap
           int prod1 = maxloc * num, prod2 = minloc * num;
           maxloc = Math.max(num, Math.max(prod1, prod2));
           minloc = Math.min(num, Math.min(prod1, prod2));
           max = Math.max(max, maxloc);
       }
       return max; 
       
   }
    
    public static int[] maxPro1(int[] nums) {
    	int[] result = new int[nums.length];
    	int begin = 0, end = 0;
    	int max = Integer.MIN_VALUE;
    	int maxLoc = 1, minLoc = 1;
    	for(int i = 0; i < nums.length; i++) {
    		int prod1 = Math.max(maxLoc, nums[i]);
    		int prod2 = Math.max(minLoc, nums[i]);
    		maxLoc = Math.max(nums[i], Math.max(prod1, prod2));
    		minLoc = Math.max(nums[i], Math.max(prod1, prod2));
    		max = Math.max(max, maxLoc);
    		if(max == maxLoc) {
    			end = i;
    		}
    	}
    	return Arrays.copyOfRange(nums, begin, end+1);
    }
    
    static int arr[] = {1, -2, -3, 0, 7, -8, -2};
    public static void subArray(int n) {
    	for(int i = 0; i < n; i++) {
    		for(int j=i; j<n; j++){
    			//print subarray between current starting and ending points
    			for(int k=i; k <= j; k++) {
    				System.out.println(arr[k] + "");
    			}
    		}
    	}
    }
    
 
    //MS OTS Variation: Return the maximum product subarray itself
    public static ArrayList<Integer> maxPro(int[] nums){
    	//int[] result = new int[nums.length];
    	ArrayList<Integer>result = new ArrayList<Integer>();
    	if(nums == null || nums.length == 0) return result;
    	
    	result.addAll(new ArrayList<Integer>());
    	
    	//imax/imin stores the max/min product of subarray that ends with the current number nums[i]
    	int imax = nums[0], imin = nums[0], res = nums[0];
    	
    	for(int i = 1; i < nums.length; i++) {
    		int temp = imax;
    		imax = Math.max(Math.max(imax * nums[i], imin * nums[i]), nums[i]);
    		imin = Math.min(Math.min(temp * nums[i], imin * nums[i]), nums[i]);
    		
    		if(imax > res) {
    			res = imax;
    			result.add(i);
    			//result[i] = nums[i]; // double check here
    		}
    		/*for(int j = 0; j < result.size(); j++){
        		System.out.println(result[j]);
        	}*/
    	}
    	
    	
    	return result;
    	
    }
    
   
    
    public static void main (String[] args) {
    	 
        int arr[] = {1, -2, -3, 0, 7, -8, -2};
       
        //System.out.println("Maximum Sub array product is "+ maxProduct(arr));
        System.out.println("Maximum Sub array product is "+ maxPro1(arr));
        System.out.println("All Non-empty Subarrays");
        subArray(arr.length);
       
    }

}
