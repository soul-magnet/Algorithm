package matrix;
/*
 * Given a boolean 2D matrix, find the number of islands.
 * Example: Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.

Note
0 is represented as the sea, 1 is represented as the island. 
If two 1 is adjacent, we consider them in the same island. 
We only consider up/down/left/right adjacent.

*Analysis: Use DFS to find number of connected components of the graph.
*One full DFS traversal of a node yields a connected component, 
*which could be viewed as an island containing adjacent nodes
*by left, right, up and down. Then we could traverse other isolated node 
*excluded from this connected component, in the same manner.
*
*/
public class NumberOfIslands {
	/**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0){
        	return 0;
        }
        
        final int n = grid.length;
        final int m = grid[0].length;
        final boolean visited[][] = new boolean[n][m];
        int count = 0;
        
        for (int i = 0; i < n; i++){
        	for (int j = 0; j < m; j++){
        		if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
        		}
        	}
        }
        
        return count;
        
    }
    
    private void dfs(char[][] grid, int i, int j, boolean[][] visited){
    	if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
    		return;
    	} else if (visited[i][j] || grid[i][j] != '1'){
    		return;
    	}
    	visited[i][j] = true;
    	dfs(grid, i - 1, j, visited);
    	dfs(grid, i + 1, j, visited);
    	dfs(grid, i, j - 1, visited);
    	dfs(grid, i, j + 1, visited);
    }
}
