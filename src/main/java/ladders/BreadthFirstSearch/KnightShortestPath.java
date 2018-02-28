package main.java.ladders.BreadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a knight in a chess board (a binary matrix with 0 as empty and 1 as barrier) with a source position, 
 * find the shortest path to a destination position, return the length of the route. 
 * Return -1 if knight can not reached.

 Notice: source and destination must be empty.
		 Knight can not enter the barrier.


Clarification
If the knight is at (x, y), he can get to the following positions in one step:

(x + 1, y + 2)
(x + 1, y - 2)
(x - 1, y + 2)
(x - 1, y - 2)
(x + 2, y + 1)
(x + 2, y - 1)
(x - 2, y + 1)
(x - 2, y - 1)
Example
[[0,0,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 2

[[0,1,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 6

[[0,1,0],
 [0,0,1],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return -1

Tags 
Breadth First Search

*/

/**
 * Definition for a point.
 * public class Point {
 *     public int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */

//Thoughts: Easy to Understand
// classic BFS traversal

public class KnightShortestPath {
	 
	class Point{
		public int x, y;
		public Point() {x = 0; y = 0;}
		public Point(int a, int b) {x = a; y = b;}
		
	}
	
	/**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path
     */
	public int shortestPath(boolean[][] grid, Point source, Point destination) {
	  	  if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
	  	  
	  	  //shortest path - now BFS
	  	  Queue<Point> queue = new LinkedList<>();
	  	  queue.offer(source);
	  	  
	  	    int[] directionX = new int[] {1, 1, -1, -1, 2, 2, -2, -2};
	        int[] directionY = new int[] {2, -2, 2, -2, 1, -1, 1, -1};
	        int step = 0;
	        
	        while(!queue.isEmpty()) {
	      	  int size = queue.size();
	      	  for(int i = 0; i < size; i++) {
	      		  Point curr = queue.poll();
	      		  if(curr.x == destination.x && curr.y == destination.y)
	      			  return step;
	      		  for(int j = 0; j < 8; j++) {
	      			  Point next = new Point(curr.x + directionX[j], curr.y + directionY[j]);
	      			  if(inBound(grid, next) && !grid[next.x][next.y]) {
	      				  queue.offer(next);
	      				  grid[next.x][next.y] = true;
	      			  }
	      		  }
	      	  }
	      	  step++;
	        }//end of while
	  	  return -1;
	  	}
	    
	    private boolean inBound(boolean[][]grid, Point pt) {
	  	  return pt.x >= 0 && pt.x < grid.length &&
	  			  pt.y >= 0 && pt.y < grid[0].length;
	    }
	
	 //this version isn't working for OJ - will work on this 
      public int shortestPath1(boolean[][] grid, Point source, Point destination) {
        int[][] directions = new int[][]{{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        
        Queue<Point> queue = new LinkedList<>();
        HashSet<Point> visited = new HashSet<>();
        queue.offer(source);
        
        while(!queue.isEmpty()){
           for(int i = 0; i < queue.size(); i++){
              Point currentPoint = queue.poll();
               visited.add(currentPoint);
               int x = currentPoint.x / queue.size();
               int y = currentPoint.y % queue.size();
               
               if(x == destination.x && y == destination.y) return result;
               
              /* Point nextPoint = new Point(
                       point.x + deltaX[direction],
                       point.y + deltaY[direction]
               );*/
               
               Point nextPoint = new Point();
               
               for(int[] dir : directions){
                   nextPoint.x = x + dir[0];
                   nextPoint.y = y + dir[1];
                   if( nextPoint.x < 0 ||  nextPoint.x >= m || nextPoint.y < 0 || nextPoint.y >= n || 
                		   visited.contains( nextPoint.x * queue.size() + nextPoint.y) || grid[ nextPoint.x][nextPoint.y] != true)
                	   continue;
                   queue.offer( nextPoint);
               }
               
           }
           result++;
            
        }
        return result;
    }    
}