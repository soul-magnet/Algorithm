package Ladder4.BinarySearch_SweepLine;
/**
 * 
 * 633. Find the Duplicate Number - Medium - Optional

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
find the duplicate one.

 Notice
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n^2).
There is only one duplicate number in the array, but it could be repeated more than once.

Example
Given nums = [5,5,4,3,2,1] return 5
Given nums = [5,4,4,3,2,1] return 4

Tags: Array Two Pointers Binary Search Bloomberg

Related Problems 
Medium Find the Missing Number II 22 %
Medium Find the Missing Number 33 %
Medium First Missing Positive 23 %
Hard Linked List Cycle II 37 %
Easy Single Number 46 %

*/

public class FindTheDuplicateNumber {
	 /*
     * @param nums: an array containing n + 1 integers which is between 1 and n
     * @return: the duplicate one
     */
    public int findDuplicate(int[] nums) {
        // write your code here
    }
}
//Juixhang Solution
//二分法
public class Solution {
 /**
  * @param nums an array containing n + 1 integers which is between 1 and n
  * @return the duplicate one
  */
 public int findDuplicate(int[] nums) {
     // Write your code here
     int start = 1;
     int end = nums.length - 1;
     while(start + 1 < end) {
         int mid = start + (end - start) / 2;
         if (check_smaller_num(mid, nums) <= mid) {
             start = mid;
         } else {
             end = mid;
         }
     }
         
     if (check_smaller_num(start, nums) <= start) {
         return end;
     }
     return start;
 }
 
 public int check_smaller_num(int mid, int[] nums) {
     int cnt = 0;
     for(int i = 0; i < nums.length; i++){
         if(nums[i] <= mid){
             cnt++;
         }
     }
     return cnt;
 }
}

//映射法
public class Solution {
 /**
  * @param nums an array containing n + 1 integers which is between 1 and n
  * @return the duplicate one
  */
 public int findDuplicate(int[] nums) {
     // Write your code here
     if (nums.length <= 1)
         return -1;

     int slow = nums[0];
 	int fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		fast = 0;
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
 }
}
