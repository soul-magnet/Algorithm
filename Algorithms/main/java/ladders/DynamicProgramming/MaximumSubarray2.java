package main.java.ladders.DynamicProgramming;
/**
 * 42. Maximum Subarray II - Medium - Related

Given an array of integers, find two non-overlapping subarrays which have the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.

 Notice
The subarray should contain at least one number

Have you met this question in a real interview? 
Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], 
they both have the largest sum 7.

Challenge 
Can you do it in time complexity O(n) ?

Tags: Greedy Enumeration Array LintCode Copyright Subarray Forward-Backward Traversal

Hard Maximum Subarray V 29 %
Medium Maximum Subarray IV 35 %
Medium Maximum Product Subarray 30 %
Medium Best Time to Buy and Sell Stock III 27 %
Hard Maximum Subarray III 25 %
 * */
public class MaximumSubarray2 {
	/**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
     public int maxTwoSubArrays1(ArrayList<Integer> nums) {
         if(nums==null||nums.size()==0){
            return 0;
        }
        int len= nums.size();
        int [] l= new int[len];l[0]=nums.get(0);
        int [] r= new int[len];r[len-1]=nums.get(len-1);
       
        for(int i=1; i< len; i++){
            l[i]= Math.max(l[i-1]+nums.get(i),nums.get(i) );
        }
        for(int i=1; i< len; i++){
            l[i]= Math.max(l[i-1],l[i]);
        }
        for(int i=len-2; i> -1; i--){
            r[i]= Math.max(r[i+1]+nums.get(i), nums.get(i));
        }
        for(int i=len-2; i< -1; i--){
            r[i]= Math.max(r[i],r[i+1]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len - 1; i++){
            max = Math.max(max, l[i] + r[i + 1]);
        }
        return max;
    }
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        
        //2 non overlapping sub max : 
        //l[i] max for 1->i, r[i+1] of len-1->i+1
        //max(max, l[i]+r[i+1])
        
        int size = nums.size();
        int l[] = new int [size];
        int r[] = new int [size];
        int max = Integer.MIN_VALUE;
        int minsum=0;
        int sum=0;
        for (int i=0; i<size;i++){
            sum+= nums.get(i);
           
            max= Math.max(max,sum-minsum); minsum= Math.min(minsum, sum);
            l[i]= max;
        }
        max = Integer.MIN_VALUE;
        minsum=0;
        sum=0;
        for (int i=size-1; i>-1;i--){
            sum+= nums.get(i);
           
            max= Math.max(max,sum-minsum); minsum= Math.min(minsum, sum);
            r[i]= max;
        }
        max = Integer.MIN_VALUE;
        for (int i =0; i < size-1; i++){
            max= Math.max(max,l[i]+r[i+1]);
        }
        return max;
    }

}
