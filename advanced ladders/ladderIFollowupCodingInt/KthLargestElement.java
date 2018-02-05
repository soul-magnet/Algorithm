package ladderIFollowupCodingInt;

/**
 * Find K-th largest element in an array.

 Notice: You can swap elements in the array


Example: In array [9,3,2,4,8], the 3rd largest element is 4.

In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

Challenge: O(n) time, O(1) extra memory.

Tags: Sort Quick Sort

Related Problems 
1 - Medium Kth Largest Element II 54 %
2 - Medium Wiggle Sort II 25 %
3 - Medium Kth Smallest Numbers in Unsorted Array 34 %
4 - Medium Kth Smallest Number in Sorted Matrix 24 %
5 - Easy Median
 * 
 * */

class KthLargestElement {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
     public int kthLargestElement(int k, int[] nums) {
    return quickSelect(nums.length-k, nums, 0, nums.length-1);
}

    private int quickSelect(int k, int[] nums, int l, int r) {
        if(l>=r){ return nums[l]; }
        int p = nums[l], l0=l, r0=r;
        while(l<r){
            while(l<r&&nums[r]>p){
                r--;
            }
            nums[l] = nums[r];
            while(l<r&&nums[l]<=p){
                l++;
            }
            nums[r] = nums[l];
        }// loop ends l==r, put pivot into array
        nums[l] = p;
        if(l==k){
            return  p ;
        }else if(k>l){
            return quickSelect(k, nums,l+1, r0);
        }else{
             return quickSelect(k,nums,l0,l-1);
        }
    }
};
