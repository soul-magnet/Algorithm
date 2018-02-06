package main.java.ladders.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 573. Build Post Office II - Hard - Required

Given a 2D grid, each cell is either a wall 2, an house 1 or empty 0 (the number zero, one, two), 
find a place to build a post office so that the sum of the distance from the post office 
to all the houses is smallest.

Return the smallest sum of distance. Return -1 if it is not possible.

 Notice
You cannot pass through wall and house, but can pass through empty.
You only build post office on an empty.

Example
Given a grid:

0 1 0 0 0
1 0 0 2 1
0 1 0 0 0
return 8, You can build at (1,1). (Placing a post office at (1,1), 
the distance that post office to all the house sum is smallest.)

Challenge 
Solve this problem within O(n^3) time.

Tags: Google Breadth First Search Zenefits

Related Problems 
Medium Nearest Exit 31 %
Medium Zombie in Matrix 29 %
Hard Build Post Office 19 %
 * 
 * */

/*
 * Thoughts:
 * 1. Scan the array to find all the houses
 * 2. Create a distance matrix for each house of calculate the distance from the houses to all '0' points
 * that is, distance[i][j][k] is the distance between k house and grid[i][j].BFS search distance calculation.
 * 3. Traversing all the points on the map to 0, searching k distance matrices,
 * and adding up the distance from from all the houses to this point is the sum of the distance at the post office.
 * If the query encountered some point in a distance matrix value is infinite, then the point cannot reach the house, 
 * you can stop searching
 * 4. Select the smallest distance in the middle of the point 3 can be.  
 * 
 * */
class Node {
	int x;
	int y;
	int dis;
	public Node(int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}
public class BuildPostOffice2 {
	
	/**
     * @param grid a 2D grid
     * @return an integer
     */
	
	public int shortestDistance(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
		
		int n = grid.length; //x axis
		int m = grid[0].length; // y axis
		ArrayList<Node> house = new ArrayList<Node>();
		
		//find hourses
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < m; j++) {
				if(grid[i][j] == 1) {
					house.add(new Node(i, j, 0));
				}
			}
		}
		//check if there is not empty space to build the house
		int k = house.size();
		if(k == n * m) return -1;
		
		
		//searching k distance matrices
		int[][][] distance = new int[k][n][m];
		for(int i = 0;  i < k; i++) {
			for(int j = 0 ; j < n; j++) {
				Arrays.fill(distance[i][j], Integer.MAX_VALUE);
			}
		}
		
		for(int i = 0 ; i < k; i++) {
			getDistance(house.get(i), distance, i, grid);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m ; j++) {
				if(grid[i][j] == 0) {
					int sum = 0;
					for(int l = 0; l < k; l++) {
						if(distance[l][i][j] == Integer.MAX_VALUE) {
							sum = Integer.MAX_VALUE;
							break;
						}
						sum += distance[l][i][j];
					}
					
					min = Math.min(min, sum);
				}
				
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			return -1;
		}
		
		return min;
	}
	
	//BFS Search for Shortest Path
	int[] dx = {-1, 1, 0, 0}; //not clear
	int[] dy = {0, 0, -1, 1};
	private void getDistance(Node currHouse, int[][][] distance, int k, int[][]grid) {
		int n = grid.length;
		int m = grid[0].length;
		
		Queue<Node> queue = new LinkedList<Node>();
		boolean[][] visited = new boolean[n][m];
		queue.offer(currHouse);
		visited[currHouse.x][currHouse.y] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			for(int i = 0 ; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				if(nextX >= 0 && nextX < n && nextY >= 0 &&
					nextY < m && grid[nextX][nextY] == 0 && 
					!visited[nextX][nextY]) {
						distance[k][nextX][nextY] = now.dis + 1;
						queue.add(new Node(nextX, nextY, now.dis + 1)); // not clear
						visited[nextX][nextY] = true;
					}
				}
		}
	}

}
