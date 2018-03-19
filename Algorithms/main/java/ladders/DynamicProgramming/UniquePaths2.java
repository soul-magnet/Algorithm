package main.java.ladders.DynamicProgramming;
/**
 * 115. Unique Paths II - Easy - Required

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 Notice
m and n will be at most 100.

Have you met this question in a real interview? 
Example
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Tags: Array Dynamic Programming

Related Problems 
Hard Open the Lock 78 %
Hard Unique Paths III 21 %
 * */
public class UniquePaths2 {
	/**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if (obstacleGrid == null || obstacleGrid.length == 0)
    		return 0;
    	int n = obstacleGrid.length;
    	int m = obstacleGrid[0].length;
    	int[][] paths = new int[n][m];
    	
    	for (int i = 0; i < n; i++){
    		if (obstacleGrid[i][0] != 1){
    			paths[i][0] = 1;
    		} else {
    			break;
    		}
    	}
    	
    	for (int i = 0; i < m; i++){
    		if(obstacleGrid[0][i] != 1){
    			paths[0][i] = 1;
    		}else {
    			break;
    		}
    	}
    	
    	for (int i =1; i < n; i++){
    		for (int j = 1; j < m; j++){
    			if(obstacleGrid[i][j] != 1){
    				paths[i][j] = paths[i-1][j] + paths[i][j-1];
    			} else {
    				paths[i][j] = 0;
    			}
    		}
    	}
    	
    	return paths[n-1][m-1];
    }
}
