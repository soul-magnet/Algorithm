package Ladder7.FollowUp;

import java.util.HashMap;

/**
 * 405. Submatrix Sum - Medium - Required

Given an integer matrix, find a submatrix where the sum of numbers is zero. 
Your code should return the coordinate of the left-up and right-down number.

Example
Given matrix

[
  [1 ,5 ,7],
  [3 ,7 ,-8],
  [4 ,-8 ,9],
]
return [(1,1), (2,2)]

Challenge 
O(n3) time.

Tags: Enumeration Matrix

Related Problems 
Medium Subarray Sum Closest 21 %
Easy Subarray Sum 31 %
 * */
public class SubmatrixSum {
	
	/**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] m) {
		int res[][]= new int [2][2];
		int h= m.length, w= m[0].length;
		if(h==0||w==0){
			return res;
		}
		int [][] dp = new int [h+1][w+1];
		//init dp
		for(int i=0; i<=h;i++){
			dp[i][0]=0;
		}
		for(int j=0; j<=w;j++){
			dp[0][j]=0;
		}
		for(int i=0; i<h;i++){
			for(int j=0;j<w;j++){
				dp[i+1][j+1]=dp[i+1][j]+dp[i][j+1]+m[i][j]-dp[i][j];

			}
		}
		for(int i=0; i<h;i++){
			for(int i1=i+1; i1<=h;i1++){
				//fix hight range
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				for(int j=0;j<=w;j++){
				//fix width range
					int subMatrix = dp[i1][j]-dp[i][j];
					if (map.containsKey(subMatrix)){
						int l= map.get(subMatrix);
						res[0][0]=i;res[0][1]=l;
						res[1][0]=i1-1;res[1][1]=j-1;
					}
					else{
						map.put(subMatrix, j);
					}
				}
			}
		}
		return res;
	}

}
