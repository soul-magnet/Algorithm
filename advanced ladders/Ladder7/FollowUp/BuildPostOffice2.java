package Ladder7.FollowUp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * 573. Build Post Office II - Hard - Optional

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

Tags:Google Breadth First Search Zenefits

Related Problems 
Medium Nearest Exit 31 %
Medium Zombie in Matrix 29 %
Hard Build Post Office 19 %
 * */

class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BuildPostOffice2 {
	//@autor:Emine.Topkaya
    public int shortestDistance(int[][] grid) {
    // Write your code here
    if(grid == null || grid.length == 0 || grid[0].length == 0){
        return -1;
    }

    int n = grid.length;
    int m = grid[0].length;
    ArrayList<Node> house = new ArrayList<Node>();
    //find house position
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(grid[i][j] == 1){
                house.add(new Node(i, j, 0));
            }
        }
    }
    //no empty place
    int k = house.size();
    if(k == n * m){
        return -1;
    }

    int[][][] distance = new int[k][n][m];
    for(int i = 0; i < k; i++){
        for(int j = 0; j < n; j++){
            Arrays.fill(distance[i][j], Integer.MAX_VALUE);
        }
    }

    for(int i = 0; i < k; i++){
        getDistance(house.get(i), distance, i, grid);
    }

    int min = Integer.MAX_VALUE;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(grid[i][j] == 0){
                int sum = 0;
                for(int l = 0; l < k; l++){
                    if(distance[l][i][j] == Integer.MAX_VALUE){
                        sum = Integer.MAX_VALUE;
                        break;
                    }
                    sum += distance[l][i][j];
                }
                min = Math.min(min, sum);
            }
        }
    }

    if(min == Integer.MAX_VALUE){
        return -1;
    }
    return min;
}

int[] dx = {-1, 1, 0, 0};
int[] dy = {0, 0, -1, 1};
//BFS search for shortest path
private void getDistance(Node curt, int[][][] distance, int k, int[][] grid){
    int n = grid.length;
    int m = grid[0].length;
    Queue<Node> queue = new LinkedList<Node>();
    boolean[][] visited = new boolean[n][m];
    queue.offer(curt);
    visited[curt.x][curt.y] = true;

    while(!queue.isEmpty()){
        Node now = queue.poll();
        for(int i = 0; i < 4; i++){
            int nextX = now.x + dx[i];
            int nextY = now.y + dy[i];
            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && grid[nextX][nextY] == 0 && !visited[nextX][nextY]){
                distance[k][nextX][nextY] = now.dis + 1;
                queue.add(new Node(nextX, nextY, now.dis + 1));
                visited[nextX][nextY] = true;
            }
        }
    }
}
}



//@author: Tiannan Wang
public int EMPTY = 0;
public int HOUSE = 1;
public int WALL = 2;
public int[][] grid;
public int n, m;
public int[] deltaX = {0, 1, -1, 0};
public int[] deltaY = {1, 0, 0, -1};

private List<Coordinate> getCoordinates(int type) {
    List<Coordinate> coordinates = new ArrayList<>();
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == type) {
                coordinates.add(new Coordinate(i, j));
            }
        }
    }
    
    return coordinates;
}

private void setGrid(int[][] grid) {
    n = grid.length;
    m = grid[0].length;
    this.grid = grid;
}

private boolean inBound(Coordinate coor) {
    if (coor.x < 0 || coor.x >= n) {
        return false;
    }
    if (coor.y < 0 || coor.y >= m) {
        return false;
    }
    return grid[coor.x][coor.y] == EMPTY;
}

/**
 * @param grid a 2D grid
 * @return an integer
 */
public int shortestDistance1(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
        return -1;
    }
    
    // set n, m, grid to local variable 
    setGrid(grid);
    
    List<Coordinate> houses = getCoordinates(HOUSE);
    int[][] distanceSum = new int[n][m];;
    int[][] visitedTimes = new int[n][m];;
    for (Coordinate house : houses) {
        bfs(house, distanceSum, visitedTimes);
    }
    
    int shortest = Integer.MAX_VALUE;
    List<Coordinate> empties = getCoordinates(EMPTY);
    for (Coordinate empty : empties) {
        if (visitedTimes[empty.x][empty.y] != houses.size()) {
            continue;
        }
        
        shortest = Math.min(shortest, distanceSum[empty.x][empty.y]);
    }
    
    if (shortest == Integer.MAX_VALUE) {
        return -1;
    }
    return shortest;
}

private void bfs(Coordinate start,
                 int[][] distanceSum,
                 int[][] visitedTimes) {
    Queue<Coordinate> queue = new LinkedList<>();
    boolean[][] hash = new boolean[n][m];
    
    queue.offer(start);
    hash[start.x][start.y] = true;
    
    int steps = 0;
    while (!queue.isEmpty()) {
        steps++;
        int size = queue.size();
        for (int temp = 0; temp < size; temp++) {
            Coordinate coor = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate adj = new Coordinate(
                    coor.x + deltaX[i],
                    coor.y + deltaY[i]
                );
                if (!inBound(adj)) {
                    continue;
                }
                if (hash[adj.x][adj.y]) {
                    continue;
                }
                queue.offer(adj);
                hash[adj.x][adj.y] = true;
                distanceSum[adj.x][adj.y] += steps;
                visitedTimes[adj.x][adj.y]++;
            } // direction
        } // for temp
    } // while
}

}
