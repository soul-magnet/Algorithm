package main.java.ladders.GraphSearch;

import java.util.ArrayList;

/**
 * 51. Previous Permutation - Medium - Optional 

Given a list of integers, which denote a permutation.

Find the previous permutation in ascending order.

 Notice
The list may contains duplicate integers.

Have you met this question in a real interview? 
Example
For [1,3,2,3], the previous permutation is [1,2,3,3]

For [1,2,3,4], the previous permutation is [4,3,2,1]

Tags: Permutation LintCode Copyright

Related Problems 
Medium Permutation Sequence 28 %
Easy Permutation Index 30 %
Medium Next Permutation 25 %
 * 
 * */
public class PreviousPermutaiton {
	 /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        if (nums==null||nums.size()<2){
            return nums;
        }
        int len = nums.size();
       //find pivot right -> increase
        for(int i=len-2; i>-1;i--){
            if(nums.get(i)>nums.get(i+1)){
                //find change pint (just smaller than pivort) //swap
                for(int j=len-1;j>i;j--){
                    if(nums.get(j)<nums.get(i)){
                       swap(i, j, nums);
                        break;
                    }
                }
                //reverse right partition
                reverse(i+1,len-1,nums);
               return nums;

            }
        }
        reverse(0,len-1,nums);
        return nums;
    }

    private void reverse(int i, int j, ArrayList<Integer> nums) {
       
        while (i<j){
            swap(i,j,nums);
            i++;
            j--;
        }
    }
    private void swap(int i, int j, ArrayList<Integer> nums) {
        int temp = nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,temp);
    }

}
