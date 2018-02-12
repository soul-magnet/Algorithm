package main.java.ladders.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

import main.java.ladders.BreadthFirstSearch.KnightShortestPath2.Point;

/**
 * 
 * 750. Portal - Medium

Chell is the protagonist of the Portal Video game series developed by Valve Corporation.
One day, She fell into a maze. The maze can be thought of as an array of 2D characters of size n x m. 
It has 4 kinds of rooms. 'S' represents where Chell started(Only one starting point). 
'E' represents the exit of the maze(When chell arrives, she will leave the maze, 
this question may have multiple exits). '*' represents the room that Chell can pass. '#' represents a wall, 
Chell can not pass the wall. 

She can spend a minute moving up,down,left and right to reach a room, but she can not reach the wall.
Now, can you tell me how much time she needs at least to leave the maze?
If she can not leave, return -1.

 Notice
We guarantee that the size of the maze is n x m, and 1<=n<=200,1<=m<=200.
There is only one 'S', and one or more 'E'.

Example
Give
[
['S','E','*'],
['*','*','*'],
['*','*','*']
]
,return 1.

Explanation:
Chell spent one minute walking from (0,0) to (0,1).
Give
[
['S','#','#'], 
['#','*','#'], 
['#','*','*'], 
['#','*','E']
]
,return -1.

Explanation:
Chell can not leave the maze.
Give
[
['S','*','E'], 
['*','*','*'], 
['#','*','*'], 
['#','#','E']
]
,return 2.

Explanation:
First step: Chell move from (0,0) to (0,1).
Second step: Chell move from (0,1) to (0,2).
(Chell can also leave from (3,2), but it would take 5 minutes. So it's better to leave from (0,2).)
Give
[
['E','*','#'],
['#','*','#'],
['#','*','*'],
['#','#','S']
]
,return 5.

Explanation:
First step: Chell move from (0,0) to (0,1).
Second step: Chell move from (0,1) to (1,1).
Third step: Chell move from (1,1) to (2,1).
Fourth step: Chell move from (2,1) to (2,2).
Fifth step: Chell move from (2,2) to (3,2).

Tags:Breadth First Search

Related Problems 
Medium Knight Shortest Path 23 %
Medium Graph Valid Tree 27 %
 * */
public class Portal {
	
	/**
     * @param Maze: 
     * @return: nothing
     */
	
	private class Point{
        int x, y, step;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int Portal(char[][] Maze) {
        // Write your code here 
    	if(Maze == null || Maze.length == 0 | Maze[0].length == 0) return -1;
    	
    	Queue<Point> queue = new LinkedList<Point>();
    	
    	int dimentionX[] = {-1, 1, 0, 0};
    	int dimentionY[] = {0, 0, -1, 1};
    	
    	int n = Maze.length;
    	int m = Maze[0].length;
    	
    	int sx = 0, sy = 0;
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(Maze[i][j] == 'S') {
    				//starting point is found
    				sx = i;
    				sy = j;
    			}
    		}
    	}
    	
    	Point start = new Point(sx, sy);
    	queue.offer(start);
    	
    	while(!queue.isEmpty()) {
    		int size = queue.size();
	      	for(int i = 0; i < size; i++) {
	    		Point node = queue.poll();
	    		if(node.x == 'E' && node.y == 'E') 
					return node.step;
				
	    		for(int j = 0; j < 4; j++) {
	    			Point next =  new Point(node.x + dimentionX[j], node.y + dimentionY[j]);
	    			 if(inBound(Maze, next)){
	                     queue.offer(next);
	                 }
	    		}
	      	}
	      	
	    	node.step ++;
    	}//end of while
    	
    	return -1;
    }
    
    private boolean inBound(char[][]Maze, Point pt) {
    	return pt.x < 0 && pt.x >= Maze.length && 
    			pt.y < 0 && pt.y >= Maze[0].length &&
    			Maze[pt.x][pt.y] == '#' &&
    			Maze[pt.x][pt.y] <= pt.step;
    }
    
    //Juizhang Solution
    class  node {
        int x, y;
		static int step;
    }
    public int Portal1(char[][] Maze) {
        //
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        int n = Maze.length;
        int m = Maze[0].length;
        int sx = 0, sy = 0;
        int step[][] = new int[201][201];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                step[i][j] = 99999;
                step[i][j] = 99999;
                if(Maze[i][j] == 'S') {
                    sx = i;
                    sy = j;
                    step[sx][sy] = 0;
                }
            }
        }
        node Start = new node();
        Start.x = sx;Start.y = sy;Start.step = 0;
        Queue<node> queue = new LinkedList<node>();
        queue.offer(Start);
        while(!queue.isEmpty()) {
            node head = queue.poll();
            for (int i = 0; i < 4; i++) {
                node New = new node();
                New.x = head.x + dx[i];
                New.y = head.y + dy[i];
                New.step = head.step + 1;
                if(New.x < 0 || New.x >= n || New.y < 0 || New.y >= m || Maze[New.x][New.y] == '#') {
                    continue;
                }
                if (step[New.x][New.y] <= New.step) {
                    continue;
                }
                step[New.x][New.y] = New.step;
                if (Maze[New.x][New.y] == 'E')
                    return New.step;
                queue.offer(New);
            }
        }
        return -1;
    }

}
