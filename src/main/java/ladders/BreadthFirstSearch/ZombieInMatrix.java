package main.java.ladders.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 598. Zombie in Matrix - Medium

Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).
Zombies can turn the nearest people(up/down/left/right) into zombies every day, 
but can not through wall. How long will it take to turn all people into zombies? 
Return -1 if can not turn all people into zombies.

Example
Given a matrix:

0 1 2 0 0
1 0 0 2 1
0 1 0 0 0
return 2

Tags: Breadth First Search

Related Problems 
Hard Build Post Office II 27 %
 * */

public class ZombieInMatrix {
    class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

    
    /*
     * @param grid: a 2D integer grid
     * @return: an integer
     */
     //@author:Emine.Topkaya
     public int zombie(int[][] grid){
         if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
            
        int people = 0;
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0)
                    people++;
                if(grid[i][j] == 1)
                    queue.offer(new Point(i, j));
            }
        }
        
        if(people == 0)
            return 0;
            
        int[] directionX = new int[] {-1, 1, 0, 0};
        int[] directionY = new int[] {0, 0, -1, 1};
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                 Point currPt = queue.poll();
                 for(int j = 0; j < 4; j++){
                     Point nextPt = new Point(currPt.x + directionX[j], currPt.y + directionY[j]);
                     
                     if(isValid(grid, nextPt) && grid[nextPt.x][nextPt.y] == 0){
                         grid[nextPt.x][nextPt.y] = 1;
                         people--;
                         queue.offer(nextPt);
                     }
                 }
            }
            step++;
            if(people == 0)
                return step;
        }
        
        return -1;
        
     }
     
     public boolean isValid(int[][] grid, Point pt){
         return pt.x >= 0 && pt.x < grid.length
            && pt.y >= 0 && pt.y < grid[0].length
            && grid[pt.x][pt.y] != 2;
     }
     
     
    //@author:Tiannan.Wang
    public int PEOPLE = 0;
    public int ZOMBIE = 1;
    public int WALL = 2;

    public int[] deltaX = {1, 0, 0, -1};
    public int[] deltaY = {0, 1, -1, 0};
    public int zombie1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        // initialize the queue & count people
        int people = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == PEOPLE) {
                    people++;
                } else if (grid[i][j] == ZOMBIE) {
                    queue.offer(new Coordinate(i, j));
                }
            }
        }

        // corner case
        if (people == 0) {
            return 0;
        }

        // bfs
        int days = 0;
        while (!queue.isEmpty()) {
            days++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate zb = queue.poll();
                for (int direction = 0; direction < 4; direction++) {
                    Coordinate adj = new Coordinate(
                            zb.x + deltaX[direction],
                            zb.y + deltaY[direction]
                    );

                    if (!isPeople(adj, grid)) {
                        continue;
                    }

                    grid[adj.x][adj.y] = ZOMBIE;
                    people--;
                    if (people == 0) {
                        return days;
                    }
                    queue.offer(adj);
                }
            }
        }

        return -1;
    }

    private boolean isPeople(Coordinate coor, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (coor.x < 0 || coor.x >= n) {
            return false;
        }
        if (coor.y < 0 || coor.y >= m) {
            return false;
        }
        return (grid[coor.x][coor.y] == PEOPLE);
    }
}