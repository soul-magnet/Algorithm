package main.java.ladders.dataStructure;
/**
 * 544. Top k Largest Numbers - Medium - Required
 
Given an integer array, find the top k largest numbers in it.

Example
Given [3,10,1000,-99,4,100] and k = 3.
Return [1000, 100, 10].

Tags: Heap Priority Queue

Related Problems 
Medium High Five 32 %
Hard Top K Frequent Words II 19 %
Medium Top k Largest Numbers II 29 %
Medium Top K Frequent Words 19 %
 * */

class TopKLargestNumbers {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
		quickSort(nums, k, 0, nums.length - 1);
		int []res= new int [k];
		for ( int i= 0;i<k;i++){
			res[i]=nums[nums.length-1-i];
		}
		return res;
	}

	private void quickSort(int[] nums, int k, int l, int r) {
		// e:
		if (l >= r) {
			return;
		}
		int pivot = nums[l];
		int current = l;
		int next = l + 1;
		while (next <= r) {
			if (nums[next] <= pivot) {
				swap(nums, ++current, next);
			}
			++next;
		}
		swap(nums, l, current);
		quickSort(nums, k, current + 1, r);
		if( current-1>=nums.length-k)
		quickSort(nums, k, l, current - 1);

	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}
};


