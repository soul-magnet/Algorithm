package BreadthFirstSearch;

/* Given a boolean 2D matrix, 0 is represented as the sea, 
 * 1 is represented as the island. If two 1 is adjacent, 
 * we consider them in the same island. We only consider up/down/left/right adjacent.
 * Find the number of islands.

Example
Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.

Tags: Facebook Google Zenefits*/

public class NumberOfIslands {
	//consize solution - DFS Not Recommended - Indigenous
	private int x, y;
	public int numIslands(char[][] grid){
		
		int count = 0;
		x = grid.length;
		if(x == 0) return 0;
		y = grid[0].length;
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){
				if(grid[x][y] == '1'){
					DFSMarking(grid, i, j);
					++count;
				}
			}
		}
		
		return count;
	}
	
	private void DFSMarking(char[][]grid, int i, int j){
		if(i < 0 || j < 0 || i >= x || j >= y || grid[i][j] != '1'){
			grid[i][j] = '0';
			DFSMarking(grid, i+1, j);
			DFSMarking(grid, i-1, j);
			DFSMarking(grid, i , j+1);
			DFSMarking(grid, i, j-1);
		}
	}
	
	//Union Find - Disjoint Set
	public int numIslandsVersion2 (char[][] grid){
		
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int m = grid.length, n = grid[0].length;
		UnionFind uf = new UnionFind(m, n, grid);
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(grid[i][j] == '0') continue;
				int x = i*n+j;
				int y;
				if(i < m-1 && grid[i+1][j] == '1'){
					y = x+n;
					uf.union(x, y);
				}
				
				if(j < n-1 && grid[i][j+1] == '1'){
					y = x+1;
					uf.union(x, y);
				}
			}
		}
		
		return uf.count;
	}
	
	class UnionFind{
		public int count;
		public int[] parents;
		public UnionFind(int m , int n, char[][]grid){
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					if(grid[i][j] == '1') count++;
				}
			}
			parents = new int[m*n];
			for(int i = 0; i < m*n; i++) parents[i] = i;
		}
		
		public int find(int i){
			if (i == parents[i]) return i;
			parents[i] = find(parents[i]);
			return parents[i];
		}
		
		public void union(int i, int j){
			int pi = find(i);
			int pj = find(j);
			if(pi == pj) return;
			else parents[pi] = pj;
			count--;
		}
	}
	
	//Add BFS Solution here

}
