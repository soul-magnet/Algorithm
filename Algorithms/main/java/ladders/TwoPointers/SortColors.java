package Microsoft_OTS2018;
/**
 * 148. Sort Colors - LintCode - Medium
 * 75. Sort Colors - LeetCode - Medium
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.
You should do it in-place (sort numbers in the original array).

Example
Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

Related Topics: Array Two Pointers Sort

Similar Questions 
Sort List
Wiggle Sort
Wiggle Sort II
 * */

/*
 * Analysis: The first question can ue two pointer approach to construct swap function
 * shifting 0s to the left, 2s tot he right while skipping 1s
 * 
 * Another method is to construct color array. Then re assign the numbers.
 * */
public class SortColors {
	/**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
	
	public void sortColors2(int[] nums) {
        int[] ct = new int [2];
        for(int i: nums){
            ct[i]++;
        }
        for(int i= nums.length-1; i>-1; i--){
            if(ct[2]>0){
                nums[i]=ct[2];ct[2]--;
            }else if(ct[1]>0){
                nums[i]=ct[1];ct[1]--;
            }else{
                nums[i]=ct[0];ct[0]--;
            }
        }
    }
	//same approach
	/*public void sortColors1(int[] nums) {
		int[] count = new int[3];
		for(int num : nums) {
			count[num]++;
		}
		
		int pos = 0;
		for(int i = 0; i < 3; i++) {
			while(count[i] > 0) {
				nums[pos++] = i;
				count[i]--;
			}
		}
		return;
	}*/
	
	public void sortColors(int[] nums) {
		if(nums == null || nums.length <= ) return;
		
		int left = 0, right=nums.length, i = 0;
		while(i <= right) {
			if(nums[i] == 0) {
				swap(nums, i, left);
				left++;
				i++;
			}else if(nums[i] == 1) {
				i++;
			}else {
				swap(nums, i, right);
				right--;
			}
		}
	}
	
	//same apprach
	/*public void sortColors(int[] a) {
		if (a == null || a.length <= 1)
			return;
		int l = 0, r = a.length - 1, mid = 0;
		while (mid <= r) {
			if (a[mid] == 0) {
				swap(a, l, mid);
				l++;
				mid++;
			} else if (a[mid] == 1) {
				l++;
			} else {
				swap(a, r, mid);
				r--;
			}
		}
	}*/
	
	private void swap(int []nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
