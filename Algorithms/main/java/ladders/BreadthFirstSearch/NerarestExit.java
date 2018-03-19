package main.java.ladders.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 663. Nearest Exit - Medium - Google Onsite

You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. 
We use the value 2^31 - 1 = 2147483647 to represent INF 
as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. 
If it is impossible to reach a gate, it should be filled with INF.

Example
Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
return the result:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
  
Tags: Google Breadth First Search Facebook

Related Problems 
Hard Build Post Office 19 %
Hard Build Post Office II 27 %
Medium Surrounded Regions 23 %
Easy Number of Islands 25 %
 * 
 * http://www.jiuzhang.com/qa/7376/
 * */

class Point {
	int row;
	int col;
	Point(int r, int c){
		this.row = r;
		this.col = c;
	}
}
public class NerarestExit {
	 /*
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        // write your code here
    	if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
    	
    	int n = rooms.length;
    	int m = rooms[0].length;
    	int[] deltaX = {-1, 0, 1, 0};
    	int[] deltaY = {0, 1, 0, -1};
    	
    	Queue<Point> queue = new LinkedList<Point>();
    	
    	//identfy the gates in the maze
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(rooms[i][j] == 0) {
    				queue.add(new Point(i, j));
    			}
    		}
    	}
    	
    	//now BFS
    	while(!queue.isEmpty()) {
    		Point currPoint = queue.poll();
    		for(int dir = 0; dir < 4; dir++) {
    			int x = currPoint.row + deltaX[dir];
    			int y = currPoint.col + deltaY[dir];
    			
    			if(isInBound(rooms, x, y)) {
    				if(rooms[x][y] == Integer.MAX_VALUE) {
    					rooms[x][y] = rooms[currPoint.row][currPoint.col] + 1;
    					queue.add(new Point(x, y));
    				}
    			}
    		}
    	}
    }
    
    private boolean isInBound(int[][] rooms, int row, int col) {
		return (row >= 0 && row < rooms.length &&
				col >= 0 && col < rooms[0].length);
	}
    
    //2nd Solution: Juizhang Solution
    static final int INF = 2147483647;
    int n, m;
    public void wallsAndGates1(int[][] rooms) {
    	
    	n = rooms.length;
    	if(n == 0) return;
    	
    	m = rooms[0].length;
    	
    	int dx[] = {0, 1, 0, -1};
    	int dy[] = {1, 0, -1, 0};
    	
    	Queue<Integer> qx = new LinkedList<>();
    	Queue<Integer> qy = new LinkedList<>();
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(rooms[i][j] == 0) {
    				qx.offer(i);
    				qy.offer(j);
    			}
    		}
    	}
    	
    	while(!qx.isEmpty()) {
    		int cx = qx.poll();
    		int cy = qy.poll();
    		
    		for(int i =0; i <4; i++) {
    			int nx = cx + dx[i];
    			int ny = cy + dy[i];
    			if (0 <= nx && nx < n && 0 <= ny && ny < m
                        && rooms[nx][ny] == INF) {
                    qx.offer(nx);
                    qy.offer(ny);
                    rooms[nx][ny] = rooms[cx][cy] + 1;
                }
    		}
    	}
    }
    

}



