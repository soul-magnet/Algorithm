package Ladder1.FollowupCodingInt;

/** Optional
 * Find the kth smallest numbers in an unsorted integer array.


Example: Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers are [1, 2, 3].

Challenge 
An O(nlogn) algorithm is acceptable, if you can do it in O(n), that would be great.

Tags: Quick Sort

Related Problems 
1 - Medium Kth Largest Element
 * 
 * */
//Solution from Juizhang
public class KthSmallestNumbersinUnsortedArray {
	/*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSelect(int[] A, int start, int end , int k) {

        if (start == end)
            return A[start];
        
        int left = start, right = end;
        int pivot = A[(start + end) / 2];

        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }

            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                
                left++;
                right--;
            }
        }

        if (right >= k && start <= right)
            return quickSelect(A, start, right, k);
        else if (left <= k && left <= end)
            return quickSelect(A, left, end, k);
        else
            return A[k];
    }
}
