package main.java.ladders.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 477. Surrounded Regions 

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O''s into 'X''s in that surrounded region.

Example
X X X X
X O O X
X X O X
X O X X
After capture all regions surrounded by 'X', the board should be:

X X X X
X X X X
X X X X
X O X X

Tags:Union Find Breadth First Search

Related Problems 
Medium Nearest Exit 32 %
Hard Number of Islands II 19 %
Easy Number of Islands 25 %
 * */
public class SurroundedRegions {
	 /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
	
	//BFS Solution - didn't pass OJ
	public void surroundedRegions(char[][] board) {
		if(board == null || board.length == 0) return;
		
		int n = board.length, m = board[0].length;
		
		for(int i = 0; i < n; i++) {
			bfs(board, i, 0);
			bfs(board, m -1, i);
		}
		
		for(int i = 0; i < m; i++) {
			bfs(board, 0, i);
			bfs(board, m - 1, i);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++){
				if(board[i][j] == '#'){
					board[i][j] = 'O';
				}else if(board[i][j] == 'O'){
					board[i][j] = 'X';
				}
			}
		}
		
		
	}
	
	private void bfs(char[][] board, int i, int j) {
		if(board[i][j] != '0') return;
		
		int n = board.length, m = board[0].length;
		board[i][j] = '#';
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(i * m + j);
		while(!queue.isEmpty()) {
			int pos = queue.poll();
			int row = pos / m, col = pos % m;
			if(row > 0 && board[row - 1][col] == 'O'){
                queue.offer((row - 1) * n + col);
                board[row - 1][col] = '#';
            }
            if(row < m - 1 && board[row + 1][col] == 'O'){
                queue.offer((row + 1) * n + col);
                board[row + 1][col] = '#';
            }
            if(col > 0 && board[row][col - 1] == 'O'){
                queue.offer(row * n + col - 1);
                board[row][col - 1] = '#';
            }
            if(col < n - 1 && board[row][col + 1] == 'O'){
                queue.offer(row * n + col + 1);
                board[row][col + 1] = '#';
            }
		}
	}
	
	
	
	//DFS Solution
	public void surroundedRegions1(char[][] board) {
		if(board == null || board.length < 2 || board[0].length < 2) return;
		
		int n = board.length;
		int m = board[0].length;
		
		for(int i = 0; i < n; i++) {
			dfs(board, i, 0);
			dfs(board, i, board[0].length - 1);
		}
		
		for(int i = 0; i < m; i++) {
			dfs(board, 0, i);
			dfs(board, board.length - 1, i);
		}
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 'B') {
					board[i][j] = 'O';
				}else if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
		
		
	}
	
	static int directions[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	private void dfs(char[][] board, int x, int y) {
		if(board[x][y] == 'O') {
			board[x][y] = 'B';
			for(int i[] : directions) {
				int new_x = x +i[0];
				int new_y = y + i[1];
				if(new_x<board.length&&new_x>-1&&new_y>-1&&new_y<board[0].length&&board[new_x][new_y]=='O'){
                    dfs(board,new_x,new_y);
                }
			}
		}
	}

}
