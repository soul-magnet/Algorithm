package main.java.ladders.DynamicProgramming;
/**
 * 534. House Robber II - Medium

After robbing those houses on that street, the thief has found himself a new place for his thievery so 
that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

 Notice
This is an extension of House Robber.

Example
nums = [3,6,4], return 6

Tags: Dynamic Programming Microsoft
Related Problems 
Medium House Robber III 31 %
Medium Paint House 35 %
Easy Paint Fence 30 %
Medium House Robber 34 %
 * */
public class HouseRobber2 {
	/**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
	public int rob(int[] nums){
		int result = 0;
		for (int i = 0; i < nums.length; i++){// starting house
			int pHouse2 = 0; // house at position -2
			int pHouse1 = nums[i]; // house at position -1
			int house = pHouse1; // current house;
			for (int j = 2; j < nums.length; j++){ //second house - > second to last house, as last house is not rob-able
				house = Math.max(pHouse2 + nums[(i + j - 1) % nums.length], pHouse1);
				pHouse2 = pHouse1;
				pHouse1 = house;
				
			}
			result = Math.max(result, house);
		}
		return result;
	}
	// ANother solution
	public long houseRobber2(int[] A) {
        // write your code here
        int n = A.length;
        long []res = new long[3];
        long ans = 0;
        if(n==0)
            return 0;
        if(n >= 1) {
            res[0] = A[0];
            ans = Math.max(ans, res[0]);
        }
        if(n >= 2) {
            res[1] = Math.max(A[0], A[1]);
            ans = Math.max(ans, res[1]);
        }
        if(n >= 3) {
            res[2] = Math.max(A[0]+A[2], A[1]);
            ans = Math.max(ans, res[2]);
        }
        if(n > 2){
            for(int i = 3; i < n; i++) {
                res[i%3] = Math.max(res[(i-3)%3], res[(i-2)%3])+ A[i];
                ans = Math.max(ans, res[i%3]);
            }
        } 
        return ans;
    }   
	
//	public int houseRobber2(int[] a) {
//        if(a.length==0||a==null){
//            return 0;
//        }
//        if(a.length==1){
//            return a[0];
//        }else if(a.length==2){
//            return Math.max(a[1], a[0]);
//        }
//       return Math.max(rob(a,0,a.length-2),rob(a,1,a.length-1) );
//    }
//
//    private int rob(int[] a, int l, int r) {
//        if(l==r){
//            return a[l];
//        }else if(r-l==1){
//            return Math.max(a[l], a[r]);
//        }
//        int dp[] = new int [2];
//       dp[l%2]= a[l];
//        dp[(l+1)%2] = Math.max(a[l], a[l+1]);
//      
//        for(int i=l+2;i<=r;i++){
//            dp[i%2]=Math.max(dp[(i-1)%2], dp[(i-2)%2]+a[i]);
//        }
//        return dp[r%2];
//    }

}
