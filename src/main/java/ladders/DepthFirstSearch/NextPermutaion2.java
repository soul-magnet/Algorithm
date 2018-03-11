package main.java.ladders.DepthFirstSearch;
/**
 * 190. Next Permutation II - Medium - Related

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order 
(ie, sorted in ascending order).

Example
Here are some examples. Inputs are in the left-hand column and its corresponding 
outputs are in the right-hand column.

1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

Challenge 
The replacement must be in-place, do not allocate extra memory.

Tags 
Array Permutation
Related Problems 
Medium Next Permutation II 34 %
Medium Permutation Index II 23 %
Easy Permutation Index 30 %
Medium Permutations II 26 %
 * 
 * */
public class NextPermutaion2 {
	/**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
		if(nums==null||nums.length<2){
            return;
        }
        int len= nums.length, l=0, r=len-1;
        while (l<r){
            int mid = l + r/2;
            if(nums[mid]<nums[mid+1]){
                //mid is the partition number
                int left=mid+1, right = len-1;
                while(left<right){
                    int m = left +right/2;
                     if(nums[m]> nums[mid]&&(m+1>right||nums[m+1]<=nums[mid])){
                        swap(nums,mid,m );
                        reverse(mid+1, len-1, nums);
                        return;
                    }
                    else if (nums[m]<= nums[mid+1]){
                        right= m;
                    }
                    else{
                        left=m;
                    }
                }
            }else if (nums[mid]>=nums[mid+1]){
                r=mid;
            }else{
                l=mid;
            }
        }
       
         reverse(0,len-1,nums);
	}

    private void reverse(int i, int j, int [] nums) {
        while (i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp= nums[i];
        nums[i]= nums[j];
        nums[j]=temp;
    }
}
