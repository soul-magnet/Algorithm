package main.java.ladders.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 630. Knight Shortest Path II - Medium

Given a knight in a chess-board n * m (a binary matrix with 0 as empty and 1 as barrier). 
the knight initialize position is (0, 0) and he wants to reach position (n - 1, m - 1), 
Knight can only be from left to right. 
Find the shortest path to the destination position, return the length of the route. 
Return -1 if knight can not reached.

Clarification: If the knight is at (x, y), he can get to the following positions in one step:

(x + 1, y + 2)
(x - 1, y + 2)
(x + 2, y + 1)
(x - 2, y + 1)

Example
[[0,0,0,0],
 [0,0,0,0],
 [0,0,0,0]]

Return 3

[[0,0,0,0],
 [0,0,0,0],
 [0,1,0,0]]

Return -1
Tags:Amazon Dynamic Programming Breadth First Search

Related Problems 
Medium Knight Shortest Path 23 %
 * */
/*
 * Thoughts: Same with the Knight Shortest Path-I only difference is adding the source point as 0,0
 * and given the directions as 4 instead of 8 used to be
 * */
public class KnightShortestPath2 {
	/*
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
	public class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
   //BFS Solution
   public int shortestPath2(boolean[][] grid) {
       // write your code here
       
       if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
       
       int[] directionX = {1, -1, 2, -2};
       int[] directionY = {2, 2, 1, 1};
       
       int n = grid.length;
       int m = grid[0].length;
       
       Queue<Point> queue = new LinkedList<>();
       queue.offer(new Point(0, 0));
       
       int step  = 0;
       
       while(!queue.isEmpty()){
           int size = queue.size();
           for(int i = 0; i < size; i++){
               Point curr = queue.poll();
               if((curr.x == n-1) && (curr.y == m-1))
                   return step;
               for(int j = 0; j < 4; j++){
                   Point next = new Point(curr.x + directionX[j], curr.y + directionY[j]);
                    if(inBound(grid, next) && !grid[next.x][next.y]){
                       queue.offer(next);
                       grid[next.x][next.y] = true;
                   }
               }
           }
           step++;
       }
       return -1;
   }
   
    private boolean inBound(boolean[][] grid, Point pt){
       return pt.x >= 0 && pt.x < grid.length && pt.y >= 0 && pt.y < grid[0].length;
   }
    
    //DP Solution - To Do

}
