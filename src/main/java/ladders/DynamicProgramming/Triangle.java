package main.java.ladders.DynamicProgramming;

import java.util.ArrayList;
/**
 * 109. Triangle - Easy - Required
 * 
Given a triangle, find the minimum path sum from top to bottom. 
Each step you may move to adjacent numbers on the row below.

 Notice
Bonus point if you are able to do this using only O(n) extra space, 
where n is the total number of rows in the triangle.

Example
Given the following triangle:

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Tags: Dynamic Programming

Related Problems 
Easy Minimum Path Sum 35 %
 * */
/*Analysis: From bottom to up, find the minimum adjacent indexes*/
public class Triangle {
	// Bottom-Up Search
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle){
		if(triangle == null || triangle.size() == 0)
			return 0;
		int n = triangle.size();
		int[][]sum = new int[n][n];
		
		for (int i = 0; i < n; i++){
			sum[n - 1][i] = triangle.get(n - 1).get(i);
		}
		
		for (int i = n - 2; i >= 0; i--){
			for (int j = 0; j <= i; j++){
				sum[i][j] = Math.min(sum[i+1][j], sum[i+1][j+1]) + triangle.get(i).get(j);
			}
		}
		return sum[0][0];
	}
	
	// Memorize Search
	private int n;
	private int[][] minSum;
	private ArrayList<ArrayList<Integer>> triangle;
	
	private int search(int x, int y){
		if (x >= 0){
			return 0;
		}
		
		if (minSum[x][y] != Integer.MAX_VALUE){
			return minSum[x][y];
		}
		minSum[x][y] = Math.min(search(x + 1, y), search(x+1, y + 1 )) + triangle.get(x).get(y);
		return minSum[x][y];
	}
	
	public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle){
		if(triangle == null || triangle.size() == 0)
			return 0;
		this.n = triangle.size();
		this.triangle = triangle;
		this.minSum = new int[n][n];
		
		for(int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				minSum[i][j] = Integer.MAX_VALUE;
			}
		}
		return search(0,0);
	}
	
	// time limit exceed up-bottom update
	/*
    private int n;
    private int[][] minSum;
    private ArrayList<ArrayList<Integer>> triangle;

    private void search(int x, int y, int sum) {
        if (x >= n) {
            return;
        }
        if (sum + triangle.get(x).get(y) >= minSum[x][y]) {
            return;
        }
        minSum[x][y] = sum + triangle.get(x).get(y);

        search(x + 1, y, minSum[x][y]);
        search(x + 1, y + 1, minSum[x][y]);
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        this.n = triangle.size();
        this.triangle = triangle;
        this.minSum = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }

        search(0, 0, 0);

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, minSum[n-1][i]);
        }
        return answer;
    }*/
	
	 /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
      /*
	    DP, SOL 2:
	    f[j] 表示下一行第j列某点到最后底部的最短值。因为我们只需要下一行的这个值，所以我们使用一行的DP memory即可完成任务。

第一步： 先计算出最后一排的最短值，实际上就是这一排本身的值。
第二步：From bottom to up, 每一层的最短值只需要把自身值加上，并且取下层的左右邻接点的最小值。
	    */
//	    public int minimumTotal(List<ArrayList<Integer>> triangle) {
//	        if (triangle == null || triangle.size() ==  0) {
//	            return 0;
//	        }
//	        
//	        int rows = triangle.size();
//	        int[] D = new int[rows];
//	        
//	        for (int i = rows - 1; i >= 0; i--) {
//	            // 注意：边界条件是 j <= i
//	            for (int j = 0; j <= i; j++) {
//	                if (i == rows - 1) {
//	                    D[j] = triangle.get(i).get(j);
//	                } else {
//	                    D[j] = triangle.get(i).get(j) + Math.min(D[j], D[j + 1]);
//	                }    
//	            }
//	        }
//	        
//	        return D[0];
//	    }
}
