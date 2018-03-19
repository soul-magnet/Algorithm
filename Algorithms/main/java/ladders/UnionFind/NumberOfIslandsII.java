package main.java.ladders.UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 434. Number of Islands II 

Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). 
Originally, the 2D matrix is all 0 which means there is only sea in the matrix. 
The list pair has k operator and each operator has two integer A[i].x, A[i].y means that 
you can change the grid matrix[A[i].x][A[i].y] from sea to island. 
Return how many island are there in the matrix after each operator.

 Notice
0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, 
we consider them in the same island. We only consider up/down/left/right adjacent.

Example
Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].

return [1,1,2,2].

Tags: Google Union Find

Related Problems 
Medium Number of Big Islands 21 %
Hard Minimum Spanning Tree 26 %
Medium Surrounded Regions 23 %
Easy Number of Islands 25 %
 * */

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
	
}

// SOLID
public class NumberOfIslandsII {
	public List<Integer> numIslands2(int n, int m, Point[] operators) {
		//Write your code here
		
		List<Integer>result = new ArrayList<>();
		if(operators == null || operators.length == 0) return result;
		
		int[] id = new int[n*m];
		Arrays.fill(id, -1);
		int size = 0; //numOfComponents
		
		int[] directionX = {-1, 1, 0, 0};
		int[] directionY = {0, 0, -1, 1};
		
		for(Point pt : operators) {
			int p = pt.x * m + pt.y;
			if(id[p] != -1) {
				result.add(size);
				continue;
			}
			id[p] = p;
			size++;
			
			for(int i = 0; i < 4; i++) {
				Point neighbor = new Point(pt.x + directionX[i], pt.y + directionY[i]);
				if(neighbor.x < 0 || neighbor.x >= n || neighbor.y <0 || neighbor.y >= m) continue;
				int q = neighbor.x * m + neighbor.y;
				if(id[q] == -1) continue;
				if(find(id, p) != find(id, q)) {
					id[find(id, p)] = find(id, q);
					size--;
				}
			}
			result.add(size);
		}
		
		return result;
	}
	
	public int find(int[] id, int i) {
		while(i != id[i]) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	

}
