package Greedy;
/*
 * Given a list of integers, which denote a permutation.
 * Find the next permutation in ascending order.
 * The replacement must be in-place, do not allocate extra memory
 * 
 * Example
 * For [1,3,2,3], the next permutation is [1,3,3,2]
 * For [4,3,2,1], the next permutation is [1,2,3,4]
 * Note:
 * The list may contains duplicate integers.
 * Analysis: 
 * 
 * 1. Find the first decreasing digit toBeReplaced from least to most 
 * significant digit, to minimize the change(31321 => 31321)
 * 2. Find the least larger number toReplace than nums[toBeReplaced] so as to minimize the change(31321 => 31321)
 * 3. swap toBeReplaced and toReplace (31321 => 32311)
 * 4. reverse the remaining digits to get the minimum permutation
 * (32311 => 32113)
 * 
 * From the wikipedia, one classic algorithm to generate next permutation is:
Step 1: Find the largest index k, such that A[k]<A[k+1]. If not exist, this is the last permutation. (in this    problem just sort the vector and return.)
Step 2: Find the largest index l, such that A[l]>A[k].
Step 3: Swap A[k] and A[l].
Step 4: Reverse A[k+1] to the end.
 * */
public class NextPermutation {
	 /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
	// version 1
	public int[] nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        //1. go from least to most significant digit to minimize the change
        int toBeReplaced = nums.length - 2;
        while (toBeReplaced >= 0 && nums[toBeReplaced] >= nums[toBeReplaced + 1]) {
            toBeReplaced--;
        }
        if (toBeReplaced >= 0) {
            int toReplace = toBeReplaced + 1; //2. find the least larger number so as to minimize the change 
            while (toReplace < nums.length && nums[toReplace] > nums[toBeReplaced]) {
                toReplace++;
            }
            toReplace--;
            //3. swap toBeReplaced and toReplace
            swap(nums, toReplace, toBeReplaced);
        }
        //4. reverse the remaining digits to get the minimum permutation
        reverse(nums, toBeReplaced + 1, nums.length - 1);
        return nums;
    }
    
    void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
 
    void reverse(int[] num, int beg, int end) {
        for (int i = beg, j = end; i < j; i++, j--) {
            swap(num, i, j);
        }
    }
    
    //version 2
    
    /*public void reverse(int[] num, int start, int end){
    	for (int i = start,j = end; i < j; i++, j--){
    		int temp = num[i];
    		num[i] = num[j];
    		num[j] = temp;
    	}
    }
    
    public void nextPermutation(int[] num){
    	// find the last increase index
    	int index = -1;
    	for (int i = num.length - 2; i >= 0; i--) {
    		if (num[i] < num[i + 1]) {
    			index = i;
    			break;
    		}
    	}
    	
    	if (index == -1) {
    		reverse (num, 0, num.length - 1);
    		return;
    	}
    	
    	// find the first bigger one
    	int biggerIndex = index + 1;
    	for (int i = num.length - 1; i > index; i--){
    		if (num[i] > num[index]){
    			biggerIndex = i;
    			break;
    		}
    	}
    	
    	// swap them to make the permutation bigger
    	int temp = num[index];
    	num[index] = num[biggerIndex];
    	num[biggerIndex] = temp;
    	
    	// reverse the last part
    	reverse(num,index + 1, num.length - 1);
    }*/
    
    
}
