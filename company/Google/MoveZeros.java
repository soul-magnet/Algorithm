package Google;
/**
 * 
 * 539. Move Zeroes - Google Onsite

Given an array nums, write a function to move all 0's to the end of it 
while maintaining the relative order of the non-zero elements.

 Notice
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

Example
Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Tags: Array Two Pointers

Related Problems 
Easy Remove Element 30 %
http://www.jiuzhang.com/qa/7376/
 * */
public class MoveZeros {
	/**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
       int i=0,j=0,len=nums.length;
        while(i<len){
            if(nums[i]!=0){
                nums[j]=nums[i];
                        j++;
            }
            i++;
        }
        while(j<len){
            if(nums[j]!=0){
                nums[j]=0;
               
            }
            j++;
        }
    }
    
    //Juzihang Solution
    public void moveZeroes1(int[] nums) {
        // Write your code here
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

}
