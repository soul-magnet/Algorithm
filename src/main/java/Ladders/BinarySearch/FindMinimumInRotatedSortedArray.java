package BinarySearch;
/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * Example: Given [4, 5, 6, 7, 0, 1, 2] return 0
 * Note: You may assume no duplicate exists in the array
 * 
 * Analysis: 
 * 
 * Binary Search, ad the key is how to break the array to
 * two parts so that we only need to work on half of the array each time.
 * i.e. when to select to left half or when to select right half
 * If we pick the middle element, we can compare the middle element
 * with the left-end element. If middle is less than leftmost, 
 * the left half should be selected;
 * if the middle is greater than the leftmost, the right half should be selected.
 * Using simple recursion, this problem can be solve in time log(n).
 * 
 * In addition, in any rotated sorted array, the rightmost element
 * should be less than the left-most element. otherwise, 
 * the sorted array is not rotated is not rotated and 
 * we can simply pick the left most element as the left most.
 * 
 * Another Approach; Squeezing window
 * The idea is to squeeze the window to get rid of all elements in the part 1. 
 * Once the left border enters part2, we will return.
 * 
 * Useful Articles: 
 * http://articles.leetcode.com/2010/04/searching-element-in-rotated-array.html
 * http://blog.welkinlan.com/2015/05/14/find-minimum-in-rotated-sorted-array-leetcode-java/
 * */
public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] num) {
		int start = 0, end = num.length - 1;
		while (start + 1 < end){
			int mid = start + (end - start) / 2;
			if (num[mid] >= num[end]){
				start = mid;
			} else {
				end = mid;
			}
		}
		if (num[start] < num[end]){
			return num[start];
		} else {
			return num[end];
		}
	}
	
}
