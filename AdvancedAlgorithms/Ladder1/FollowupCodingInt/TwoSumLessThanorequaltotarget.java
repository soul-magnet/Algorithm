package Ladder1.FollowupCodingInt;

/** Optional
 * Given an array of integers, find how many pairs in the array such that their sum is less than or 
 * equal to a specific target number. Please return the number of pairs.

Example: Given nums = [2, 7, 11, 15], target = 24. 
Return 5. 
2 + 7 < 24
2 + 11 < 24
2 + 15 < 24
7 + 11 < 24
7 + 15 < 25

Tags: Sort Two Pointers

Related Problems 
1 - Medium Two Sum - BST edtion 27 %
2 - Medium Two Sum - Input array is sorted 47 %
3 - Medium Two Sum - Difference equals to target 26 %
4 - Easy Two Sum - Data structure design 35 %
5 - Medium Two Sum - Unique pairs 34 %
6 - Medium Two Sum - Closest to target 43 %
7 - Medium Two Sum - Greater than target 38 %
8 - Easy Two Sum
 * 
 * */

public class TwoSumLessThanorequaltotarget {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
           if(nums==null||nums.length<2) return 0;
        Arrays.sort(nums);
        int l =0, r= nums.length-1,ct=0;
        while(l<r){
            if(nums[l]+nums[r]>target){
                r--;
            }else{
                ct += r -l;
                //System.out.println(ct+""+nums[l]+""+nums[r]);
                l++;
            }
        }
        return ct;
    }
}
