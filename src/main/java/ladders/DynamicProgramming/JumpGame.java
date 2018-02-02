package DynamicProgramming;
/*
 * Given an array of non-negative integers, you are initially positioned 
 * at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * Example
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * Note: This problem have two method which is Greedy and Dynamic Programming.
 * The time complexity of Greedy method is O(n).
 * The time complexity of Dynamic Programming method is O(n^2).
 * We manually set the small data set to allow you pass the test 
 * in both ways. This is just to let you learn how to use this problem in 
 * dynamic programming ways. If you finish it in dynamic programming ways, 
 * you can try greedy method to make it accept again.
 * 
 * */
public class JumpGame {
	/**
     * @param A: A list of integers
     * @return: The boolean answer
     */
     // DP Approach
    public boolean canJump(int[] A) {
    	boolean[] can = new boolean[A.length];
    	can[0] = true;
    	
    	for (int i = 1; i < A.length; i++){
    		for (int j = 0; j < i; j++){
    			if (can[j] && j + A[j] >= i){
    				can[i] = true;
    				break;
    			}
    		}
    	}
    	return can[A.length - 1];
    }
    
    // Greedy
    public boolean canJump1(int[] A){
    	if (A == null || A.length == 0)
    		return false;
    	int farthest = A[0];
    	for (int i = 1; i < A.length; i++){
    		if(i <= farthest && A[i] + 1 >= farthest){
    			farthest = A[i] + 1;
    		}
    	}
    	return farthest >= A.length - 1;
    }
}
