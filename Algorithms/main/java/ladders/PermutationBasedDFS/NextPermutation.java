package main.java.ladders.PermutationBasedDFS;
/**
 * 52. Next Permutation - Medium - Optional

Given a list of integers, which denote a permutation.

Find the next permutation in ascending order.

 Notice
The list may contains duplicate integers.

Have you met this question in a real interview? 
Example
For [1,3,2,3], the next permutation is [1,3,3,2]

For [4,3,2,1], the next permutation is [1,2,3,4]

Tags: Permutation LintCode Copyright

Related Problems 
Medium Permutation Sequence 28 %
Medium Previous Permutation 27 %
Medium Permutations II 26 %
 * 
 * */
public class NextPermutation {
	 /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
   public int[] nextPermutation(int[] nums) {
		if(nums==null||nums.length<2){
            return nums;
        }
        for(int i= nums.length-2; i>-1;i-- ){
            //num i is partition nums
            if(nums[i]<nums[i+1]){
                //num j is changing num
                for(int j= nums.length-1; j>i;j--){
                    if(nums[j]>nums[i]){
                        swap(nums, i, j);
                        break;
                    }
                }
                //reverse from the right partition
                reverse (i+1,nums.length-1, nums);
                return nums;
            }
        }
        //if no partition num found, like 4321, the num[] is the last permutatio so just reverse it to the first one
        reverse (0,nums.length-1, nums);
        return nums;
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
