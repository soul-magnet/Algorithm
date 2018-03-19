package main.java.ladders.DynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 611. Knight Shortest Path - Medium - Required

Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, 
find the shortest path to a destination position, return the length of the route. 
Return -1 if knight can not reached.

 Notice
source and destination must be empty.
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

Tags: Breadth First Search, DP
Related Problems 
Medium Portal 27 %
Medium Knight Shortest Path II 29 %
Medium Search Graph Nodes 45 %
 * */
/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class KnightShortestPath {
	/**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination){
        
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return -1;
            
        //shortest path - BFS     
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        
        int[] directionX = new int[] {1, 1, -1, -1, 2, 2, -2, -2};
        int[] directionY = new int[] {2, -2, 2, -2, 1, -1, 1, -1};
        int step = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                Point currPt = queue.poll();
                if(currPt.x == destination.x && currPt.y == destination.y)
                    return step;
                for(int j = 0; j < 8; j ++){
                    Point nextPt = new Point(currPt.x + directionX[j], currPt.y + directionY[j]);
                    if(inBound(grid, nextPt) && !grid[nextPt.x][nextPt.y]){
                        queue.offer(nextPt);
                        grid[nextPt.x][nextPt.y] = true;
                    }
                }
            }
            step++;
        } // end of while
        return -1;
    }
    
    private boolean inBound(boolean[][] grid, Point pt){
        return pt.x >= 0 && pt.x < grid.length && pt.y >= 0 && pt.y < grid[0].length;
    }
    
    //Version 2
     int n, m; // size of the chessboard
    int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
    int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};
    public int shortestPath1(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        n = grid.length;
        m = grid[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == destination.x && point.y == destination.y) {
                    return steps;
                }

                for (int direction = 0; direction < 8; direction++) {
                    Point nextPoint = new Point(
                            point.x + deltaX[direction],
                            point.y + deltaY[direction]
                    );

                    if (!inBound1(nextPoint, grid)) {
                        continue;
                    }

                    queue.offer(nextPoint);
                    // mark the point not accessible
                    grid[nextPoint.x][nextPoint.y] = true;
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean inBound1(Point point, boolean[][] grid) {
        if (point.x < 0 || point.x >= n) {
            return false;
        }
        if (point.y < 0 || point.y >= m) {
            return false;
        }
        return (grid[point.x][point.y] == false);
    }
    
    
    //this version isn't working for OJ - will work on this 
   /* public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
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
               
               int x = currentPoint.x /n ;
               int y = currentPoint.y % n;
               if(x == destination.x && y == destination.y)
                            return result;
              
               Point nextPoint = new Point();
               
               for(int[] dir : directions){
                   nextPoint.x = x + dir[0];
                   nextPoint.y = y + dir[1];
                   if( nextPoint.x < 0 ||  nextPoint.x >= m || nextPoint.y < 0 || nextPoint.y >= n || visited.contains( nextPoint.x * queue.size() + nextPoint.y) || grid[ nextPoint.x][nextPoint.y] != true)
                	   continue;
                   queue.offer( nextPoint);
               }
               
           }
           result++;
            
        }
        return result;
    }*/
    
     
}
