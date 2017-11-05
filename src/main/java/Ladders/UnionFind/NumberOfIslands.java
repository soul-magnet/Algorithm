package UnionFind;

import java.util.LinkedList;

/**
 * Version 1:Union Find - leetcode
 * Thoughts: I separate all the union find logic in a separate class and 
 * use 1d version to make the code clear. I also use a 2d array 
 * for the 4 direction visit. int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
 * */
public class NumberOfIslands {
	int[][] distance = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	  public int numIslands(char[][] grid) {
		  if(grid == null || grid.length == 0 || grid[0].length == 0){
			  return 0;
		  }
		  
		  UnionFind uf = new UnionFind(grid);
		  int rows = grid.length;
		  int cols = grid[0].length;
		  for(int i = 0; i < rows; i++){
			  for(int j = 0; j < cols; j++){
				  if(grid[i][j] == '1'){
					  for(int[] d : distance){
						  int x = i +d[0];
						  int y = j +d[1];
						  if(x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1'){
							  int id1 = i*cols+j;
							  int id2 = x*cols+y;
							  uf.union(id1, id2);
						  }
					  }
				  }
			  }
		  }
		  return uf.count;
	  }

}

class UnionFind {
	int[] father;
	int m, n;
	int count = 0;
	UnionFind(char[][] grid){
		m = grid.length;
		n = grid[0].length;
		father = new int[m*n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j <n; j++){
				if(grid[i][j] == '1'){
					int id = i * n + j;
					father[id] = id;
					count++;
				}
			}
		}
	}
	
	public void union(int node1, int node2){
		int find1 = find(node1);
		int find2 = find(node2);
		if(find1 != find2){
			father[find1] = find2;
			count--;
		}
	}
	
	public int find(int node){
		if(father[node] == node){
			return node;
		}
		father[node] = find(father[node]);
		return father[node];
	}
}
////////////////////////////////////////////////////////////
/**
 * Version 2 - BFS
 * LeetCode
 * */
class Solution3{
	public int numIslands(char[][] grid){
		int count=0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == '1'){
					bfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void bfs(char[][]grid, int x, int y){
		grid[x][y]='0';
		int n = grid.length;
		int m = grid[0].length;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int node = x*m+y;
		queue.offer(node);
		while(!queue.isEmpty()){
			node = queue.poll();
			int i = node/m;
			int j = node%m;
			if(i > 0 && grid[i-1][j]=='1'){ //search upward and mark adjacent '1's as '0' 
				queue.offer((i-1)*m+j);
				grid[i-1][j] = '0';
			}
			if(i<n-1 && grid[i+1][j]=='1'){ //down 
		         queue.offer((i+1)*m+j);  
		         grid[i+1][j]='0';  
		     }  
		     if(j>0 && grid[i][j-1]=='1'){  //left
		    	 queue.offer(i*m+j-1);  
		         grid[i][j-1]='0';  
		     }  
		     if(j<m-1 && grid[i][j+1]=='1'){  //right
		    	 queue.offer(i*m+j+1);  
		    	 grid[i][j+1]='0';  
		     }
		}
	}
}




////////////////////////////////////////////////////////////
/**UnionFind LintCode*/
class Solution2 {
	/**
	 * @param grid a boolean 2D matrix
	 * @return an integer
	 */
	private int n, m;
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, 1, -1, 0};
	public int numIslands(boolean[][] grid) {
		int count = 0;
		n = grid.length;
		if(n == 0) return 0;
		
		m = grid[0].length;
		if(m == 0) return 0;
		
		for(int i = 0; i < n; i++){
			for(int j=0; j <m; j++){
				UnionFind(i, j, grid);
				count++;
			}
		}
		return count;
	}
	private void UnionFind(int i, int j, boolean[][] grid) {
		
		grid[i][j] = false;
		for(int k=0; k < 4; k++){
			int x = i+dx[k];
			int y = j+dy[k];
			if(x < n && y < m && x >= 0 && y >= 0 && grid[x][y]==true){
				UnionFind(x, y, grid);
			}
		}
	}
	
}

